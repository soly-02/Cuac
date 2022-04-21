import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Registry {
	// Auth h klash tha diaxeirizetai ta logins, registers, logs kai ola ta arxeia tou server
	
	// missing constructor
	
	public boolean login(String clientQuery) throws IOException {
		FileInputStream inputStream = null;
		Scanner sc = null;
		try {
		    inputStream = new FileInputStream("C:\\Users\\Vaggelis\\eclipse-workspace\\Couak\\src\\userData.txt"); //<----- absolute path name to work. Allakste to sto diko sas path
		    sc = new Scanner(inputStream, "UTF-8");
		    while (sc.hasNextLine()) {
		        String line = sc.nextLine();
		        
		        if(line.equals(clientQuery)) {
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
