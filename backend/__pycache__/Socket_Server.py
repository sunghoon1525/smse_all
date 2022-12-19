import socket
import login

host = ''
port = 9999
 
server_sock = socket.socket(socket.AF_INET)
server_sock.bind((host, port))
server_sock.listen(1)
 
while True:
    print("기다리는 중")
    client_sock, addr = server_sock.accept()
 
    print('Connected by', addr)
    data1 = client_sock.recv(1024)
    data1 = data1.decode()

    # index = data1.index("/")    

    # data_id = data1[:index]
    # data_pw = data1[index:]
    # print(data_id, data_pw)

    while True:
        # 클라이언트에서 받을 문자열의 길이
        data1 = client_sock.recv(4)
        length = int.from_bytes(data1, "little")
        # 클라이언트에서 문자열 받기
        msg = client_sock.recv(length)
 
        # data를 더 이상 받을 수 없을 때
        if len(data1) <= 0:
            break
 
        msg = msg.decode()

        if "login" in msg: # 로그인을 하고자 할 때
            msg = msg.replace("login/", "")
            print(msg)
            index = msg.find("/")
            id_data = msg[:index]
            pw_data = msg[index+1:]
            print(id_data, " ", pw_data)

            check = str(login.checkIdPw(id_data, pw_data)) # 결과값을 인코딩해서 전달
            
            client_sock.sendall(check.encode())
            print(check)
        

    client_sock.close()
    server_sock.close()