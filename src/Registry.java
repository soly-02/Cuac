import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;


public class Registry {
	
	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement prep = null;
    private ResultSet rs = null;
	 
	// missing constructor
	public Registry() throws SQLException {
		String url = "jdbc:mysql://snf-888491.vm.okeanos.grnet.gr:3306/cuac";
		String usernamedb = "java";
		String passworddb = "password";
		
		
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
	
	public boolean login(String email, String password) {
		String emailFromDB=null;
		String passwordFromDB=null;
		try {
			statement = connect.createStatement();
			rs = statement.executeQuery("SELECT email, password FROM usertable WHERE email=" + "'"+ email + "'" +";");
		
			 
			
		
			
			while(rs.next()) {
				
				emailFromDB = rs.getString("email");
				passwordFromDB = rs.getString("password");
				
				
				if (emailFromDB.equals(email)) {
					System.out.println("Email is in DB");                    //PERIPTOSH NA YPARXEI EMAIL
					if(passwordFromDB.equals(password)) {
						System.out.println("Password correct, log in complete");    //PERIPTOSH SWSTO PASSWORD
						return true;
					}
					else { 
						System.out.println("Password wrong, try again");         //PERIPTOSH LATHOS PASSWORD
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
	
	public boolean register(String email, String password) {
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
			System.out.println("SQL Error in register");
			e.printStackTrace();
		}
		return true;
	}
	
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
			System.out.println("SQL Error while getting path");
			e.printStackTrace();
		}
		return pathToPDF;
	}
	
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
			System.out.println("SQL Error while setting PDFPath");
			e.printStackTrace();
		}
	}
	
	
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
			System.out.println("SQL Error while getting path");
			e.printStackTrace();
		}
		return dateofPDF;
	}
	
	
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
			System.out.println("SQL Error while setting PDFDate");
			e.printStackTrace();
		}
	}
	
	
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
			System.out.println("SQL Error in uploadSeat");
			e.printStackTrace();
		}
	}
	
	
	
	public void setInfectionDate(String email, String date) { //changes the path to PDF.
		try {
			String addInfectionDateQuery = "UPDATE usertable SET infectionDate=? WHERE email=" + "'"+ email + "'" +";";
			prep = connect.prepareStatement(addInfectionDateQuery);
			prep.setString(1, date);
			
			prep.executeUpdate();
			prep.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL Error while setting PDFPath");
			e.printStackTrace();
		}
	}
	
	
	public String getInfectionDate(String email){ // it returns null (as a String) if there is no date for the PDF file
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
			System.out.println("SQL Error while getting path");
			e.printStackTrace();
		}
		return dateofInfection;
	}
	
	
	
	public  ArrayList<String> getPreviousSeats(String email) {
		
		
		//Classroom c1= new Classroom(1);
		 ArrayList<String> UserCodes = new ArrayList<String>() ;
		String code= null;
		String[] date = getInfectionDate(email).split("/");
		
		
	   	 Calendar cal_of= new GregorianCalendar(); //MERA POY NOSISE
		 
	   	     ArrayList<Calendar> cals= new ArrayList<Calendar>();
			 cal_of.set(Calendar.DAY_OF_MONTH, Integer.parseInt(date[0]));						 
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
	     			//UserCodes.add(code);
	     		}

	        	 catch (SQLException e) {
	     			// TODO Auto-generated catch block
	     			System.out.println("SQL Error while user info");
	     			e.printStackTrace();
	     		}
	        	 
	        	 
	        	 
	        	 
	         }
	         
	         return UserCodes; 
	         }
		
		
	
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
			//KANE PRINT NA DEIS
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
	
	
	public void updateNotification(String email, Notifications n, int type) {
		String updateQuery;// = "UPDATE usertable SET ?=" +"'" + n.getMessage()[n.getType() - 1]+ "'" + "WHERE email=" +"'" + email + "'" + ";";
		try {
	
			
				updateQuery = "UPDATE usertable SET notiftype"+type+ "=" +"'" + n.getMessage(type)+ "'" + "WHERE email=" +"'" + email + "'" + ";";				
				
			
			prep = connect.prepareStatement(updateQuery);
			prep.executeUpdate();
			prep.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
