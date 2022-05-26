import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;


public class User {
	
	private String email;
	private String password;
	private ArrayList <String> myNotifications= new ArrayList();
	private String myPDFPath;
	private String walletExpirDate;
	private Infection i;
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private MainScreen mainScr;
	private Registry registry;
	
	public User(String email, String password, Infection i) {  // isws xreiastei k alla attributes
		this.email = email;
		this.password = password;
		this.i=i;
	
	}
	
	public boolean connect() {  
		try {
			registry = new Registry();  //attempts a connection to the database
        } catch (SQLException e) { 
        	System.out.println("Error connecting to the database");
            return false;
        }
		return true;
	}
	
	public boolean sendCredentials() {
		if(registry.login(email, password)) {
			return true;
		}
		else {
			System.out.println("user not found");
			return false;
		}
	}
	
	public String getmyPdfPath() {
		myPDFPath=registry.getFilePath(email);
		
		return myPDFPath;
	}
	
	public void updatePDFPath(String newPath) {
		myPDFPath = newPath;
		registry.setFilePath(email, myPDFPath);
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
