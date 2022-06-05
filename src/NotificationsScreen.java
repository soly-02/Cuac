

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class NotificationsScreen extends JFrame {

	private JPanel contentPane;
	private User u;
	

	/**
	 * Create the frame.
	 */
	public NotificationsScreen(User u) {
		setResizable(false);
		
		this.u=u;
		
		setBounds(100, 100, 957, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 943, 588);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblE = new JLabel("E\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblE.setBounds(10, 43, 221, 41);
		panel.add(lblE);
		
		JLabel user_email = new JLabel(u.getEmail());
		user_email.setForeground(Color.WHITE);
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user_email.setBounds(10, 11, 167, 21);
		panel.add(user_email);
		
		
		
		JLabel CovidWalletLabel = new JLabel(" ");
		if (!(u.getNotif(1).equals(null))) 
			CovidWalletLabel.setText(u.getNotif(1));
		
		CovidWalletLabel.setForeground(Color.WHITE);
		CovidWalletLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		CovidWalletLabel.setBounds(95, 113, 775, 86);
		panel.add(CovidWalletLabel);
			
		
		
		
		JLabel QuarantineLabel = new JLabel(" ");
		if (!(u.getNotif(2).equals("null"))) 
			QuarantineLabel.setText(u.getNotif(2));
		
		QuarantineLabel.setForeground(Color.WHITE);
		QuarantineLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		QuarantineLabel.setBounds(95, 222, 775, 78);
		panel.add(QuarantineLabel);
		
		JLabel CovidAlert = new JLabel(" ");
		if (!(u.getNotif(3).equals("null"))) {
			

			u.getNotif(3);
			CovidAlert.setText("<html>""<br/>" "</html>");
		}
		
		
		
		CovidAlert.setForeground(Color.WHITE);
		CovidAlert.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		CovidAlert.setBounds(10, 404, 923, 78);
		panel.add(CovidAlert);
		
		
		
		
}
}
