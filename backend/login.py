import pymysql

# MySQL Connection 연결
conn = pymysql.connect(host='localhost', user='root', password='12345678', db='SMSE_ALL', charset='utf8')

# Connection 으로부터 Cursor 생성
curs = conn.cursor()

def checkIdPw(id : str, pw : str ): #입력받은 id와 pw를 넣어주면 DB에 존재하는 계정인지 확인하고 불린값을 리턴해주는 함수    
    sql = "select id, password from Users" 
    curs.execute(sql)
    
    rows = curs.fetchall()

    #users DB에서 ID와 비번  
    for i in rows:
        get_id = str(i[0])
        get_pw = str(i[1])
        if (id == get_id) and (pw == get_pw): # 함수 입력값이랑 비교
            return True
        else:
            return False
    conn.close()