
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
		setBounds(100, 100, 1026, 641);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 1018, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		user_email = new JLabel(u.getEmail());
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user_email.setBounds(68, 20, 167, 38);
		user_email.setForeground(new Color(255, 255, 255));
		panel.add(user_email);
		
		JLabel notification_reminder = new JLabel("Dummie Notification/Reminder");
		notification_reminder.setBackground(new Color(255, 255, 255));
		notification_reminder.setForeground(new Color(255, 0, 0));
		notification_reminder.setFont(new Font("Tahoma", Font.PLAIN, 21));
		notification_reminder.setBounds(245, 11, 294, 55);
		panel.add(notification_reminder);
		
		Quarantine_Countdown = new JLabel("");
		Quarantine_Countdown.setFont(new Font("Tahoma", Font.BOLD, 22));
		Quarantine_Countdown.setForeground(Color.RED);
		Quarantine_Countdown.setHorizontalAlignment(SwingConstants.LEFT);
		Quarantine_Countdown.setBounds(583, 13, 425, 45);
		panel.add(Quarantine_Countdown);
		
		
		
		
		
		
		JButton EnterSeat = new JButton("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u0398\u03AD\u03C3\u03B7\u03C2");
		EnterSeat.setBackground(new Color(255, 255, 255));
		EnterSeat.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterSeat.setBounds(385, 116, 268, 65);
		panel.add(EnterSeat);
		
		JButton EnterCovidWallet = new JButton("Covid Wallet");
		
		EnterCovidWallet.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterCovidWallet.setBackground(Color.WHITE);
		EnterCovidWallet.setBounds(385, 217, 268, 65);
		panel.add(EnterCovidWallet);
		
		JButton EnterInfection = new JButton("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u039D\u03CC\u03C3\u03B7\u03C3\u03B7\u03C2");
		
		EnterInfection.setFont(new Font("Tahoma", Font.PLAIN, 29));
		EnterInfection.setBackground(Color.WHITE);
		EnterInfection.setBounds(385, 317, 268, 65);
		panel.add(EnterInfection);
		
		JButton EnterNotifications = new JButton("\u0395\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2");
		EnterNotifications.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterNotifications.setBackground(new Color(255, 0, 0));
		EnterNotifications.setBounds(385, 469, 268, 65);
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
	 
	
	 
	 
		 
		 public void countdown() {
			 
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
							 
						 Calendar cal_now= new GregorianCalendar();
						 Calendar cal_of= new GregorianCalendar();
						 Calendar cal_end= new GregorianCalendar();
						 
						 int now_day = cal_now.get(Calendar.DAY_OF_MONTH);
						 int now_month = cal_now.get(Calendar.MONTH ) ;
						 int now_year = cal_now.get(Calendar.YEAR);
						 
						 cal_now.set(Calendar.DAY_OF_MONTH, now_day);						 
						 cal_now.set(Calendar.MONTH, now_month);
						 cal_now.set(Calendar.YEAR, now_year);
						 
						 
						 
						 int day_of =nums[0];
						 int month_of=nums[1]-1;
						 int year_of= nums[2];
						 
						 
						 cal_of.set(Calendar.DAY_OF_MONTH, day_of);						 
						 cal_of.set(Calendar.MONTH, month_of);
						 cal_of.set(Calendar.YEAR, year_of);
						 
						 cal_end= (Calendar) cal_of.clone();
						 
						 cal_end.add(Calendar.DAY_OF_MONTH, 5);
						 
						
					//	 System.out.println("Date now: "+ cal_now.get(Calendar.DAY_OF_MONTH)+"/"+ (cal_now.get(Calendar.MONTH )+1)+"/"+ cal_now.get(Calendar.YEAR)+
					//			                      "Date of: "+ cal_of.get(Calendar.DAY_OF_MONTH)+"/"+(cal_of.get(Calendar.MONTH )+1)+"/"+ cal_of.get(Calendar.YEAR) +
					//	                              "Date end: "+ cal_end.get(Calendar.DAY_OF_MONTH)+"/"+ (cal_end.get(Calendar.MONTH )+1)+"/"+ cal_end.get(Calendar.YEAR)); 
						 
						 long noOfDaysBetween = ChronoUnit.DAYS.between(cal_now.toInstant(), cal_end.toInstant());
					//	 System.out.println("AAA "+noOfDaysBetween);
						 if (noOfDaysBetween>0)
						    Quarantine_Countdown.setText("Μέρες Καραντίνας Που Απομένουν: "+noOfDaysBetween);
						
						 Quarantine_Countdown.revalidate();
						 
						 
						 
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
		 
	 
		 
		
	
	
	
	
}
