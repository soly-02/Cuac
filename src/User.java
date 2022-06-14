import java.sql.SQLException;
import java.util.ArrayList;


public class User {
	
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
	
	
	
	
	public boolean sendRegCredentials() {
		if(registry.register(email, password)) {
			return true;
		}
			return false;
		}
	
	
	public boolean sendLogCredentials() {
		if(registry.login(email, password)) {
			return true;
		}
			return false;
		}
	
	
	
	
	
	public String getmyPdfPath() {
		myPDFPath=registry.getFilePath(email);
		
		return myPDFPath;
	}
	
	public void updatePDFPath(String newPath) {
		myPDFPath = newPath;
		registry.setFilePath(email, myPDFPath);
	}
	
	
	public Notifications getUserNotifications() {
		return n;
		
	}
	
	
	
	
	public String getmyPdfDate() {
		walletExpirDate=registry.getPdfDate(email);
		
		return walletExpirDate;
	}
	
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
	

	
	
	
	
public void setInfectionDate(String date) {
		registry.setInfectionDate(email, date);
		
		
	}
	
	
	public String getInfectionDate() {
		
		return registry.getInfectionDate(email);
		
		
	}
	
	public void updateNotification( int type, String someEmail, String message) {
	registry.updateNotification(someEmail, message, type);
	}
	
	
	public String getNotifFromDB(int type) {
		return registry.getNotification(type, email);
			
	}
	
	
	public void sendSeatLog(String Email, String classId,String startTime, String endTime,  String date, 
			String seatEnter ) {
		
		registry.uploadSeat(Email, Integer.parseInt(classId),Integer.parseInt( seatEnter), startTime,  endTime, date);
			
	}

}
