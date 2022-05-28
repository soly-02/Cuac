
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Classroom c1= new Classroom(1);
		System.out.println(c1.getSeatInfo(1, 1, c1).toString()); //string epistrofhs array of nearby seats
		
		SignUp_Register frame = new SignUp_Register();
		frame.setVisible(true);
		
	}

}
