# this script updates the seatlog table and deletes logs older than 10 days
# run this script from a task scheduler/cronjob and make sure that the local date and time is correct
# requirements: Python3 and mySQL connector (python -m pip install mysql-connector-python)

from datetime import datetime
import mysql.connector

def days_past(dateOfInfection):
	today = datetime.today()
	datetime_object = datetime.strptime(dateOfInfection, '%d/%m/%Y')
	delta = today - datetime_object
	return delta.days


if __name__ == "main":
	db = mysql.connector.connect(
	host="localhost",
	user="root",
	password="password", 
	database = "cuac"
	)


	cursorSelect = db.cursor()
	cursorSelect.execute("SELECT date FROM seatlog")
	result = cursorSelect.fetchall()

	for i in result:
		if(days_past(i[0]) > 10):
			cursorDel = db.cursor()
			delquery = "DELETE FROM seatlog WHERE date = %s"
			dateToDelete = i
			cursorDel.execute(delquery, dateToDelete)
			db.commit()
			#print("row deleted")
			
	db.close()
