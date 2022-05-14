
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	private User u;
	private MainScreen m;
    private JLabel user_email;
    JLabel Quarantine_Countdown;
	/**
	 * Create the frame.
	 */
	public MainScreen(User u) {
		this.u = u;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 599);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 857, 562);
		contentPane.add(panel);
		panel.setLayout(null);
		
		user_email = new JLabel(u.getEmail());
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user_email.setBounds(10, 11, 167, 38);
		user_email.setForeground(new Color(255, 255, 255));
		panel.add(user_email);
		
		JLabel notification_reminder = new JLabel("Dummie Notification/Reminder");
		notification_reminder.setBackground(new Color(255, 255, 255));
		notification_reminder.setForeground(new Color(255, 0, 0));
		notification_reminder.setFont(new Font("Tahoma", Font.PLAIN, 21));
		notification_reminder.setBounds(247, 2, 294, 55);
		panel.add(notification_reminder);
		
		Quarantine_Countdown = new JLabel("COUNTDOWN 1");
		Quarantine_Countdown.setFont(new Font("Tahoma", Font.BOLD, 17));
		Quarantine_Countdown.setForeground(new Color(255, 255, 255));
		Quarantine_Countdown.setHorizontalAlignment(SwingConstants.TRAILING);
		Quarantine_Countdown.setBounds(551, 15, 195, 31);
		panel.add(Quarantine_Countdown);
		
		
		CovidCountdown c= new CovidCountdown(); //NEO COUNTDOWN
		
		
		
		JButton EnterSeat = new JButton("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u0398\u03AD\u03C3\u03B7\u03C2");
		EnterSeat.setBackground(new Color(255, 255, 255));
		EnterSeat.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterSeat.setBounds(287, 100, 268, 65);
		panel.add(EnterSeat);
		
		JButton EnterCovidWallet = new JButton("Covid Wallet");
		
		EnterCovidWallet.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterCovidWallet.setBackground(Color.WHITE);
		EnterCovidWallet.setBounds(287, 206, 268, 65);
		panel.add(EnterCovidWallet);
		
		JButton EnterInfection = new JButton("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u039D\u03CC\u03C3\u03B7\u03C3\u03B7\u03C2");
		
		EnterInfection.setFont(new Font("Tahoma", Font.PLAIN, 29));
		EnterInfection.setBackground(Color.WHITE);
		EnterInfection.setBounds(287, 300, 268, 65);
		panel.add(EnterInfection);
		
		JButton EnterNotifications = new JButton("\u0395\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2");
		EnterNotifications.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterNotifications.setBackground(new Color(255, 0, 0));
		EnterNotifications.setBounds(287, 444, 268, 65);
		panel.add(EnterNotifications);
		
		
		 ButtonListener bb= new ButtonListener();
		 EnterSeat.addActionListener(bb);   
		 EnterCovidWallet.addActionListener(bb);  
		 EnterInfection.addActionListener(bb);   
		 EnterNotifications.addActionListener(bb);  
		
		
		
	}
	
	
	 class ButtonListener implements ActionListener {
		 
		 
			
			public void actionPerformed(ActionEvent e) {
				
				String action = e.getActionCommand();
				if (action.equals("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u0398\u03AD\u03C3\u03B7\u03C2"))
				{// anoigw thn dhlwsh thesewn
					
					EnterSeat eSeat= new EnterSeat(u);   
				    eSeat.setVisible(true);
				}
				
				
				else if (action.equals("Covid Wallet"))
					// anoigw to covid wallet
                 {
					
					CovidWallet CovWal= new CovidWallet(u);
					CovWal.setVisible(true);
				}
					
					
					
				else if (action.equals("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u039D\u03CC\u03C3\u03B7\u03C3\u03B7\u03C2"))
					// anoigw to infection page
                      {
					
					InfectionScreen InfScr= new InfectionScreen(u);
					InfScr.setVisible(true);
				}
					
				
				
				else if (action.equals("\u0395\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2"))
					// anoigw ths notifications 
                {
					
				NotificationsScreen NotScr= new NotificationsScreen(u);
				NotScr.setVisible(true);
			}
				
			}

	
	
}
	 
	 public class CovidCountdown {
		 
		
		// h mera poy kollise
		 
		 public void CovidCountdown() {
			 
			
			 
			 
			System.out.println(u.getInfection().getInfectionDate());
			 
			 final LocalDate target = LocalDate.of(2022, 5, 1); // temp Target date (year, month, day) date of infection+5 (to be converted)
		     final long result = calculateDaysLeft(target);
		     System.out.println(result);
		 }

		    private static long calculateDaysLeft(LocalDate fromDate) {
		        final LocalDate today = LocalDate.now(); // The current date
		        return fromDate.until(today, ChronoUnit.DAYS); // "until" function comes from Java DateTime API
		    }
		 
		 
		 
	 }

	 
	 
		 
		 public void refresh() {
			 
			 //GIA NA ARXISEI TO COUNTDOWN DOKIMH ME REFRESH TO EMAIL
			 Thread clock= new Thread() {
				 String dateInfection;
				 public void run() {
					 
					 try {
						 for(;;) {
							 

							 dateInfection = u.getInfection().getInfectionDate();
							
							 
							 String[] nums3= dateInfection.split("/");   // splitting the numbers and adding them in a table 
							 int	nums[] = {-1,-1,-1};
								
								for (int index = 0; index < nums3.length; index++) {
									nums[index]=Integer.parseInt(nums3[index]);
								                     
								}
							 
						 Calendar cal= new GregorianCalendar();
						 
						 Quarantine_Countdown.revalidate();
						 int now_day = cal.get(Calendar.DAY_OF_MONTH);
						 int now_month = cal.get(Calendar.MONTH ) +1;
						 int now_year = cal.get(Calendar.YEAR);
						 int day_of =nums[0];
						 int month_of=nums[1]-1;
						 int year_of= nums[2];
						 int end_day = 0;
						 int end_month = cal.get(Calendar.MONTH ) +1;
						 int end_year = cal.get(Calendar.YEAR);
						 
						 Quarantine_Countdown.setText("Date: "+ day_of+"/"+ month_of+"/"+ year_of);
						    
						 
						 
						sleep(1000);
						 }
					 
				 }
					catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					 
					 
			 }
				 
				 
			 };
			 
			
			clock.start();
		 	 
		 }	 
		 
	 
		 
		 // ****  KWDIKAS ISWS GIA META, NA KANEI REFRESH TO MAINSCREEN ANA 30 DEUTERA  ***
		 
	/*	 ActionListener task = new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	                // Do stuff
	            }
	};
	Timer timer = new Timer(30 ,task); // Execute task each 30 miliseconds
	timer.setRepeats(true);
	timer.start();
		 
		 */
	
	
	
	
}
