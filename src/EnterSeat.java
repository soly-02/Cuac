
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class EnterSeat extends JFrame {

	private JPanel contentPane;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private JTextField startTimeField;
	private JTextField endTimeField;
	private JTextField dayEnter;
	private JTextField monthEnter;
	private JTextField yearEnter;
	private JTextField seatEnter;
    private User u;
	

	/**
	 * Create the frame.
	 */
	public EnterSeat(User u) {
		setResizable(false);
		 this.u = u;
		 ButtonGroup G1;
		
		setBounds(100, 100, 867, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(0, 0, 893, 559);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel user_email = new JLabel(u.getEmail());
		user_email.setBounds(10, 11, 167, 21);
		user_email.setForeground(Color.WHITE);
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(user_email);
		
		JLabel SeatAssign = new JLabel("\u0394\u03AE\u03BB\u03C9\u03C3\u03B7 \u0398\u03AD\u03C3\u03B7\u03C2");
		SeatAssign.setForeground(new Color(255, 255, 255));
		SeatAssign.setFont(new Font("Tahoma", Font.BOLD, 22));
		SeatAssign.setBounds(10, 43, 221, 41);
		panel.add(SeatAssign);
		
		JLabel lblNewLabel = new JLabel("\u0395\u03C0\u03B9\u03BB\u03BF\u03B3\u03AE \u0391\u03AF\u03B8\u03BF\u03C5\u03C3\u03B1\u03C2 :");
		lblNewLabel.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(136, 110, 207, 57);
		panel.add(lblNewLabel);
		
		rb1 = new JRadioButton("\u0391\u03BC\u03C6\u03B9\u03B8\u03AD\u03B1\u03C4\u03C1\u03BF 12");
		rb1.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		rb1.setBounds(372, 110, 199, 21);
		panel.add(rb1);
		
		rb2 = new JRadioButton("\u0395\u03C1\u03B3\u03B1\u03C3\u03C4\u03AE\u03C1\u03B9\u03BF 234");
		rb2.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		rb2.setBounds(372, 134, 199, 21);
		panel.add(rb2);
		
		rb3 = new JRadioButton("\u039A\u03A5\u0394");
		rb3.setFont(new Font("Microsoft YaHei", Font.BOLD, 18));
		rb3.setBounds(372, 158, 199, 21);
		panel.add(rb3);
		
		
		 G1 = new ButtonGroup();
		 G1.add(rb1);
		 G1.add(rb2);
		 G1.add(rb3);
		 
		 JLabel lblNewLabel_1 = new JLabel("\u038F\u03C1\u03B1 \u03AD\u03BD\u03B1\u03C1\u03BE\u03B7\u03C2 :");
		 lblNewLabel_1.setForeground(Color.WHITE);
		 lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		 lblNewLabel_1.setBounds(196, 187, 147, 57);
		 panel.add(lblNewLabel_1);
		 
		 startTimeField = new JTextField();
		 startTimeField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		 startTimeField.setBounds(372, 202, 136, 35);
		 panel.add(startTimeField);
		 startTimeField.setColumns(10);
		 
		 JLabel lblNewLabel_1_1 = new JLabel("\u038F\u03C1\u03B1 \u03BB\u03AE\u03BE\u03B7\u03C2 :");
		 lblNewLabel_1_1.setForeground(Color.WHITE);
		 lblNewLabel_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		 lblNewLabel_1_1.setBounds(220, 255, 123, 57);
		 panel.add(lblNewLabel_1_1);
		 
		 endTimeField = new JTextField();
		 endTimeField.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		 endTimeField.setColumns(10);
		 endTimeField.setBounds(372, 259, 136, 35);
		 panel.add(endTimeField);
		 
		 JLabel lblNewLabel_1_1_1 = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 :");
		 lblNewLabel_1_1_1.setForeground(Color.WHITE);
		 lblNewLabel_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		 lblNewLabel_1_1_1.setBounds(206, 323, 147, 57);
		 panel.add(lblNewLabel_1_1_1);
		 
		 dayEnter = new JTextField();
		 dayEnter.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		 dayEnter.setColumns(10);
		 dayEnter.setBounds(372, 345, 107, 35);
		 panel.add(dayEnter);
		 
		 monthEnter = new JTextField();
		 monthEnter.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		 monthEnter.setColumns(10);
		 monthEnter.setBounds(511, 345, 107, 35);
		 panel.add(monthEnter);
		 
		 yearEnter = new JTextField();
		 yearEnter.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		 yearEnter.setColumns(10);
		 yearEnter.setBounds(649, 345, 107, 35);
		 panel.add(yearEnter);
		 
		 JLabel lblNewLabel_1_1_1_1 = new JLabel("\u0398\u03AD\u03C3\u03B7 :");
		 lblNewLabel_1_1_1_1.setForeground(Color.RED);
		 lblNewLabel_1_1_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 24));
		 lblNewLabel_1_1_1_1.setBounds(254, 402, 89, 62);
		 panel.add(lblNewLabel_1_1_1_1);
		 
		 seatEnter = new JTextField();
		 seatEnter.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		 seatEnter.setColumns(10);
		 seatEnter.setBounds(372, 417, 136, 35);
		 panel.add(seatEnter);
		 
		 JButton okButton = new JButton("\u039F\u039A");
		 okButton.setForeground(Color.WHITE);
		 okButton.setBackground(Color.RED);
		 okButton.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		 okButton.setBounds(372, 486, 103, 35);
		 panel.add(okButton);
		 
		 ButtonListener bb= new ButtonListener();
		 okButton.addActionListener(bb);
		 
		 JLabel lblNewLabel_1_1_1_2 = new JLabel("\u039C\u03AD\u03C1\u03B1 ");
		 lblNewLabel_1_1_1_2.setForeground(Color.WHITE);
		 lblNewLabel_1_1_1_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		 lblNewLabel_1_1_1_2.setBounds(393, 308, 70, 46);
		 panel.add(lblNewLabel_1_1_1_2);
		 
		 JLabel lblNewLabel_1_1_1_2_1 = new JLabel("\u039C\u03AE\u03BD\u03B1\u03C2");
		 lblNewLabel_1_1_1_2_1.setForeground(Color.WHITE);
		 lblNewLabel_1_1_1_2_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		 lblNewLabel_1_1_1_2_1.setBounds(530, 308, 70, 46);
		 panel.add(lblNewLabel_1_1_1_2_1);
		 
		 JLabel lblNewLabel_1_1_1_2_2 = new JLabel("\u0388\u03C4\u03BF\u03C2");
		 lblNewLabel_1_1_1_2_2.setForeground(Color.WHITE);
		 lblNewLabel_1_1_1_2_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		 lblNewLabel_1_1_1_2_2.setBounds(670, 308, 70, 46);
		 panel.add(lblNewLabel_1_1_1_2_2);
	}
	
	
	
	
	class ButtonListener implements ActionListener {
		 
		 int classId;
		
		public void actionPerformed(ActionEvent e) {
			 
			
			// Check which class was selected
			if (rb1.isSelected() && Integer.parseInt(seatEnter.getText()) >0 && Integer.parseInt(seatEnter.getText()) <=88) {
				classId=1;
			}
			else if (rb2.isSelected()&& Integer.parseInt(seatEnter.getText()) >0 && Integer.parseInt(seatEnter.getText()) <=35) {
				classId=2;
			}
			else if (rb3.isSelected()&& Integer.parseInt(seatEnter.getText()) >0 && Integer.parseInt(seatEnter.getText()) <=64) {
				classId=3;
			}
			else {
				classId=0;
				JOptionPane.showMessageDialog(null,"Λανθασμένη είσοδος τάξης, παρακαλώ προσπαθήστε ξανά.", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
			}
				
				
				
				boolean answer=validateJavaDate(monthEnter.getText()+"/"+dayEnter.getText() +"/"+yearEnter.getText());
				if (!answer) {
					JOptionPane.showMessageDialog(null,"Λανθασμένη είσοδος ημερομηνίας, παρακαλώ προσπαθήστε ξανά.", "Σφάλμα", JOptionPane.WARNING_MESSAGE);
					classId=0;
					
					
				}
			
					
			if (classId!= 0) {
				String startTime = mapHour(sanitizeHour(startTimeField.getText()));
				String endTime = mapHour(sanitizeHour(endTimeField.getText()));
				
				String code = classId+"/"+ startTime+"/"+ endTime +"/"+ dayEnter.getText()+ "/"+
				monthEnter.getText()+ "/"+ yearEnter.getText()+"/"+seatEnter.getText() + "/"+ u.getEmail();
				System.out.println(code);
				
				u.sendSeatLog( u.getEmail(), Integer.toString(classId)  ,startTime,endTime,  dayEnter.getText()+ "/"+
						monthEnter.getText()+ "/"+ yearEnter.getText(), seatEnter.getText() ); {
					//System.out.println("Seat added successfully");
				JOptionPane.showMessageDialog(null,"Επιτυχής δήλωση θέσης");
				dispose();
				}
				
			    
			}
			
		}

		public String sanitizeHour(String text) {
			if(text.contains(":")) {
				String hour[] = text.split(":");
				return hour[0];
			}
			else {
				return text;
			}
		}
		
		public String mapHour(String text) {
			int hour = Integer.parseInt(text);
			if(hour < 9) {
				hour += 12;
			}
			return Integer.toString(hour);
			
		}

	}
	
	
	 public static boolean validateJavaDate(String strDate)
	   {
		/* Check if date is 'null' */
		if (strDate.trim().equals(""))
		{
		    return true;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try
		    {
		        Date javaDate = sdfrmt.parse(strDate); 
		       // System.out.println(strDate+" is valid date format");
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        //System.out.println(strDate+" is Invalid Date format");
		        return false;
		    }
		    /* Return true if date format is valid */
		    return true;
		}
	   }
	
	
}
