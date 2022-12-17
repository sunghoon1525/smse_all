import pymysql

# MySQL Connection 연결
conn = pymysql.connect(host='localhost', user='root', password='cs2021', db='smse_all', charset='utf8')

# Connection 으로부터 Cursor 생성
curs = conn.cursor()

# # SQL문 실행
# sql = "select * from test"
# curs.execute(sql)

# # 데이타 Fetch
# rows = curs.fetchall()

# for i in rows:
#     print (i)



# Connection 닫기
conn.close()
