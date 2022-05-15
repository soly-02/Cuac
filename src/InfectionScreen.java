

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class InfectionScreen extends JFrame {

	private JPanel contentPane;
	private JTextField day;
	private JTextField month;
	private JTextField year;
	private User u;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public InfectionScreen(User u) {
		this.u=u;
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
		
		JLabel user_email = new JLabel(u.getEmail());
		user_email.setBounds(10, 11, 167, 21);
		user_email.setForeground(Color.WHITE);
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(user_email);
		
		JLabel lblCovidWallet = new JLabel("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u039D\u03CC\u03C3\u03B7\u03C3\u03B7\u03C2");
		lblCovidWallet.setForeground(Color.WHITE);
		lblCovidWallet.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblCovidWallet.setBounds(10, 43, 221, 41);
		panel.add(lblCovidWallet);
		
	    lblNewLabel = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u03B8\u03B5\u03C4\u03B9\u03BA\u03BF\u03CD \u03C4\u03B5\u03C3\u03C4 :");
	    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 132, 726, 50);
		panel.add(lblNewLabel);
		
		day = new JTextField();
		day.setFont(new Font("Microsoft YaHei", Font.PLAIN, 22));
		day.setBounds(118, 239, 126, 41);
		panel.add(day);
		day.setColumns(10);
		
		month = new JTextField();
		month.setFont(new Font("Microsoft YaHei", Font.PLAIN, 22));
		month.setColumns(10);
		month.setBounds(317, 239, 126, 41);
		panel.add(month);
		
		year = new JTextField();
		year.setFont(new Font("Microsoft YaHei", Font.PLAIN, 22));
		year.setColumns(10);
		year.setBounds(514, 239, 126, 41);
		panel.add(year);
		
		JButton okButton = new JButton("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u039A\u03C1\u03BF\u03CD\u03C3\u03BC\u03B1\u03C4\u03BF\u03C2");
		okButton.setForeground(Color.WHITE);
		okButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		okButton.setBackground(Color.RED);
		okButton.setBounds(224, 337, 298, 50);
		panel.add(okButton);
		
		 ButtonListener bb= new ButtonListener();
		 okButton.addActionListener(bb);
		
		JLabel lblNewLabel_1 = new JLabel("\u039C\u03AD\u03C1\u03B1");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblNewLabel_1.setBounds(154, 204, 57, 41);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u039C\u03AE\u03BD\u03B1\u03C2");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(352, 204, 57, 41);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0388\u03C4\u03BF\u03C2");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(547, 204, 57, 41);
		panel.add(lblNewLabel_1_2);
	}

	class ButtonListener implements ActionListener {
		 
		
		
		public void actionPerformed(ActionEvent e) {
			 
			 Calendar cal_now= new GregorianCalendar();
			 Calendar cal_of= new GregorianCalendar();
			 Calendar cal_end= new GregorianCalendar();
			 
			 int now_day = cal_now.get(Calendar.DAY_OF_MONTH);
			 int now_month = cal_now.get(Calendar.MONTH ) ;
			 int now_year = cal_now.get(Calendar.YEAR);
			 
			 cal_now.set(Calendar.DAY_OF_MONTH, now_day);						 
			 cal_now.set(Calendar.MONTH, now_month);
			 cal_now.set(Calendar.YEAR, now_year);
			 
			 
			 
			 cal_of.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day.getText()));						 
			 cal_of.set(Calendar.MONTH, Integer.parseInt(month.getText())-1);
			 cal_of.set(Calendar.YEAR, Integer.parseInt(year.getText()));
			 
			 cal_end= (Calendar) cal_of.clone();
			 
			 cal_end.add(Calendar.DAY_OF_MONTH, 5);
			 long noOfDaysBetween = ChronoUnit.DAYS.between(cal_now.toInstant(), cal_end.toInstant());
			
			 
			 if (noOfDaysBetween>0 && noOfDaysBetween<=5) {
			u.getInfection().setCovidStatus(true);
			u.getInfection().setInfectionDate(day.getText()+"/"+month.getText()+"/"+year.getText());
			u.startCovidCountdown();
			dispose();
			 }
			 else {
				 lblNewLabel.setText("Η περίοδος αυτής της καραντίνας έχει λήξει. Ξαναπροσπαθήστε.");
				 lblNewLabel.revalidate();
			 }
			
		}



}
	
	
	
	
}
