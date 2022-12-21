import pymysql

# MySQL Connection 연결
# conn = pymysql.connect(host='192.168.0.22', user='newuser', password='Smse_all123', db='SMSE_ALL', charset='utf8')
conn = pymysql.connect(host='localhost', user='root', password='12345678', db='SMSE_ALL', charset='utf8')

# Connection 으로부터 Cursor 생성
curs = conn.cursor()

def insertMsg(title : str, msg : str, channel, receiver_grade, receiver_affiliation, sender_id):
    try:
        sql = "insert into Message VALUE (DEFAULT, '%s', '%s', CURRENT_TIME(), %d, %d, '%s', %d);" % (title, msg, channel, receiver_grade, receiver_affiliation, sender_id)
        curs.execute(sql)
        conn.commit()
        if curs.rowcount > 0: # 바뀐 열이 0이상 즉, 존재한다면 return값을 True
            return True
        else: # 바뀐 열이 없다면 >> update가 이루어지지 않았다면 return값을 False
            return False
    finally:
        pass