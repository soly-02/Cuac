import javax.swing.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
	public class GUI extends JFrame { 
		 private JPanel panel;
		 private JTextField email;
		 private JTextField password;
		 private JButton login;
		 private JButton register;
	     private JLabel email_label;
	     private JLabel password_label;
		 
		 public GUI() {
			 
			 
			 panel= new JPanel();
			 
			 email= new JTextField(16);
			 email_label= new JLabel("Enter Your Academic Email");
			 
			 password= new JTextField(16);
			 password_label= new JLabel("Please Enter Your Password");
			 
			 
			 login = new JButton ("Login");
			 register = new JButton ("Register");
			 
			 
			 panel.add(email_label);
			 panel.add(email);  
			 panel.add(password_label);
			 panel.add(password);     
			 panel.add(login);       
			 panel.add(register);     //adding entities on panel
			 this.setContentPane(panel);
			  
			 ButtonListener Bl= new ButtonListener();                  // creation of a button listener
		     login.addActionListener(Bl);                             // sends signal that user pressed the button
		     register.addActionListener(Bl);    
		     
		     
			 this.setVisible(true);
			 this.setSize(400,200);
			 this.setTitle("Couak");                          // Finalizing the frame
			 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
			 
		 }
		 
		 
		 class ButtonListener implements ActionListener {
			 
			 
			
			public void actionPerformed(ActionEvent e) {
				String message = "Hello world";
				JOptionPane.showMessageDialog(new JFrame(), message, "Message",   // opens new dialog window saying that suspect not found
			    JOptionPane.INFORMATION_MESSAGE);
					System.out.println(email.getText()+ password.getText());
					}
		}
	    }
		
	


