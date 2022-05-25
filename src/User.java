import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;


public class User {
	
	private String email;
	private String password;
	private ArrayList <String> myNotifications= new ArrayList();
	private String myPDFPath;
	private Infection i;
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private MainScreen mainScr;
	
	public User(String email, String password, Infection i) {  // isws xreiastei k alla attributes
		this.email = email;
		this.password = password;
		this.i=i;
	
	}
	
	public boolean connect() {  // kata th syndesh userID tha einai to email 
		try {
			socket = new Socket("localhost", 5000);  //attempt a connection
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Connection established");  
            send(this.email);  // to socket einai etoimo, klhthike o constructor tou ClientHandler kai perimenei to userID giauto stelnoume to email. See ClientHandler constructor
        } catch (IOException e) { // an kati paei lathos
        	System.out.println("Error creating client socket");
            closeEverything(socket, bufferedReader, bufferedWriter);
            return false;
        }
		return true;
	}
	
	public boolean sendCredentials() {
		send("login;" + email + ", " + password);   //edw stelnontai ta credentials
		System.out.println("credentials sent");
		//apo edw kai katw einai h apanthsh tou server
		String msgFromServer;
		try {
              msgFromServer = bufferedReader.readLine();  //blocking method
               if(msgFromServer.equals("user not found")) {
            	 System.out.println("user not found");  
                return false;
               }
         } catch (IOException e) {
        	 	System.out.println("Error reading server's message");
                closeEverything(socket, bufferedReader, bufferedWriter);
                return false;
            }
		return true; // an de symbei kanena exception kai o server de dosei "user not found" ola kala
			
	}
	
	//TODO method pou perimenei gia notifications
	
	
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
	
	public String getEmail() {
		return this.email;
	}
	
	
	
	
	//---------GIA TRIAL MONO------------
	
	
	
	
	public String getPassword() {
		return this.password;
	}
	
	public Infection getInfection() {
		return this.i;
	}
	
	
	public void getMainScreen(MainScreen m) {
		this.mainScr=m;
		
		
	}
	
	public void startCovidCountdown() {
		mainScr.countdown();
		
		
	}
	
	
	
	//-----------------------------------
	
	public void send(String MsgToSend) {
		try {
			bufferedWriter.write(MsgToSend);
			bufferedWriter.newLine();
			bufferedWriter.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to send message");
			closeEverything(socket, bufferedReader, bufferedWriter);
			e.printStackTrace();
		}
		
	}

}
