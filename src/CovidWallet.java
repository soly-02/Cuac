
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CovidWallet extends JFrame{
	//Constructors and variables
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JComboBox<String> certificateSelection;// Dropdown box for the user to choose the type of certificate.
	private JButton uploadFile = new JButton("Open File"); //Button that fires up JFileChooser, for file selection.
	private ButtonListener click = new ButtonListener(); //ButtonListener assigned to the button.
	private ComboBoxListener select = new ComboBoxListener(); //ActionListener assigned to Combobox.
	private File file = new File(""); //PDF file is stored here.
	private String filePath; //Path to the PDF file is stored here.
	private String[] kind = {"Πιστοποιητικό Εμβολιασμού", "Πιστοποιητικό Νόσησης", "Rapid Test"};//Array containing the different kinds of certificates.
	
	//test
	
	//Constructor for CovidWallet window.
	public CovidWallet() {
		
		frame.setTitle("Covid Wallet"); //Sets the title.
		panel.setBackground(new Color(0, 0, 51)); //Sets background colour.
		frame.add(panel);
		
		certificateSelection = new JComboBox<String>(kind);
		panel.add(certificateSelection);
		certificateSelection.addActionListener(select);
		
		uploadFile.addActionListener(click);
		panel.add(uploadFile);
				
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(300, 300);
	}
	
	class ComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			certificateSelection.getSelectedItem();
			
		}
		
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser selectFile = new JFileChooser(); //Creates JFileChooser object.
			
			selectFile.setCurrentDirectory(null); //Sets the directory that the file chooser will display by default. (Set to 'Documents')
			selectFile.setDialogTitle("Select Certificate"); //Sets the title of the file chooser's window.
			selectFile.setFileSelectionMode(JFileChooser.FILES_ONLY); // Only files will be displayed.
			selectFile.setFileFilter(new myFileFilter()); // Filters out all files except for PDFs.

			if (selectFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { //If User chooses a file:
			  file = selectFile.getSelectedFile(); // file is stored in the 'file' variable.
			  filePath = file.getAbsolutePath();
			  //System.out.println(file.getAbsolutePath());
			  
			} else {
			  System.out.println("No Selection "); // 'No Selection' is printed in the console when User does not choose a file.
			}
		}
		
	}
	
	//Filter class.
	public class myFileFilter extends FileFilter{
		private String fileFormat = "PDF";
		private char DOTIndex = '.';
		
		@Override
		public boolean accept(File f) {
			if(f.isDirectory()) { // If selected object is a directory, return true. (Made obsolete by exclusion of directories)
				return true;
			
			}else if(extension(f).equalsIgnoreCase(fileFormat)){ //If file is of type PDF, return true.
				return true;
			
			}else { // Else, return false.
				return false;
			}
			
		}

		@Override
		public String getDescription() { // Displays the type of files that are allowed, in the 'Files of Type:' field.
			
			return "PDF files only";
		}
		
		//Checks the extension of a file
		public String extension(File f) {
			String fileName = f.getName();
			int indexFile = fileName.lastIndexOf(DOTIndex);
			
			if(indexFile > 0 && indexFile < fileName.length() - 1) { //If the extension is of type '.pdf', it returns the file name.
				return fileName.substring(indexFile + 1);
			
			}else { //If not, it returns a blank string.
				return "";
			}
		}
		
	}

	public String getFilePath() {
		return filePath;
	}
	
}


