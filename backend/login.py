import pymysql

# MySQL Connection 연결
conn = pymysql.connect(host='localhost', user='root', password='12345678', db='SMSE_ALL', charset='utf8')

# Connection 으로부터 Cursor 생성
curs = conn.cursor()

def checkIdPw(id : str, pw : str): #입력받은 id와 pw를 넣어주면 DB에 존재하는 계정인지 확인하고 불린값을 리턴해주는 함수    
    curs.execute("select * from Users where id = '%s' and password = '%s'" % (id, pw))
    rows = curs.fetchall()
    conn.commit()
    if len(rows) > 0:
        return True
    else:
        return False