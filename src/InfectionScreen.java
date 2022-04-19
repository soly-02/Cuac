

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class InfectionScreen extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public InfectionScreen() {
		
		setBounds(100, 100, 760, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 746, 476);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel user_email = new JLabel("dummie@uom.edu.gr");
		user_email.setBounds(10, 11, 167, 21);
		user_email.setForeground(Color.WHITE);
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(user_email);
		
		JLabel lblCovidWallet = new JLabel("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u039D\u03CC\u03C3\u03B7\u03C3\u03B7\u03C2");
		lblCovidWallet.setForeground(Color.WHITE);
		lblCovidWallet.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCovidWallet.setBounds(10, 43, 221, 41);
		panel.add(lblCovidWallet);
		 
	}

}
