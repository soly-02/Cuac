
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
	private JTextField startTime;
	private JTextField endTime;
	private JTextField dayEnter;
	private JTextField monthEnter;
	private JTextField yearEnter;
	private JTextField seatEnter;
    private User u;
	

	/**
	 * Create the frame.
	 */
	public EnterSeat(User u) {
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
		 
		 startTime = new JTextField();
		 startTime.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		 startTime.setBounds(372, 202, 136, 35);
		 panel.add(startTime);
		 startTime.setColumns(10);
		 
		 JLabel lblNewLabel_1_1 = new JLabel("\u038F\u03C1\u03B1 \u03BB\u03AE\u03BE\u03B7\u03C2 :");
		 lblNewLabel_1_1.setForeground(Color.WHITE);
		 lblNewLabel_1_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		 lblNewLabel_1_1.setBounds(220, 255, 123, 57);
		 panel.add(lblNewLabel_1_1);
		 
		 endTime = new JTextField();
		 endTime.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		 endTime.setColumns(10);
		 endTime.setBounds(372, 259, 136, 35);
		 panel.add(endTime);
		 
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
			if (rb1.isSelected()) {
				classId=1;
			}
			else if (rb2.isSelected()) {
				classId=2;
			}
			else if (rb3.isSelected()) {
				classId=3;
			}
			else 
				classId=0;
			
			if (classId!= 0) {
				
				String code = classId+"/"+ startTime.getText()+"/"+ endTime.getText()+"/"+ dayEnter.getText()+ "/"+
				monthEnter.getText()+ "/"+ yearEnter.getText()+"/"+seatEnter.getText() + "/"+ u.getEmail();
				System.out.println(code);
				// EDW PREPEI NA EXW KLASH APO TON SERVER GIA NA STEILW TON CODE PX SERVER.SEND(String code)
				u.send("seatLog;" + code);
			    dispose();
			}
			
			
			
		}



}
}
