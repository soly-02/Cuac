

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JDesktopPane;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class SignUp_Register extends JFrame {

	private JPanel contentPane;
	//To email kai to password molis patietai kapoio koympi(sign in/ register) stelnontai san string ston server.
	// an ola einai komple vazei mesa ton xristi alliws error kai 3anadokimazei
	private JTextField emailField;
	private JPasswordField passwordField;
	
	
	private User u;


	/**
	 * Create the frame.
	 */
	public SignUp_Register() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\sofia\\OneDrive\\Desktop\\\u039F\u03BC\u03B1\u03B4\u03B9\u03BA\u03AE\\Project Managers\\UOMLOGOGR22.png"));
		setTitle("Cuac");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 560);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(86, 45, 485, 438);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);
		
		emailField = new JTextField();
		emailField.setBounds(129, 72, 229, 36);
		panel.add(emailField);
		emailField.setColumns(10);
		
	 //	email= emailField.getText();
		
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(129, 182, 229, 36);
		panel.add(passwordField);
		
		// password = String.valueOf(passwordField.getPassword());   //DEN EIMAI SIGOYRH GIA AYTO
		
		 
		JButton signIn = new JButton("Sign In");
		signIn.setForeground(new Color(255, 255, 255));
		signIn.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
		signIn.setBackground(new Color(0, 0, 128));
		signIn.setBounds(73, 297, 161, 36);
		panel.add(signIn);
		
		JLabel lblNewLabel = new JLabel("Enter Email");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblNewLabel.setBounds(170, 34, 161, 27);
		panel.add(lblNewLabel);
		
		JButton Register = new JButton("Register");
		Register.setForeground(Color.WHITE);
		Register.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
		Register.setBackground(new Color(0, 0, 128));
		Register.setBounds(267, 297, 161, 36);
		panel.add(Register);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 24));
		lblEnterPassword.setBounds(145, 144, 223, 27);
		panel.add(lblEnterPassword);
		
		 ButtonListener bb= new ButtonListener();
		 signIn.addActionListener(bb);   
		 Register.addActionListener(bb);  
		 
	}
	
	 class ButtonListener implements ActionListener {
		 
		 
			
			public void actionPerformed(ActionEvent e) {
				
				Infection i = new Infection();
				u =new User(emailField.getText(), String.valueOf(passwordField.getPassword()),i);
				MainScreen mainScr= new MainScreen(u);  //TODO constructors in GUI screens to pass user's data
				mainScr.setVisible(true);
				dispose ();
				
			/* ------**BAGG TA BAZW OLA SE SXOLIA GIA NA KANW ELEGXOYS **************------------	
			 * 
			 * 
				// edw thelei mia if h opoia tsekarei ta credentials me ton server kai an ola pane kala
				// mas stelnei sthn arxikh othoni
				//ta email kai password tha ta paroume apo to input (mazi me elegxous gia to an to password exei katallhlo mhkos klp)
				if(!u.connect()) {
					//pop-up oti den yparxei syndesh ston server
					return;
				}
				if(!(u.sendCredentials(email, password))) { //an ta sendCredentials epistrefoun sfalma
					//pop up ena parathyro pou na leei lathos credentials
				}
				else {
					MainScreen mainScr= new MainScreen(u);  //TODO constructors in GUI screens to pass user's data
					mainScr.setVisible(true);
					dispose ();
				}
			
				 */
		}

	
	
}
}