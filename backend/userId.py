import pymysql

# MySQL Connection 연결
conn = pymysql.connect(host='localhost', user='root', password='12345678', db='SMSE_ALL', charset='utf8')
# conn = pymysql.connect(host='localhost', user='root', password='12345678', db='SMSE_ALL', charset='utf8')

# Connection 으로부터 Cursor 생성
curs = conn.cursor()

def checkID(id : str)-> int: 
    try:
        find_id = "SELECT user_id FROM Users WHERE id = '%s';" # 이름과 학년을 변수를 넣어둔 쿼리문 / 이름은 '' 안에 들어있음
        curs.execute(find_id % (id)) # 쿼리문에 name인자를 변수로 넣어줌
        find_id = curs.fetchall()
        int_id = find_id[0][0] # 튜플형식이기 때문에 아이디만 가져오기 위해서 인덱스 값을 설정
        return int_id
    finally:
        pass
