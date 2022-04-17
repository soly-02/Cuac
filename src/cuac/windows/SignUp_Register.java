package cuac.windows;

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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class SignUp_Register extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;



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
		
		email = new JTextField();
		email.setBounds(129, 72, 229, 36);
		panel.add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(129, 182, 229, 36);
		panel.add(password);
		
		JButton signUp = new JButton("Sign Up");
		signUp.setForeground(new Color(255, 255, 255));
		signUp.setFont(new Font("Microsoft Tai Le", Font.BOLD, 17));
		signUp.setBackground(new Color(0, 0, 128));
		signUp.setBounds(73, 297, 161, 36);
		panel.add(signUp);
		
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
	}
}
