import db_connector

conn = db_connector.conn
curs = conn.cursor()

def imsertUser(user_id, id, password, email,name, student_id, grade, major, birth ): #입력받은 id와 pw를 넣어주면 DB에 존재하는 계정인지 확인하고 불린값을 리턴해주는 함수
    sql = "select id, password from users" 
    curs.execute(sql)
    rows = curs.fetchall()

    #users DB에서 ID와 비번 찾아오기
    for i in rows:
        get_id = i[0]
        get_pw = i[1]
    if id == get_id & pw == get_pw: # 함수 입력값이랑 비교
        return True
        


# Connection 닫기
conn.close()
