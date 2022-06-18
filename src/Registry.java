import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Registry {  // CONTROLLER CLASS connected with the database
	
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement prep = null;
    private ResultSet rs = null;
	 
	
	public Registry() throws SQLException {
		String url = "jdbc:mysql://";
		String usernamedb;
		String passworddb;
		
		Properties prop = new Properties();
		String fileName = "database\\db-credentials.config";
		try (FileInputStream fis = new FileInputStream(fileName)) {
		    prop.load(fis);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		usernamedb = prop.getProperty("username");
		passworddb = prop.getProperty("password");
		url += prop.getProperty("url") + ":" + prop.getProperty("port") + "/" + prop.getProperty("database");

		System.out.println("Connecting database...");
		connect = DriverManager.getConnection(url, usernamedb, passworddb);	
	}
	
	public void closeConnection() {
		try {
			connect.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean login(String email, String password) { // If the user chose to sign in / login (already has an account)
		String emailFromDB=null;
		String passwordFromDB=null;
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("SELECT email, password FROM usertable WHERE email=" + "'"+ email + "'" +";"); //gets email and password from database
			
			while(rs.next()) {
				
				emailFromDB = rs.getString("email");
				passwordFromDB = rs.getString("password");
				
				if (emailFromDB.equals(email)) {
					System.out.println("Email is in DB");                    //if email exists in databes
					if(passwordFromDB.equals(password)) {
						System.out.println("Password correct, log in complete");    //if the entered password was correct
						return true;
					}
					else { 
						System.out.println("Password wrong, try again");         //if the entered password was wrong
					    return false;
					}	
			}
		}
					
			statement.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL Error in login");
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean register(String email, String password) { // If the user chose to register a new account (doesn't have an account)
		try {
			String addUserQuery = "INSERT INTO usertable (email, password)" + "VALUES (?,?)";
			prep = connect.prepareStatement(addUserQuery);
			prep.setString(1, email);
			prep.setString(2, password);
			prep.executeUpdate();
			prep.close();
		}
		catch(java.sql.SQLIntegrityConstraintViolationException s) {//attempt to insert an existing email
			System.out.println("user already exists");
			return false;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	// Method that returns the saved path to a user's pdf file, containing their covid-certificate from the database
	public String getFilePath(String email){ // it returns null (as a String) if there is no path for the PDF file
		String pathToPDF=null;
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("SELECT pdfPath FROM usertable WHERE email=" + "'"+ email + "'" +";");
			
			while(rs.next()) {
				pathToPDF = rs.getString("pdfPath");
			}
			statement.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pathToPDF;
	}
	
	
	
	// Method that saves the selected path to a user's pdf file, containing their covid-certificate in the database
	public void setFilePath(String email, String newPath) { //changes the path to PDF.
		try {
			String addPDFPathQuery = "UPDATE usertable SET pdfPath=? WHERE email=" + "'"+ email + "'" +";";
			prep = connect.prepareStatement(addPDFPathQuery);
			prep.setString(1, newPath);
			
			prep.executeUpdate();
			prep.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method that returns the saved expiration date of to a user's pdf file, containing their covid-certificate from the database
	public String getPdfDate(String email){ // it returns null (as a String) if there is no date for the PDF file
		String dateofPDF=null;
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("SELECT walletDate FROM usertable WHERE email=" + "'"+ email + "'" +";");
			
			while(rs.next()) {
				dateofPDF = rs.getString("walletDate");
			}
			statement.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateofPDF;
	}
	
	// Method that saves the expiration date of to a user's pdf file, containing their covid-certificate from the database
	public void setPdfDate(String email, String newWalletDate) { 
		try {
			String addWalletDateQuery = "UPDATE usertable SET walletDate=? WHERE email=" + "'"+ email + "'" +";";
			prep = connect.prepareStatement(addWalletDateQuery);
			prep.setString(1, newWalletDate);
			
			prep.executeUpdate();
			prep.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 // Method that saves a user's seat-information in the database
	public void uploadSeat(String email, int classID, int seatId, String start, String end, String date) {
		try {
			String addSeatQuery = "INSERT INTO seatlog (email, classID, seatID, starttime, endtime, date)" + "VALUES (?,?,?,?,?,?)";
			prep = connect.prepareStatement(addSeatQuery);
			prep.setString(1, email);
			prep.setInt(2, classID);
			prep.setInt(3, seatId);
			prep.setString(4, start);
			prep.setString(5, end);
			prep.setString(6, date);
			prep.executeUpdate();
			prep.close();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Method that saves a user's date of infection in the database
	public void setInfectionDate(String email, String date) {
		try {
			String addInfectionDateQuery = "UPDATE usertable SET infectionDate=? WHERE email=" + "'"+ email + "'" +";";
			prep = connect.prepareStatement(addInfectionDateQuery);
			prep.setString(1, date);
			
			prep.executeUpdate();
			prep.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Method that returns a user's date of infection from the database
	public String getInfectionDate(String email){
		String dateofInfection=null;
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("SELECT infectionDate FROM usertable WHERE email=" + "'"+ email + "'" +";");
			
			while(rs.next()) {
				dateofInfection = rs.getString("infectionDate");
			}
			statement.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dateofInfection;
	}
	
	
	// Method that fetches all the previous seats the user has sat on, 3 days before they where diagnosed with covid
	// from the database
	public  ArrayList<String> getPreviousSeats(String email) {
		
		
		
		ArrayList<String> UserCodes = new ArrayList<String>() ;// array that stores all the user's seat-info 3 days before diagnosis
		String code= null;
		String[] date = getInfectionDate(email).split("/");
		
		
	   	 Calendar cal_of= new GregorianCalendar(); //MERA POY NOSISE
		 
	   	     ArrayList<Calendar> cals= new ArrayList<Calendar>();
			 cal_of.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date[0])); // MERA NOSISIS			 
			 cal_of.set(Calendar.MONTH, Integer.parseInt(date[1]) -1);
			 cal_of.set(Calendar.YEAR, Integer.parseInt(date[2]));
			 cals.add(cal_of);
				 
				 
			 Calendar cal_1= new GregorianCalendar();
			 cal_1= (Calendar) cal_of.clone();            //MIA MERA PRIN
			 cal_1.add(Calendar.DAY_OF_MONTH,-1);
			 cals.add(cal_1);
				 
	         Calendar cal_2= new GregorianCalendar();
	         cal_2= (Calendar) cal_of.clone();              //DYO MERES PRIN
	         cal_2.add(Calendar.DAY_OF_MONTH,-2);
	         cals.add(cal_2);
				 
	         Calendar cal_3= new GregorianCalendar();
	         cal_3= (Calendar) cal_of.clone();             //TREIS MERES PRIN
	         cal_3.add(Calendar.DAY_OF_MONTH,-3);
	         cals.add(cal_3);
	        System.out.println((cals.get(0)).get(Calendar.DATE)+ "/" +(cals.get(0).get((Calendar.MONTH))+1)+ "/" + cals.get(0).get(Calendar.YEAR));
		
		      String dateTry; 
	         for (int i=0; i<cals.size(); i++) {
	        	 dateTry=  cals.get(i).get(Calendar.DATE)+ "/" +(cals.get(0).get((Calendar.MONTH))+1)+ "/" + cals.get(i).get(Calendar.YEAR);
	        	 
	        	 try {
	     			statement = connect.createStatement();
	     			rs = statement.executeQuery("SELECT *  FROM seatlog WHERE email="+ "'"+ email+ "'" + "AND date="+ "'"+ dateTry+"'" );
	     		
	     			while(rs.next()) {
	     			UserCodes.add((rs.getString("email")+ "/" + rs.getString("classID")+ "/" + rs.getString("seatId") + "/" + rs.getString("starttime")+ "/" + rs.getString("endtime")+ "/" + rs.getString("date")));
	     			
	     			}
	     			statement.close();
	     			
	     		}

	        	 catch (SQLException e) {
	     			// TODO Auto-generated catch block
	     			e.printStackTrace();
	     		}
	        	 
	        	 
	        	 
	        	 
	         }
	         
	         return UserCodes; 
	         }
		
		
	// method that notifies other users of the app that were sat next to the infected user, it stores messages in the database
	public ArrayList <String> notifyPotentiallyInfected(ArrayList <String> UserCodes, String email) {
		Classroom c1= new Classroom(1);
		String[] data;
		String[] nearSeats;
		String person[];
		String person2;
		String seat;
		int classID;
		int seatID;
		ArrayList <String> mustNotify= new ArrayList <String>();
		for (int i=0; i< UserCodes.size(); i++) {
		
			data = UserCodes.get(i).toString().split("/");
			classID= Integer.parseInt( data [1]);
			seatID=Integer.parseInt(data[2]);
			
			System.out.println(""+classID+seatID );
			
			seat=c1.getSeatInfo(seatID,classID).toString();
			
			nearSeats= seat.replace("[", "").replace("]", "").replace(" ", "").replace(" ", "").split(",");
			
			for (int i1=0; i1< nearSeats.length; i1++) {
				
				if (Integer.parseInt(nearSeats[i1])!=0) {
	        	 
	        	 try {
	     			statement = connect.createStatement();
	     			rs = statement.executeQuery("SELECT *  FROM seatlog WHERE email!="+"'"+ email+ "'"+ " AND date="+ "'"+data[5]+"/"+data[6]+"/"+data[7] +"'" 
	     					+"AND classId="+"'" + data[1]+"'" + "AND SeatId="+"'" +Integer.parseInt(nearSeats[i1])+"'");
	     					
	     			
	     		
	     			while(rs.next()) {
	     			person2 = ((rs.getString("email")+ "/" + rs.getString("classID")+ "/" + rs.getString("seatId") + "/" + rs.getString("starttime")+ "/" + rs.getString("endtime")+ "/" + rs.getString("date")));
	     			person= person2.split("/");
	     			if (person[3].indexOf(':')!=-1) {
	     				person[3]= person[3].length() < 2 ? person[3] : person[3].substring(0, 2);
	     				
	     			}
	     			if (person[4].indexOf(':')!=-1) {
	     				person[4]= person[4].length() < 2 ? person[4] : person[4].substring(0, 2);
	     				
	     			}
	     			
	     			if (!(Integer.parseInt(data[3])>Integer.parseInt(person[4]))& !(Integer.parseInt(data[4])<Integer.parseInt(person[3])))
	     				mustNotify.add(person2);
	     			
	     			}
	     			statement.close();
	     			//UserCodes.add(code);
	     		}

	        	 catch (SQLException e) {
	     			// TODO Auto-generated catch block
	     			System.out.println("SQL Error while near info");
	     			e.printStackTrace();
	     		}
	        	 
	        	 
	        		 
	        	 }
				
			}
			
		}
		for (int i2=0; i2<mustNotify.size();i2++) {
   		 System.out.println( mustNotify.get(i2));
		}
		return mustNotify;
		
	}
	
	// Method that updates the notifications stored in the database
	public void updateNotification(String email, String message, int type) {  
		String updateQuery;
		try {
	
			if (type==3) {  //for types check Notification class
				String existedNotification = getNotification(type, email);
				if(existedNotification!= null) {
					message = existedNotification + " $$" + message; // the different type 3 messages are stored in the same
					                                                 //string, so we split them wherever there is "$$" in between
				}
			}
			updateQuery = "UPDATE usertable SET notiftype"+type+ "=" +"'" + message+ "'" + "WHERE email=" +"'" + email + "'" + ";";				
			  
			
			prep = connect.prepareStatement(updateQuery);
			prep.executeUpdate();
			prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Method that fetches the notifications stored from the database
	public String getNotification(int type, String email){
		String message=null;
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("SELECT notiftype"+type+" "+ "FROM usertable WHERE email=" + "'"+ email + "'" +";");
			
			while(rs.next()) {
				message = rs.getString("notiftype"+type);
			}
			statement.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
	
	
	
	
	
}
