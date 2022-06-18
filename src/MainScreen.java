

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;



public class MainScreen extends JFrame {

	private JPanel contentPane;
	private User u;
	private MainScreen m;
    private JLabel user_email;
    JLabel Quarantine_Countdown;
    long previousData=-1;
	/**
	 * Create the frame.
	 */
	public MainScreen(User u) {
		// adding gui components
		setResizable(false);
		this.u = u;
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\UOMLOGOGR22.png"));
		setTitle("Cuac");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 921, 540);
		contentPane.add(panel);
		panel.setLayout(null);
		
		user_email = new JLabel(u.getEmail());
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user_email.setBounds(68, 20, 167, 38);
		user_email.setForeground(new Color(255, 255, 255));
		panel.add(user_email);
		
		Quarantine_Countdown = new JLabel("");
		Quarantine_Countdown.setFont(new Font("Tahoma", Font.BOLD, 22));
		Quarantine_Countdown.setForeground(Color.RED);
		Quarantine_Countdown.setHorizontalAlignment(SwingConstants.LEFT);
		Quarantine_Countdown.setBounds(383, 13, 425, 45);
		panel.add(Quarantine_Countdown);
		
		
		
		
		
		
		JButton EnterSeat = new JButton("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u0398\u03AD\u03C3\u03B7\u03C2");
		EnterSeat.setBackground(new Color(255, 255, 255));
		EnterSeat.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterSeat.setBounds(330, 117, 268, 65);
		panel.add(EnterSeat);
		
		JButton EnterCovidWallet = new JButton("Covid Wallet");
		
		EnterCovidWallet.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterCovidWallet.setBackground(Color.WHITE);
		EnterCovidWallet.setBounds(330, 219, 268, 65);
		panel.add(EnterCovidWallet);
		
		JButton EnterInfection = new JButton("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u039D\u03CC\u03C3\u03B7\u03C3\u03B7\u03C2");
		
		EnterInfection.setFont(new Font("Tahoma", Font.PLAIN, 29));
		EnterInfection.setBackground(Color.WHITE);
		EnterInfection.setBounds(330, 318, 268, 65);
		panel.add(EnterInfection);
		
		JButton EnterNotifications = new JButton("\u0395\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2");
		EnterNotifications.setFont(new Font("Tahoma", Font.PLAIN, 32));
		EnterNotifications.setBackground(new Color(255, 0, 0));
		EnterNotifications.setBounds(330, 445, 268, 65);
		panel.add(EnterNotifications);
		
		if(!(u.getInfectionDate()==(null))) {
			System.out.println("countdown start");
			countdown() ;
		}
		
		
		
		 ButtonListener bb= new ButtonListener();
		 EnterSeat.addActionListener(bb);   
		 EnterCovidWallet.addActionListener(bb);  
		 EnterInfection.addActionListener(bb);   
		 EnterNotifications.addActionListener(bb);  
		
		this.addWindowListener(new WindowAdapter() { //exit dialog
		      public void windowClosing(WindowEvent we) {
		          int result = JOptionPane.showConfirmDialog(null, "Εξοδος;", "Exit Confirmation : ", JOptionPane.YES_NO_OPTION);
		          if (result == JOptionPane.YES_OPTION) {
		            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		          	u.closeConnection();
		          }	
		          else if (result == JOptionPane.NO_OPTION) {
		            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		          }  
		        }
		      });
		
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
			 
			 //countdown of days of user's quarantine begins
			 Thread clock= new Thread() {
				 String dateInfection;
				 public void run() {
					 
					 try {
						 for(;;) {
							 
							 if(!(u.getInfectionDate()==null)) {
							 dateInfection = u.getInfectionDate();
							 }
							 else
								 dateInfection = u.getInfection().getInfectionDate();
							 
							 String[] nums3= dateInfection.split("/");   // splitting the numbers and adding them in a table 
							 int	nums[] = {-1,-1,-1};
								
								for (int index = 0; index < nums3.length; index++) {
									nums[index]=Integer.parseInt(nums3[index]);
								                     
								}
							 
						 Calendar cal_now= new GregorianCalendar();  //calendar of current date
						 Calendar cal_of= new GregorianCalendar();    //calendar of date of infection
						 Calendar cal_end= new GregorianCalendar();   //calendar of date when quarantine ends
						 
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
						 
						
					
						 long noOfDaysBetween = ChronoUnit.DAYS.between(cal_now.toInstant(), cal_end.toInstant());
				
						 if (noOfDaysBetween>0) //checks how many days are left and updates the countdown label accordingly 
							  Quarantine_Countdown.setText("Μέρες Καραντίνας Που Απομένουν: "+noOfDaysBetween);
						
						 if (noOfDaysBetween==0)
							    Quarantine_Countdown.setText("");
						 
						 if (previousData!= noOfDaysBetween ) { // if a date has changed, updates the info on the database
							 u.getUserNotifications().updateMessage(2,"Η καραντίνα σας λήγει σε : "+noOfDaysBetween+ " μέρες" );
							 u.updateNotification(2,u.getEmail(),"Η καραντίνα σας λήγει σε : "+noOfDaysBetween+ " μέρες");
						 }
						
						 
						 previousData= noOfDaysBetween;
						 
						 
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
