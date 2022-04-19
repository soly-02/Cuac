

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

	

	/**
	 * Create the frame.
	 */
	public NotificationsScreen() {
		
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 726, 456);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblE = new JLabel("E\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblE.setBounds(10, 43, 221, 41);
		panel.add(lblE);
		
		JLabel user_email = new JLabel("dummie@uom.edu.gr");
		user_email.setForeground(Color.WHITE);
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user_email.setBounds(10, 11, 167, 21);
		panel.add(user_email);
	}

}
