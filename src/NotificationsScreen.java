
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.regex.Pattern;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class NotificationsScreen extends JFrame {

	private JPanel contentPane;
	private User u;
	

	/**
	 * Create the frame.
	 */
	public NotificationsScreen(User u) {
		setResizable(false);
		
		this.u=u;
		String oldText=" ";
		
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\UOMLOGOGR22.png"));
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 923, 482);
		panel.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setForeground(Color.WHITE);
		textPane.setBackground(new Color(0, 0, 51));
		scrollPane.setViewportView(textPane);
		textPane.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		
		JLabel user_email = new JLabel(u.getEmail());
		user_email.setForeground(Color.WHITE);
		user_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		user_email.setBounds(10, 11, 167, 21);
		panel.add(user_email);
		
		JLabel Notiflabel = new JLabel("\u0395\u03B9\u03B4\u03BF\u03C0\u03BF\u03B9\u03AE\u03C3\u03B5\u03B9\u03C2");
		Notiflabel.setForeground(Color.WHITE);
		Notiflabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		Notiflabel.setBounds(10, 43, 221, 41);
		panel.add(Notiflabel);
		
		String gap="--------------------------------------------------------------------------------------------------------";
		
		

		if (u.getNotifFromDB(1)!=null) {
			textPane.setText(oldText+u.getNotifFromDB(1)+"\n"+gap);
		    oldText=textPane.getText();
		}
		
		if (u.getNotifFromDB(2)!=null) {
			textPane.setText(oldText+u.getNotifFromDB(2)+"\n"+gap);
		    oldText=textPane.getText();
		}
		
	
		
		String[] mess;
		
		
		
		if (u.getNotifFromDB(3)!=null) {
			

			
			mess= u.getNotifFromDB(3).split(Pattern.quote("$$"));
			for (int i=mess.length-1;i>=0;i--) {
				System.out.println(mess[i]);
				textPane.setText(oldText+mess[i]+"\n"+gap);
				oldText=textPane.getText();
			}
			
		}
		
		
		
		
		
}
}
