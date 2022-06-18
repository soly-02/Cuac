import java.sql.SQLException;
import java.util.ArrayList;


public class User {
	// class for all the user's information
	private String email;
	private String password;
	private String myPDFPath;
	private String walletExpirDate;
	private Infection i;
	private Notifications n;
	private MainScreen mainScr;
	private Registry registry;
	
	public User(String email, String password, Infection i, Notifications n) {
		this.email = email;
		this.password = password;
		this.i=i;
		this.n= n;
	
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
	
	
	
	// sends credentials of a new account to the database
	public boolean sendRegCredentials() {
		if(registry.register(email, password)) {
			return true;
		}
			return false;
		}
	
	// checks credentials of an account attempting to login to the database
	public boolean sendLogCredentials() {
		if(registry.login(email, password)) {
			return true;
		}
			return false;
		}
	
	
	
	
	// fetches the saved path of a pdf file(covid certificate) in a users computer from the database
	public String getmyPdfPath() {
		myPDFPath=registry.getFilePath(email);
		
		return myPDFPath;
	}
	// Updates the previous path to pdf file in the database
	public void updatePDFPath(String newPath) {
		myPDFPath = newPath;
		registry.setFilePath(email, myPDFPath);
	}
	
	
	public Notifications getUserNotifications() { //returns notifications from the object and not from the database
		return n;
		
	}
	
	
	
	//returns path to pdf file
	public String getmyPdfDate() {
		walletExpirDate=registry.getPdfDate(email);
		
		return walletExpirDate;
	}
	// updates the pdf certificate expiration date
	public void updatePDFDate(String newDate) {
		walletExpirDate = newDate;
		registry.setPdfDate(email, newDate);
	}
	
	public void closeConnection() {
		registry.closeConnection();
	}
	
	
	public String getEmail() {
		return this.email;
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
	
	// Method that scans the database for people seated nearby our infected user, and send them a message with a warning
	public void findPeopleToNotify(String date) {
		String[] info;
		String[] personalInfo;
		String className=null;
		ArrayList <String> people= registry.notifyPotentiallyInfected(registry.getPreviousSeats(email),email);
		for (int i=0;i<people.size();i++) {
			info= people.toString().replace("[", "").replace("]", "").replace(" ", "").replace(" ", "").split(",");
			for (int j=0; j<info.length;j++) {
				personalInfo= info[j].split("/");
				if (personalInfo[1].equals("1"))
					className= "Αμφιθέατρο 12";
				else if (personalInfo[1].equals("2"))
					className= "Εργαστήριο 234";
				else if (personalInfo[1].equals("3"))
					className= "ΚΥΔ";
				String message= "ΠΡΟΣΟΧΗ! Στις : "+personalInfo[5]+"/"+personalInfo[6]+"/"+ personalInfo[7]+ " βρεθήκατε κοντά σε κρούσμα, στην αίθουσα: "
						+ className+ ", ώρα: "+ personalInfo[3]+":00 ~"+ personalInfo[4]+":00, και θέση: "+personalInfo[2]+". Παρακαλούμε κάντε τεστ ";  //no commas
				updateNotification(3,personalInfo[0],message);
				
				
			}
			

			
		}
		
	}
	

	
	
	
	// Method that saves the date the user was infected in the database
public void setInfectionDate(String date) {
		registry.setInfectionDate(email, date);
		
		
	}
	
//Method that returns the date the user was infected from the database
	public String getInfectionDate() {
		
		return registry.getInfectionDate(email);
		
		
	}
	// Method that updates the notifications in the database
	public void updateNotification( int type, String someEmail, String message) {
	registry.updateNotification(someEmail, message, type);
	}
	
	// Method that returns a certain type of message from the database
	public String getNotifFromDB(int type) {
		return registry.getNotification(type, email);
			
	}
	
	// Saves a user's seat-info
	public void sendSeatLog(String Email, String classId,String startTime, String endTime,  String date, 
			String seatEnter ) {
		
		registry.uploadSeat(Email, Integer.parseInt(classId),Integer.parseInt( seatEnter), startTime,  endTime, date);
			
	}

}
