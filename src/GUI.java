import javax.swing.*;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
	public class GUI extends JFrame { 
		
		 
		 public GUI() {
			 
			 SignUp_Register frame = new SignUp_Register();
				frame.setVisible(true);
				MainScreen mainScr= new MainScreen();  //TODO constructors in GUI screens to pass user's data
				mainScr.setVisible(true);
			 
		 }
		 
		 
	    }
		
	


