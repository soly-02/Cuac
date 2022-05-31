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
	// Auth h klash tha diaxeirizetai ta logins, registers, logs kai ola ta arxeia tou server
	// Kath grammh tou userData.txt einai: email, password, pathToPDF, InfectionDate, Notification1. Notification2 ......
	//				dataFromFile			0		1			2			3						4				
	private String[] MessageArray;
	private String[] InfectionArray;
	private String[] dataFromFile;
	private String email;
	private String userDataPath = "userData.txt";
	private String seatLogPath = "seatLog.txt";
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
						//THELW POP UP SCREEN
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
	     			rs = statement.executeQuery("SELECT classID,seatId,starttime,endtime,date  FROM seatlog WHERE email="+ "'"+ email+ "'" + "AND date="+ "'"+ dateTry+"'" );
	     		
	     			while(rs.next()) {
	     			UserCodes.add(( rs.getString("classID")+ "/" + rs.getString("seatId") + "/" + rs.getString("starttime")+ "/" + rs.getString("endtime")+ "/" + rs.getString("date")));
	     			
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
		
		
	
	public void notifyPotentiallyInfected(ArrayList <String> UserCodes) {
		
		
		
		
	}
	
	
	
	
	
	
	//----------------------------MEXRI EDW EINAI TO KAINOYRGIO REGISTRY--------------------------------------------------------
	public String getNotifications(String clientMsg) throws IOException { // returns all notofication of a user. It can be null. ClientMsg=email
		MessageArray = clientMsg.split(", ");
		email = MessageArray[0];
		String notifications = null;
		FileInputStream inputStream = null;
		Scanner sc = null;
		
		try {
		    inputStream = new FileInputStream(userDataPath);
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        dataFromFile = line.split(", ");
		        if((dataFromFile[0].equals(email))) { //found the user
		        	notifications = dataFromFile[4];
		        }
		        //System.out.println(line);
		    }
		    if (sc.ioException() != null) {
		        throw sc.ioException();
		    }
		}catch(FileNotFoundException e) {
			System.out.println("userData file not found");
			
		}		
		finally {
		    if (inputStream != null) {
		        inputStream.close();
		    }
		    if (sc != null) {
		        sc.close();
		    }
		}
		return notifications;
	}
	
	public void saveSeat(String seatCode) { //seatCode = classID/StartTime/EndTime/D/M/Y/SeatNum/email
		try {			 
            BufferedWriter out = new BufferedWriter(new FileWriter(seatLogPath, true));
 
            out.write(seatCode);
            out.newLine();
            out.close();
        }
 
        catch (IOException e) {
            System.out.println("seatLog.txt not found" + e);
        }
	}
	
	public void addInfection(String InfectionDate) { //adds infection date to the userData.txt. InfectionDate=email, D/M/Y
		MessageArray = InfectionDate.split(", ");
		email = MessageArray[0];
		String newLine = "";
		String newInfection = MessageArray[1];
		
		try {
	        BufferedReader file = new BufferedReader(new FileReader(userDataPath));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = file.readLine()) != null) {
	        	dataFromFile = line.split(", ");
	        	
	        	if((dataFromFile[0].equals(email))) { //found the user
	        		
		        	dataFromFile[3] = newInfection; //change the path
		        	for(int i=0; i<dataFromFile.length; i++) { //convert array to string
		        		newLine += dataFromFile[i];
		        		newLine += ", ";
		        	}
		            inputBuffer.append(newLine);
		            inputBuffer.append('\n');
		            continue;
	        	}
	        	inputBuffer.append(line);
	            inputBuffer.append('\n');
	        	
	        }
	        file.close();

	        FileOutputStream fileOut = new FileOutputStream(userDataPath);
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();
	    } catch (Exception e) {
	        System.out.println("userData file not found");
	    }
	}
	
	public void saveInfection(String InfectionDate) {
				 
		 String[] dataRead;
		
		 InfectionArray = InfectionDate.split("/");
    	 String inEmail = InfectionArray[0];
    	 ArrayList<String> UserCodes = new ArrayList<String>() ;
    	 ArrayList<String> SendMessage = new ArrayList<String>() ;// poioi htan dipla sto krousma
    	 ArrayList<Calendar> cals= new ArrayList<Calendar>();
    		 
    		 
    		 
    	 Calendar cal_of= new GregorianCalendar(); //MERA POY NOSISE
    		 
		 cal_of.set(Calendar.DAY_OF_MONTH, Integer.parseInt(InfectionArray[1]));						 
		 cal_of.set(Calendar.MONTH, Integer.parseInt(InfectionArray[2]) -1);
		 cal_of.set(Calendar.YEAR, Integer.parseInt(InfectionArray[3]));
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
         int u;
    		 
         try {
    			BufferedReader  reader = new BufferedReader(new FileReader("seatLog.txt"));   // PROSpATHW NA pARW TA STOIXEIA TOY XRHSTH 0 "
    			String line = reader.readLine();
    			for (int i= 0; i< cals.size();i++) {
    				
    				reader = new BufferedReader(new FileReader("seatLog.txt"));
        			line = reader.readLine();
    				  				
        			while (line != null) {
    				
        				dataRead= line.split("/");
        				if(dataRead[7].equals(inEmail) && dataRead[3].equals(InfectionArray[1])&& dataRead[4].equals(InfectionArray[2]) && dataRead[5].equals(InfectionArray[3])){
    							
    					      UserCodes.add(line);
    							
    							
    						}
        				line = reader.readLine();
    			}
    			
    			
    			
        			u=i+1;
        			InfectionArray[1]= ""+cals.get(u).get(Calendar.DATE);
        			InfectionArray[2]= ""+cals.get(u).get(Calendar.MONTH);
        			InfectionArray[3]= ""+cals.get(u).get(Calendar.YEAR);
    			
        			reader.close();
    			}
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		
    		
    			
	}
	
}
