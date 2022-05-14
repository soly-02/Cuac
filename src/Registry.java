import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
	private String userDataPath = "C:\\Users\\Vaggelis\\eclipse-workspace\\Couak\\src\\userData.txt";
	 
	// missing constructor
	
	public boolean login(String clientMsg) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		MessageArray = clientMsg.split(", ");
		email = MessageArray[0];
		password = MessageArray[1];
		try {
		    inputStream = new FileInputStream(userDataPath); //<----- absolute path name to work. Allakste to sto diko sas path
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        dataFromFile = line.split(", ");
		        if((dataFromFile[0].equals(email)) && (dataFromFile[1].equals(password))) {
		        	return true;
		        }
		        //System.out.println(line);
		    }
		    // note that Scanner suppresses exceptions
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
	
	public String getFilePath(String clientMsg) throws IOException { // it returns null (as a String) if there is no path
		FileInputStream inputStream = null;
		Scanner sc = null;
		MessageArray = clientMsg.split(", ");
		email = MessageArray[0];
		String pathToPDF = null;
		
		try {
		    inputStream = new FileInputStream(userDataPath); //<----- absolute path name to work. Allakste to sto diko sas path
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        dataFromFile = line.split(", ");
		        if((dataFromFile[0].equals(email))) { //found the user
		        	pathToPDF = dataFromFile[2];
		        }
		        //System.out.println(line);
		    }
		    // note that Scanner suppresses exceptions
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
	
	public void setFilePath(String clientMsg) {
		MessageArray = clientMsg.split(", ");
		email = MessageArray[0];
		String newLine = null;
		String newPath = MessageArray[1];
		
		try {
	        // input the (modified) file content to the StringBuffer "input"
	        BufferedReader file = new BufferedReader(new FileReader(userDataPath));
	        StringBuffer inputBuffer = new StringBuffer();
	        String line;

	        while ((line = file.readLine()) != null) {
	        	dataFromFile = line.split(", ");
	        	
	        	if((dataFromFile[0].equals(email))) { //found the user
	        		
		        	dataFromFile[2] = newPath; //MesageArray[1]=path given by the user
		        	newLine = String.join("", dataFromFile);
		            inputBuffer.append(newLine);
		            inputBuffer.append('\n');
		            continue;
	        	}
	        	inputBuffer.append(line);
	            inputBuffer.append('\n');
	        	
	        }
	        file.close();

	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream(userDataPath);
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("userData file not found");
	    }
	}
}
