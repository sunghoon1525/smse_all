import socket
import sys
import login
import userId
import send
import messages

host = ''
port = 9999

server_sock = socket.socket(socket.AF_INET)
server_sock.bind((host, port))
server_sock.listen(5)
 
while True:
    print("기다리는 중")
    client_sock, addr = server_sock.accept()
 
    print('Connected by', addr)
    data1 = client_sock.recv(1024)
    data1 = data1.decode()

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
            msg = msg.split("/")
            id = str(msg[0].replace('\'', ''))
            pw = str(msg[1].replace('\'', '').strip())

            check1 = str(login.checkIdPw(id, pw)) # 결과값을 인코딩해서 전달
            print(check1)
            
            if check1 == "True":
                user_id = userId.checkID(msg[0])
            else:
                user_id = None
            client_sock.sendall(check1.encode())

        if "send" in msg:
            msg = msg.replace("send/", "")
            msg = msg.split("/")
            channel = int(msg[2].replace('\'', ''))
            grade = int(msg[3].replace('\'', ''))
            check2 = str(send.insertMsg(msg[0], msg[1], channel, grade, None, user_id))
            client_sock.sendall(check2.encode())
            print(check2)
    
        if "notice" in msg:
            check3 = str(messages.findMessage(user_id, 1))
            client_sock.sendall(check3.encode())
            print(check3)