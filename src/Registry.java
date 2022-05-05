import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Registry {
	// Auth h klash tha diaxeirizetai ta logins, registers, logs kai ola ta arxeia tou server
	private String[] MessageArray;
	private String[] dataFromFile;
	private String email;
	private String password;
	private String pathToPDF;
	 
	// missing constructor
	
	public boolean login(String clientMsg) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		MessageArray = clientMsg.split(", ");
		email = MessageArray[0];
		password = MessageArray[1];
		try {
		    inputStream = new FileInputStream("C:\\Users\\Vaggelis\\eclipse-workspace\\Couak\\src\\userData.txt"); //<----- absolute path name to work. Allakste to sto diko sas path
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
}
