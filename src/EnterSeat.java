

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;

public class EnterSeat extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public EnterSeat() {
		
		setBounds(100, 100, 867, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, -11, 853, 548);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel user_email = new JLabel("dummie@uom.edu.gr");
		user_email.setBounds(10, 11, 167, 21);
		user_email.setForeground(Color.WHITE);
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(user_email);
		
		JLabel SeatAssign = new JLabel("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u0398\u03AD\u03C3\u03B7\u03C2");
		SeatAssign.setForeground(new Color(255, 255, 255));
		SeatAssign.setFont(new Font("Tahoma", Font.BOLD, 22));
		SeatAssign.setBounds(10, 43, 221, 41);
		panel.add(SeatAssign);
		
		
	}
}
