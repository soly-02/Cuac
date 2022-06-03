

import java.util.ArrayList;


public class Notifications {
  
	 private String[] message= new String[3];
	
	/*-------------- C O N S T R U C T O R------------------*/

	public Notifications() {
		
	}
	
	
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
