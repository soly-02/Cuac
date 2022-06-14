# this script updates user's notifications
# run this script from a task scheduler/cronjob and make sure that the local date and time is correct
# requirements: Python3 and mySQL connector (python -m pip install mysql-connector-python)

from datetime import datetime
import mysql.connector
import re

def days_past(dateOfInfection):
	today = datetime.today()
	datetime_object = datetime.strptime(dateOfInfection, '%d/%m/%Y')
	delta = today - datetime_object
	return delta.days



db = mysql.connector.connect(
  host="localhost",
  user="root",
  password="password", 
  database = "cuac"
)

def deleteInfectionDate():
	cursorSelect = db.cursor()
	cursorSelect.execute("SELECT infectionDate FROM usertable")
	result = cursorSelect.fetchall()

	for i in result:
		if(i[0]):
			print(days_past(i[0]))
		# if(i[0] and days_past(i[0]) > 5):
		# 	cursorNull = db.cursor()
		# 	nullquery = "UPDATE usertable SET infectionDate = NULL, notifType2 = NULL WHERE infectionDate = %s"
		# 	dateToDelete = i
		# 	cursorNull.execute(nullquery, dateToDelete)
		# 	db.commit()
			

def deleteNotifType3():
	cursorSelect = db.cursor()
	cursorSelect.execute("SELECT email, notifType3 FROM usertable")
	result = cursorSelect.fetchall()
	
	for i in result:
		
		if(i[1]):
			notifList = i[1].split("$$")
			newMessage = ''
			for message in notifList:
				
				date = re.search(r'(3[01]|[12][0-9]|0?[1-9])/(1[0-2]|0?[1-9])/(?:[0-9]{2})?[0-9]{2}', message)
				if(days_past(str(date)) > 5):
					continue
				else:
					newMessage += message + "$$"
			if (newMessage == ''):
				query = "UPDATE usertable SET notiftype3 = NULL WHERE email = %s"
			else:
				query = "UPDATE usertable SET notiftype3 = ", newMessage ," WHERE email = %s"	
			cursorNull = db.cursor()
			email = i[0]
			cursorNull.execute(query, email)
			db.commit()

deleteInfectionDate()        
db.close()