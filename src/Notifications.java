

import java.util.ArrayList;


public class Notifications {
  
	 private String[] message= new String[3];
	
	/*-------------- C O N S T R U C T O R------------------*/

	public Notifications() {
		
	}
	//notifType1: Το πιστοποιητικό σας λήγει σε : Χ μέρες
	//notiftype2: Η καραντίνα σας λήγει σε : X μέρες
	//notifType3: ΠΡΟΣΟΧΗ! Στις: dd/mm/YY βρεθήκατε κοντά σε κρούσμα στην αίθουσα: X ώρα: HH:MM ~HH:MM και θέση:Y. Παρακαλούμε κάντε τεστ
	//-------------------------------------------------------
	
	public void updateMessage(int type, String info) {
		
		int count = type-1;
		
			message[count]=info;
			
			
			
		}
		
		
	

	
	public String getMessage(int type) {
		int count = type-1;
		return message[count];
	}
	
}
