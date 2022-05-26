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

public class Registry {
	// Auth h klash tha diaxeirizetai ta logins, registers, logs kai ola ta arxeia tou server
	// Kath grammh tou userData.txt einai: email, password, pathToPDF, InfectionDate, Notification1. Notification2 ......
	//				dataFromFile			0		1			2			3						4				
	private String[] MessageArray;
	private String[] InfectionArray;
	private String[] dataFromFile;
	private String email;
	private String userDataPath = "C:\\Users\\Vaggelis\\eclipse-workspace\\Couak\\src\\userData.txt"; //<----- absolute path name to work. Allakste to sto diko sas path
	private String seatLogPath = "C:\\Users\\Vaggelis\\eclipse-workspace\\Couak\\src\\seatLog.txt";
	 
	// missing constructor
	
	public boolean login(String clientMsg) throws IOException { 
		FileInputStream inputStream = null;
		Scanner sc = null;
		MessageArray = clientMsg.split(", ");
		String password = MessageArray[1];
		email = MessageArray[0];
		
		try {
		    inputStream = new FileInputStream(userDataPath); 
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        dataFromFile = line.split(", ");
		        if((dataFromFile[0].equals(email)) && (dataFromFile[1].equals(password))) {
		        	return true;
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
		return false;
	}
	
	public boolean register(String clientMsg) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		MessageArray = clientMsg.split(", ");
		String password = MessageArray[1];
		email = MessageArray[0];
		
		try {
		    inputStream = new FileInputStream(userDataPath); 
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {  // search the file to check if user exists
		        String line = sc.nextLine();
		        dataFromFile = line.split(", ");
		        if((dataFromFile[0].equals(email))) { // user already exists
		        	return false;
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
		
		BufferedWriter out = new BufferedWriter(new FileWriter(userDataPath, true));
		out.write(email + ", " + password + ", null, null, null");
        out.newLine();
        out.close();
		return true;
	}
	
	public String getFilePath(String clientMsg) throws IOException { // it returns null (as a String) if there is no path for the PDF file. ClientMsg = email;
		FileInputStream inputStream = null;
		Scanner sc = null;
		MessageArray = clientMsg.split(", ");
		email = MessageArray[0];
		String pathToPDF = null;
		
		try {
		    inputStream = new FileInputStream(userDataPath);
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        dataFromFile = line.split(", ");
		        if((dataFromFile[0].equals(email))) { //found the user
		        	pathToPDF = dataFromFile[2];
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
		return pathToPDF;
	}
	
	public void setFilePath(String clientMsg) { //changes the path to PDF. ClientMsg=email, pathToPDF
		MessageArray = clientMsg.split(", ");
		email = MessageArray[0];
		String newLine = "";
		String newPath = MessageArray[1];
		
		try {
	        BufferedReader file = new BufferedReader(new FileReader(userDataPath));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = file.readLine()) != null) {
	        	dataFromFile = line.split(", ");
	        	
	        	if((dataFromFile[0].equals(email))) { //found the user
	        		
		        	dataFromFile[2] = newPath; //change the path
		        	for(int i=0; i<dataFromFile.length; i++) { //convert array to string
		        		newLine += dataFromFile[i];
		        		if(i <= dataFromFile.length - 2)
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
	
	public void saveInfection(String InfectionDate) { //seatCode = classID/StartTime/EndTime/D/M/Y/SeatNum/email
				 
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
    			BufferedReader  reader = new BufferedReader(new FileReader(   // PROSpATHW NA pARW TA STOIXEIA TOY XRHSTH 0
    					"C:\\Users\\sofia\\eclipse-workspace\\Couak\\src\\seatLog.txt"));
    			String line = reader.readLine();
    			for (int i= 0; i< cals.size();i++) {
    				
    				reader = new BufferedReader(new FileReader(
        					"C:\\Users\\sofia\\eclipse-workspace\\Couak\\src\\seatLog.txt"));
        			 line = reader.readLine();
    				
    				
    				
    			while (line != null) {
    				
    				dataRead= line.split("/");
    				if(dataRead[7].equals(inEmail) && dataRead[3].equals(InfectionArray[1])
    						&& dataRead[4].equals(InfectionArray[2]) && dataRead[5].equals(InfectionArray[3])){
    							
    					      UserCodes.add(line); //UserCodes einai oloi oi kwdikoi toy xrhsth sthn periodo poy eixe nosisei
    							
    							
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
