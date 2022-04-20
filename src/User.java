import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class User {
	
	private String email;
	private String password;
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	
	public User(String email, String password) { 
		this.email = email;
		this.password = password;
		
		try {
			socket = new Socket("localhost", 5000);  //attempt a connection
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) { // an kati paei lathos
            // Gracefully close everything.
        	System.out.println("Error");
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
	}
	
	public boolean sendCredentials(String email, String password) {
		try {
			bufferedWriter.write(email + ", " + password);  //edw stelnontai ta credentials
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
			//apo edw kai katw einai h apanthsh tou server
			String msgFromServer;
			try {
               msgFromServer = bufferedReader.readLine();  //blocking method
               
                if(msgFromServer.equals("user not found")) {
                	return false;
                }
            } catch (IOException e) {
                
                closeEverything(socket, bufferedReader, bufferedWriter);
                return false;
            }
		} catch(IOException e) {
           
			System.out.println("Error");
            closeEverything(socket, bufferedReader, bufferedWriter);
            return false;
         
        }
		return true; // an de symbei kanena exception kai o server de dosei "user not found" ola kala
		
	}
	
	
	public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
