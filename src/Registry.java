import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Registry {
	// Auth h klash tha diaxeirizetai ta logins, registers, logs kai ola ta arxeia tou server
	// Kath grammh tou userData.txt einai: email, password, pathToPDF, Notification1. Notification2 ......
	//				dataFromFile			0		1			2					3					
	private String[] MessageArray;
	private String[] dataFromFile;
	private String email;
	private String password;
	private String userDataPath = "C:\\Users\\Vaggelis\\eclipse-workspace\\Couak\\src\\userData.txt"; //<----- absolute path name to work. Allakste to sto diko sas path
	private String seatLogPath = "C:\\Users\\Vaggelis\\eclipse-workspace\\Couak\\src\\seatLog.txt";
	 
	// missing constructor
	
	public boolean login(String clientMsg) throws IOException { 
		FileInputStream inputStream = null;
		Scanner sc = null;
		MessageArray = clientMsg.split(", ");
		email = MessageArray[0];
		password = MessageArray[1];
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
	        		
		        	dataFromFile[2] = newPath; //MesageArray[1]=path given by the user
		        	for(int i=0; i<dataFromFile.length; i++) {
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
		        	notifications = dataFromFile[3];
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
}
