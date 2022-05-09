import java.util.ArrayList;

public class Classroom {

	private int classId;
	private int classSize;
	private ArrayList <SeatInfo> classInfo = new ArrayList();
	
	public Classroom(int classId) {
		this.classId= classId;
		if (classId==1) {
			this.classSize=88;
			
			//Making of class 1 (aithousa 1)
			SeatInfo s1= new SeatInfo(1,2,3,12,13,0,0,0,0,0,0);
			classInfo.add(s1);
			SeatInfo s2= new SeatInfo(2,1,3,4,12,13,14,0,0,0,0);
			classInfo.add(s2);
			SeatInfo s3= new SeatInfo(3,1,2,4,5,13,14,15,0,0,0);
			classInfo.add(s3);
			SeatInfo s4= new SeatInfo(4,2,3,5,13,14,15,0,0,0,0);
			classInfo.add(s4);
			SeatInfo s5= new SeatInfo(5,3,4,15,16,0,0,0,0,0,0);
			classInfo.add(s5);
			SeatInfo s6= new SeatInfo(6,7,8,17,18,0,0,0,0,0,0);
			classInfo.add(s6);
			SeatInfo s7= new SeatInfo(7,6,8,9,18,19,20,0,0,0,0);
			classInfo.add(s7);
			SeatInfo s8= new SeatInfo(8,6,7,9,10,18,19,20,0,0,0);
			classInfo.add(s8);
			SeatInfo s9= new SeatInfo(9,7,8,10,11,19,20,21,0,0,0);
			classInfo.add(s9);
			SeatInfo s10= new SeatInfo(10,8,9,11,20,21,22,0,0,0,0);
			classInfo.add(s10);
			SeatInfo s11= new SeatInfo(11,9,10,21,22,0,0,0,0,0,0);
			classInfo.add(s11);
			
			// ****************1ST ROW DONE****************
			
			SeatInfo s12= new SeatInfo(12,1,2,13,14,23,24,0,0,0,0);
			classInfo.add(s12);
			SeatInfo s13= new SeatInfo(13,1,2,3,12,14,15,23,24,25,0);
			classInfo.add(s13);
			SeatInfo s14= new SeatInfo(14,2,3,4,12,13,15,16,24,25,26);
			classInfo.add(s14);
			SeatInfo s15= new SeatInfo(15,3,4,5,13,14,16,25,26,27,0);
			classInfo.add(s15);
			SeatInfo s16= new SeatInfo(16,4,5,14,15,26,27,0,0,0,0);
			classInfo.add(s16);
			SeatInfo s17= new SeatInfo(17,6,7,18,19,29,29,0,0,0,0);
			classInfo.add(s17);
			SeatInfo s18= new SeatInfo(18,6,7,8,17,19,20,28,29,30,0);
			classInfo.add(s18);
			SeatInfo s19= new SeatInfo(19,7,8,9,17,18,20,21,29,30,31);
			classInfo.add(s19);
			SeatInfo s20= new SeatInfo(20,8,9,10,18,19,21,22,30,31,32);
			classInfo.add(s20);
			SeatInfo s21= new SeatInfo(21,9,10,11,19,20,22,31,32,33,0);
			classInfo.add(s21);
			SeatInfo s22= new SeatInfo(22,10,12,20,21,32,33,0,0,0,0);
			classInfo.add(s22);
			
			// **************** 2ND ROW DONE****************
			
			SeatInfo s23= new SeatInfo(23,12,13,24,25,34,35,0,0,0,0);
			classInfo.add(s23);
			SeatInfo s24= new SeatInfo(24,12,13,14,23,25,26,34,35,36,0);
			classInfo.add(s24);
			SeatInfo s25= new SeatInfo(25,13,14,15,23,24,26,27,35,36,37);
			classInfo.add(s25);
			SeatInfo s26= new SeatInfo(26,14,15,16,24,25,27,36,37,38,0);
			classInfo.add(s26);
			SeatInfo s27= new SeatInfo(27,15,16,25,26,37,38,0,0,0,0);
			classInfo.add(s27);
			SeatInfo s28= new SeatInfo(28,17,18,29,30,39,40,0,0,0,0);
			classInfo.add(s28);
			SeatInfo s29= new SeatInfo(29,17,18,19,28,30,31,40,41,42,0);
			classInfo.add(s29);
			SeatInfo s30= new SeatInfo(30,18,19,20,28,29,31,32,41,42,43);
			classInfo.add(s30);
			SeatInfo s31= new SeatInfo(31,19,20,21,29,30,32,33,40,41,42);
			classInfo.add(s31);
			SeatInfo s32= new SeatInfo(32,20,21,22,30,31,33,42,43,44,0);
			classInfo.add(s32);
			SeatInfo s33= new SeatInfo(33,21,22,31,32,43,44,0,0,0,0);
			classInfo.add(s33);
			
			// ****************3RD ROW DONE****************
			
			SeatInfo s34= new SeatInfo(34,23,24,35,36,45,46,0,0,0,0);
			classInfo.add(s34);
			SeatInfo s35= new SeatInfo(35,23,24,25,34,36,37,45,46,47,0);
			classInfo.add(s35);
			SeatInfo s36= new SeatInfo(36,24,25,26,34,35,37,38,46,47,48);
			classInfo.add(s36);
			SeatInfo s37= new SeatInfo(37,25,26,27,35,36,38,47,48,49,0);
			classInfo.add(s37);
			SeatInfo s38= new SeatInfo(38,26,27,36,37,48,49,0,0,0,0);
			classInfo.add(s38);

			SeatInfo s39= new SeatInfo(39,28,29,40,41,50,51,0,0,0,0);
			classInfo.add(s39);
			SeatInfo s40= new SeatInfo(40,28,29,30,39,41,42,50,51,52,0);
			classInfo.add(s40);
			SeatInfo s41= new SeatInfo(41,29,30,31,39,40,42,43,51,52,53);
			classInfo.add(s41);
			SeatInfo s42= new SeatInfo(42,30,31,32,40,41,43,44,52,53,54);
			classInfo.add(s42);
			SeatInfo s43= new SeatInfo(43,31,32,33,41,42,44,53,54,55,0);
			classInfo.add(s43);
			SeatInfo s44= new SeatInfo(44,32,33,42,43,54,55,0,0,0,0);
			classInfo.add(s44);
			
			// ****************4TH ROW DONE****************

			
		}
	}
	
	
	
	public class SeatInfo{
		private int seatId;
		private ArrayList <Integer> nearbySeats= new ArrayList<Integer>();
		
		public SeatInfo (int seatId, int ns1, int ns2, int ns3, int ns4,
				int ns5,int ns6, int ns7, int ns8, int ns9, int ns10){
			this.seatId= seatId;
			nearbySeats.add(ns1);
			nearbySeats.add(ns2);
			nearbySeats.add(ns3);
			nearbySeats.add(ns4);
			nearbySeats.add(ns5);
			nearbySeats.add(ns6);
			nearbySeats.add(ns7);
			nearbySeats.add(ns8);
			nearbySeats.add(ns9);
			nearbySeats.add(ns10);
			
			
			
			
			
		}
	}
	
	
	
	
}

