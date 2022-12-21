import pymysql

# MySQL Connection 연결
conn = pymysql.connect(host='localhost', user='root', password='12345678', db='SMSE_ALL', charset='utf8')
# conn = pymysql.connect(host='localhost', user='root', password='12345678', db='SMSE_ALL', charset='utf8')
# Connection 으로부터 Cursor 생성
curs = conn.cursor()

def findMessage(user_id : int, channel : int):
    try:
        with conn.cursor() as curs:
            conn.connect()
            curs.execute("SELECT grade from user_detail where user_id = %d" % (user_id))
            grade = curs.fetchall()[0][0]
            curs.execute("SELECT affiliation_id from user_affiliation where user_id = %d" % (user_id))
            affil = curs.fetchall()[0][0]
            curs.execute("SELECT message_title, message, send_time, sender_id FROM Message WHERE (receiver_grade = %d or receiver_affiliation = %d) and channel = %d ORDER BY send_time ASC LIMIT 1" % (grade, affil, channel))
            message = curs.fetchall()
            if not message:
                return None
            else:
                message = message[0]
                curs.execute("SELECT name FROM user_detail WHERE user_id = %d" % (message[3]))
                sender = curs.fetchall()[0][0]
                listMsg = list(message)
                listMsg[2] = listMsg[2].strftime("%Y년 %m월 %d일 %H시 %M분")
                listMsg[3] = sender
                listMsg = listMsg[0]+"-+-"+listMsg[1]+"-+-"+listMsg[2]+"-+-"+listMsg[3]
                return listMsg
    finally:
        pass
# def titleMsg(message_id : int):
#     curs.execute("SELECT message_title, message FROM Message WHERE message_id = %d" % (message_id))
#     msg = curs.fetchall()
#     return msg[0]
