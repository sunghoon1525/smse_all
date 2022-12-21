import pymysql

# MySQL Connection 연결
conn = pymysql.connect(host='localhost', user='root', password='12345678', db='SMSE_ALL', charset='utf8')

# Connection 으로부터 Cursor 생성
curs = conn.cursor()

def grade_change(id, grade):

    user_id = "SELECT user_id FROM Users WHERE id = '%s'" # 이름과 학년을 변수를 넣어둔 쿼리문 / 이름은 '' 안에 들어있음
    curs.execute(user_id % (id)) # 쿼리문에 name인자를 변수로 넣어줌
    user_id = curs.fetchall()
    id = user_id[0][0] # 튜플형식이기 때문에 아이디만 가져오기 위해서 인덱스 값을 설정
    update_grade = "UPDATE User_detail SET grade = %d WHERE user_id = %d"
    curs.execute(update_grade % (grade, id))
    curs.fetchall()
    conn.commit() # sql에 즉각 업데이트 할 수 있도록
    if curs.rowcount > 0: # 바뀐 열이 0이상 즉, 존재한다면 return값을 True
        return True
    else: # 바뀐 열이 없다면 >> update가 이루어지지 않았다면 return값을 False
        return False