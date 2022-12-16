# import db_connector

# def Message(user_id : int):
#     """
#     학년과 소속이 같을 경우 뽑아내야함
#     1. 사용자의 아이디 가져오기 -> 이건 앱 실행 중에 해야하는 것
#     2. User_detail에서 id 가져오기
#     3. 위에가 같을 경우 실행해야함
#     4. User_detail에서 id로 학년 가져오기
#     5. id로 affiliation_id 가져오기 (모두)
#     6. 학년과 소속id가 같은 메세지 모두 가져오기
#     """
#     id_fromsql = "select user_id from User_detail " # 사용자 id를 테이블에서 가져오기
#     curs.execute(id_fromsql)
#     id = curs.fetchall()
#     # id 전처리 한번 더 하기

#     # 조건문 달아서 그 뒤로 실행할 수 있도록

#     def grade(): #학년 가져오기
#         grade_fromsql = "select user_id, grade from User_detail"
#         curs.execute(grade_fromsql)
#         grade = curs.fetchall()
#         for i in grade:
#             if i[0] == id[0][0]:
#                 return (i[1]) #학년 가져옴

#     def affiliation():
#         affiliation_fromsql = "select user_id from User_affiliation"
#         curs.execute(affiliation_fromsql)
#         affil_rows = curs.fetchall()
#         print(affil_rows[0][0])
#         return None
#     affiliation()
    
#     def message_check():
#         message_sql = "select message_title, message, send_time, channel, receiver_grade, receiver_affiliation from Message"
#         curs.execute(message_sql)
#         message_sql = curs.fetchall()
#         # print(message_sql)
#         return message_sql
#     message_check()
#     return None

# Message(1)