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
			

			// ****************1ST ROW****************
			
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

			// **************** 2ND ROW****************
			
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

			// ****************3RD ROW****************
			
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

			// ****************4TH ROW****************
			
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

			// ****************5TH ROW****************
			
			SeatInfo s45= new SeatInfo(45,34,35,46,47,56,57,0,0,0,0);
			classInfo.add(s45);
			SeatInfo s46= new SeatInfo(46,34,35,36,45,47,48,56,57,58,0);
			classInfo.add(s46);
			SeatInfo s47= new SeatInfo(47,35,36,37,45,46,48,49,57,58,59);
			classInfo.add(s47);
			SeatInfo s48= new SeatInfo(48,36,37,38,46,47,49,58,59,60,0);
			classInfo.add(s48);
			SeatInfo s49= new SeatInfo(49,37,38,47,48,59,60,0,0,0,0);
			classInfo.add(s49);
			SeatInfo s50= new SeatInfo(50,39,40,51,52,61,62,0,0,0,0);
			classInfo.add(s50);
			SeatInfo s51= new SeatInfo(51,39,40,41,50,52,53,61,62,63,0);
			classInfo.add(s51);
			SeatInfo s52= new SeatInfo(52,40,41,32,50,51,53,54,62,63,64);
			classInfo.add(s52);
			SeatInfo s53= new SeatInfo(53,41,42,43,51,52,54,55,63,64,65);
			classInfo.add(s53);
			SeatInfo s54= new SeatInfo(54,42,43,44,52,53,55,64,65,66,0);
			classInfo.add(s54);
			SeatInfo s55= new SeatInfo(55,43,44,53,54,65,66,0,0,0,0);
			classInfo.add(s55);
			
			// ****************6TH ROW****************
			
			SeatInfo s56= new SeatInfo(56,45,46,57,58,67,68,0,0,0,0);
			classInfo.add(s56);
			SeatInfo s57= new SeatInfo(57,45,46,47,56,58,59,67,68,69,0);
			classInfo.add(s57);
			SeatInfo s58= new SeatInfo(58,46,47,48,56,57,59,60,68,69,70);
			classInfo.add(s58);
			SeatInfo s59= new SeatInfo(59,47,48,49,57,58,60,69,70,71,0);
			classInfo.add(s59);
			SeatInfo s60= new SeatInfo(60,48,49,58,59,70,71,0,0,0,0);
			classInfo.add(s60);
			SeatInfo s61= new SeatInfo(61,50,51,62,63,72,73,0,0,0,0);
			classInfo.add(s61);
			SeatInfo s62= new SeatInfo(62,50,51,52,61,63,64,72,73,74,0);
			classInfo.add(s62);
			SeatInfo s63= new SeatInfo(63,51,52,53,61,62,64,65,73,74,75);
			classInfo.add(s63);
			SeatInfo s64= new SeatInfo(64,52,53,54,62,63,65,66,74,75,76);
			classInfo.add(s64);
			SeatInfo s65= new SeatInfo(65,53,54,55,63,64,66,75,76,77,0);
			classInfo.add(s65);
			SeatInfo s66= new SeatInfo(66,54,55,64,65,76,77,0,0,0,0);
			classInfo.add(s66);

			// ****************7TH ROW****************
			
			SeatInfo s67 = new SeatInfo(67,56,57,68,69,78,79,0,0,0,0);
			classInfo.add(s67);
			SeatInfo s68= new SeatInfo(68,56,57,58,67,69,70,78,79,80,0);
			classInfo.add(s68);
			SeatInfo s69= new SeatInfo(69,57,58,59,67,68,70,71,79,80,81);
			classInfo.add(s69);
			SeatInfo s70= new SeatInfo(70,58,59,60,68,69,71,80,81,82,0);
			classInfo.add(s70);
			SeatInfo s71= new SeatInfo(71,59,60,69,70,81,82,0,0,0,0);
			classInfo.add(s71);
			SeatInfo s72= new SeatInfo(72,61,62,73,74,83,84,0,0,0,0);
			classInfo.add(s72);
			SeatInfo s73= new SeatInfo(73,61,62,63,72,74,75,83,84,85,0);
			classInfo.add(s73);
			SeatInfo s74= new SeatInfo(74,62,63,64,72,73,75,76,84,85,86);
			classInfo.add(s74);
			SeatInfo s75= new SeatInfo(75,63,64,65,73,74,76,77,85,86,87);
			classInfo.add(s75);
			SeatInfo s76= new SeatInfo(76,64,65,66,74,75,77,86,87,88,0);
			classInfo.add(s76);
			SeatInfo s77= new SeatInfo(77,65,66,75,76,87,88,0,0,0,0);
			classInfo.add(s77);
			
			// ****************8TH ROW****************
			
			SeatInfo s78 = new SeatInfo(78,67,68,79,80,0,0,0,0,0,0);
			classInfo.add(s78);
			SeatInfo s79= new SeatInfo(79,67,68,69,78,80,81,0,0,0,0);
			classInfo.add(s79);
			SeatInfo s80= new SeatInfo(69,68,69,70,78,79,81,82,0,0,0);
			classInfo.add(s80);
			SeatInfo s81= new SeatInfo(81,69,70,71,79,80,82,0,0,0,0);
			classInfo.add(s81);
			SeatInfo s82= new SeatInfo(82,70,71,80,81,82,0,0,0,0,0);
			classInfo.add(s82);
			SeatInfo s83= new SeatInfo(83,72,73,84,85,0,0,0,0,0,0);
			classInfo.add(s83);
			SeatInfo s84= new SeatInfo(84,72,73,74,83,85,86,0,0,0,0);
			classInfo.add(s84);
			SeatInfo s85= new SeatInfo(85,73,74,75,83,84,86,87,0,0,0);
			classInfo.add(s85);
			SeatInfo s86= new SeatInfo(86,74,75,76,84,85,87,88,0,0,0);
			classInfo.add(s86);
			SeatInfo s87= new SeatInfo(87,75,76,77,85,86,88,0,0,0,0);
			classInfo.add(s87);
			SeatInfo s88= new SeatInfo(88,76,77,86,87,0,0,0,0,0,0);
			classInfo.add(s88);
			
		}
		
		
		
		else if (classId==2) {
			this.classSize=35;
			
			//Making of class 2 (aithousa 2)
			
			// ****************1ST ROW****************

			SeatInfo s1= new SeatInfo(1,2,3,4,11,0,0,0,0,0,0);
			classInfo.add(s1);
			SeatInfo s2= new SeatInfo(2,1,3,4,11,0,0,0,0,0,0);
			classInfo.add(s2);
			SeatInfo s3= new SeatInfo(3,1,2,4,5,6,13,0,0,0,0);
			classInfo.add(s3);
			SeatInfo s4= new SeatInfo(4,2,3,5,1,6,13,0,0,0,0);
			classInfo.add(s4);
			SeatInfo s5= new SeatInfo(5,3,4,6,7,8,15,0,0,0,0);
			classInfo.add(s5);
			SeatInfo s6= new SeatInfo(6,7,8,3,4,5,15,0,0,0,0);
			classInfo.add(s6);
			SeatInfo s7= new SeatInfo(7,6,8,9,5,10,17,0,0,0,0);
			classInfo.add(s7);
			SeatInfo s8= new SeatInfo(8,6,7,9,10,5,17,0,0,0,0);
			classInfo.add(s8);
			SeatInfo s9= new SeatInfo(9,7,8,10,19,0,0,0,0,0,0);
			classInfo.add(s9);
			SeatInfo s10= new SeatInfo(10,8,9,7,19,0,0,0,0,0,0);
			classInfo.add(s10);

			// **************** 2ND ROW****************

			SeatInfo s11= new SeatInfo(11,12,13,14,2,34,35,0,0,0,0);
			classInfo.add(s11);			
			SeatInfo s12= new SeatInfo(12,11,13,14,34,35,0,0,0,0,0);
			classInfo.add(s12);
			SeatInfo s13= new SeatInfo(13,11,12,14,4,15,16,0,0,0,0);
			classInfo.add(s13);
			SeatInfo s14= new SeatInfo(14,11,12,13,15,16,0,0,0,0,0);
			classInfo.add(s14);
			SeatInfo s15= new SeatInfo(15,13,14,16,6,17,18,0,0,0,0);
			classInfo.add(s15);
			SeatInfo s16= new SeatInfo(16,13,14,15,17,18,0,0,0,0,0);
			classInfo.add(s16);
			SeatInfo s17= new SeatInfo(17,15,16,18,8,19,20,0,0,0,0);
			classInfo.add(s17);
			SeatInfo s18= new SeatInfo(18,15,16,17,19,20,0,0,0,0,0);
			classInfo.add(s18);
			SeatInfo s19= new SeatInfo(19,20,21,22,10,17,18,0,0,0,0);
			classInfo.add(s19);
			SeatInfo s20= new SeatInfo(20,19,21,22,17,18,0,0,0,0,0);
			classInfo.add(s20);
			SeatInfo s21= new SeatInfo(21,22,19,20,0,0,0,0,0,0,0);
			classInfo.add(s21);
			SeatInfo s22= new SeatInfo(22,21,19,20,0,32,33,0,0,0,0);
			classInfo.add(s22);		
			SeatInfo s34= new SeatInfo(34,11,12,35,0,0,0,0,0,0,0);
			classInfo.add(s34);
			SeatInfo s35= new SeatInfo(35,11,12,34,0,0,0,0,0,0,0);
			classInfo.add(s35);
			
			// ****************3RD ROW****************
			
			SeatInfo s23= new SeatInfo(23,24,25,0,0,0,0,0,0,0,0);
			classInfo.add(s23);
			SeatInfo s24= new SeatInfo(24,23,25,26,27,0,0,0,0,0,0);
			classInfo.add(s24);
			SeatInfo s25= new SeatInfo(25,23,24,26,27,0,0,0,0,0,0);
			classInfo.add(s25);
			SeatInfo s26= new SeatInfo(26,24,25,27,28,29,0,0,0,0,0);
			classInfo.add(s26);
			SeatInfo s27= new SeatInfo(27,24,25,26,28,29,0,0,0,0,0);
			classInfo.add(s27);
			SeatInfo s28= new SeatInfo(28,26,27,29,30,31,0,0,0,0,0);
			classInfo.add(s28);
			SeatInfo s29= new SeatInfo(29,26,27,28,30,31,0,0,0,0,0);
			classInfo.add(s29);
			SeatInfo s30= new SeatInfo(30,31,32,33,28,29,0,0,0,0,0);
			classInfo.add(s30);
			SeatInfo s31= new SeatInfo(31,30,32,33,28,29,0,0,0,0,0);
			classInfo.add(s31);
			SeatInfo s32= new SeatInfo(32,33,30,31,0,0,0,0,0,0,0);
			classInfo.add(s32);
			SeatInfo s33= new SeatInfo(33,32,30,31,0,0,0,0,0,0,0);
			classInfo.add(s33);

			}
		
		
		
		//Making of class 1 (aithousa 3)
		
		else if (classId==3) {
			this.classSize=64;
			
		// ****************1ST LAB****************
			// *****************1ST ROW*****************
			
			SeatInfo s1= new SeatInfo(1,2,3,9,10,0,0,0,0,0,0);
			classInfo.add(s1);
			SeatInfo s2= new SeatInfo(2,1,3,4,9,10,11,0,0,0,0);
			classInfo.add(s2);
			SeatInfo s3= new SeatInfo(3,1,2,4,9,10,11,0,0,0,0);
			classInfo.add(s3);
			SeatInfo s4= new SeatInfo(4,2,3,11,12,0,0,0,0,0,0);
			classInfo.add(s4);
			SeatInfo s5= new SeatInfo(5,6,7,13,14,0,0,0,0,0,0);
			classInfo.add(s5);
			SeatInfo s6= new SeatInfo(6,5,7,8,13,14,15,0,0,0,0);
			classInfo.add(s6);
			SeatInfo s7= new SeatInfo(7,5,6,8,14,15,16,0,0,0,0);
			classInfo.add(s7);
			SeatInfo s8= new SeatInfo(8,6,7,15,16,0,0,0,0,0,0);
			classInfo.add(s8);
			
			// *****************2ND ROW*****************
			
			SeatInfo s9= new SeatInfo(9,1,2,10,11,17,28,0,0,0,0);
			classInfo.add(s9);
			SeatInfo s10= new SeatInfo(10,1,2,3,9,11,12,17,18,19,0);
			classInfo.add(s10);
			SeatInfo s11= new SeatInfo(11,2,3,4,9,10,12,18,19,20,0);
			classInfo.add(s11);
			SeatInfo s12= new SeatInfo(12,3,4,10,11,19,20,0,0,0,0);
			classInfo.add(s12);
			SeatInfo s13= new SeatInfo(13,5,6,14,15,21,22,0,0,0,0);
			classInfo.add(s13);
			SeatInfo s14= new SeatInfo(14,5,6,7,13,15,16,21,22,23,0);
			classInfo.add(s14);
			SeatInfo s15= new SeatInfo(15,6,7,8,13,14,16,22,23,24,0);
			classInfo.add(s15);
			SeatInfo s16= new SeatInfo(16,7,8,14,15,23,24,0,0,0,0);
			classInfo.add(s16);
			
			// *****************3RD ROW*****************
			
			SeatInfo s17= new SeatInfo(17,9,10,18,19,25,26,0,0,0,0);
			classInfo.add(s17);
			SeatInfo s18= new SeatInfo(18,9,10,11,17,19,20,25,26,27,0);
			classInfo.add(s18);
			SeatInfo s19= new SeatInfo(19,10,11,12,17,18,20,26,27,28,0);
			classInfo.add(s19);
			SeatInfo s20= new SeatInfo(20,11,12,18,19,27,28,0,0,0,0);
			classInfo.add(s20);
			SeatInfo s21= new SeatInfo(21,13,14,22,23,29,30,0,0,0,0);
			classInfo.add(s21);
			SeatInfo s22= new SeatInfo(22,13,14,15,21,23,24,29,30,0,0);
			classInfo.add(s22);
			SeatInfo s23= new SeatInfo(23,14,15,16,21,22,24,30,0,0,0);
			classInfo.add(s23);
			SeatInfo s24= new SeatInfo(24,15,16,22,23,0,0,0,0,0,0);
			classInfo.add(s24);
			
			// *****************4TH ROW*****************
			
			SeatInfo s25= new SeatInfo(25,17,18,26,27,31,32,0,0,0,0);
			classInfo.add(s25);
			SeatInfo s26= new SeatInfo(26,17,18,19,25,27,28,31,32,33,0);
			classInfo.add(s26);
			SeatInfo s27= new SeatInfo(27,18,19,20,25,26,28,32,33,34,0);
			classInfo.add(s27);
			SeatInfo s28= new SeatInfo(28,19,20,26,27,33,34,0,0,0,0);
			classInfo.add(s28);
			SeatInfo s29= new SeatInfo(29,21,22,30,35,36,0,0,0,0,0);
			classInfo.add(s29);
			SeatInfo s30= new SeatInfo(30,21,22,23,29,35,36,0,0,0,0);
			classInfo.add(s30);
			
			// *****************5TH ROW*****************
			
			SeatInfo s31= new SeatInfo(31,25,26,32,33,37,38,0,0,0,0);
			classInfo.add(s31);
			SeatInfo s32= new SeatInfo(32,25,26,27,31,33,34,37,38,39,0);
			classInfo.add(s32);
			SeatInfo s33= new SeatInfo(33,26,27,28,31,32,34,38,39,40,0);
			classInfo.add(s33);
			SeatInfo s34= new SeatInfo(34,27,28,32,33,39,40,0,0,0,0);
			classInfo.add(s34);
			SeatInfo s35= new SeatInfo(35,29,30,36,0,0,0,0,0,0,0);
			classInfo.add(s35);
			SeatInfo s36= new SeatInfo(36,29,30,36,0,0,0,0,0,0,0);
			classInfo.add(s36);
			
			// *****************6TH ROW*****************
			
			SeatInfo s37= new SeatInfo(37,31,32,38,39,0,0,0,0,0,0);
			classInfo.add(s37);
			SeatInfo s38= new SeatInfo(38,31,32,33,37,39,40,0,0,0,0);
			classInfo.add(s38);
			SeatInfo s39= new SeatInfo(39,32,33,34,37,38,40,0,0,0,0);
			classInfo.add(s39);
			SeatInfo s40= new SeatInfo(40,33,34,38,39,0,0,0,0,0,0);
			classInfo.add(s40);
			
			// *****************7TH ROW*****************
			
		// ****************2ND LAB****************
			
			// ****************1ST ROW****************
			SeatInfo s41= new SeatInfo(41,42,43,48,49,0,0,0,0,0,0);
			classInfo.add(s41);
			SeatInfo s42= new SeatInfo(42,41,43,44,48,49,50,0,0,0,0);
			classInfo.add(s42);
			SeatInfo s43= new SeatInfo(43,41,42,44,45,42,49,50,0,0,0);
			classInfo.add(s43);
			SeatInfo s44= new SeatInfo(44,42,43,45,46,50,51,52,0,0,0);
			classInfo.add(s44);
			SeatInfo s45= new SeatInfo(45,43,44,46,51,52,53,0,0,0,0);
			classInfo.add(s45);
			SeatInfo s46= new SeatInfo(46,44,45,52,53,0,0,0,0,0,0);
			classInfo.add(s46);
			
			// *****************2ND ROW*****************
			
			SeatInfo s48= new SeatInfo(48,41,42,49,56,57,0,0,0,0,0);
			classInfo.add(s48);
			SeatInfo s49= new SeatInfo(49,41,42,43,48,50,51,56,57,0,0);
			classInfo.add(s49);
			SeatInfo s50= new SeatInfo(50,42,43,44,48,49,51,52,57,0,0);
			classInfo.add(s50);
			SeatInfo s51= new SeatInfo(51,43,44,45,49,50,52,53,0,0,0);
			classInfo.add(s51);
			SeatInfo s52= new SeatInfo(52,44,45,46,50,51,53,0,0,0,0);
			classInfo.add(s52);
			SeatInfo s53= new SeatInfo(53,45,46,51,52,0,0,0,0,0,0);
			classInfo.add(s53);
			
			// *****************3RD ROW*****************
			
			SeatInfo s56= new SeatInfo(56,48,49,57,58,59,60,0,0,0,0);
			classInfo.add(s56);
			SeatInfo s57= new SeatInfo(57,48,49,50,56,58,59,60,0,0,0);
			classInfo.add(s57);
			SeatInfo s58= new SeatInfo(58,56,57,59,60,0,0,0,0,0,0);
			classInfo.add(s58);
			// *****************3RD (and a half) ROW*****************
			SeatInfo s59= new SeatInfo(59,56,57,58,60,0,0,0,0,0,0);
			classInfo.add(s59);
			SeatInfo s60= new SeatInfo(60,56,57,58,59,0,0,0,0,0,0);
			classInfo.add(s60);
			
			// ****************4TH ROW****************
			
			SeatInfo s61= new SeatInfo(61,59,60,62,63,0,0,0,0,0,0);
			classInfo.add(s61);
			SeatInfo s62= new SeatInfo(62,59,60,61,63,64,0,0,0,0,0);
			classInfo.add(s62);
			SeatInfo s63= new SeatInfo(63,60,61,62,64,0,0,0,0,0,0);
			classInfo.add(s63);
			SeatInfo s64= new SeatInfo(64,62,63,0,0,0,0,0,0,0,0);
			classInfo.add(s64);
			
			//sthn gwnia
			
			SeatInfo s47= new SeatInfo(47,54,55,0,0,0,0,0,0,0,0);
			classInfo.add(s47);
			SeatInfo s54= new SeatInfo(54,47,55,0,0,0,0,0,0,0,0);
			classInfo.add(s54);
			SeatInfo s55= new SeatInfo(55,47,54,0,0,0,0,0,0,0,0);
			classInfo.add(s55);
		}
		
		else {
			System.out.println("No such Classroom ID!!" + '\n' + "The Classroom ID's are:" + '\n' + "1- AMFITHEATRO 12" + '\n' + "2- ERGASTHRIO 234" + '\n' + "ERGASTHRIO KYD");
		}
	}
	
	
	
	
	
	
	public ArrayList <SeatInfo> getclassInfo(int ClassId) {
		
		return classInfo;
		
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
		
		
		public int getSeatId() {
			
			return seatId;
		}
		
       public ArrayList <Integer> getNearSeatInfo (){
			
			return nearbySeats;
		}
		
		
		
			
			


			
			
			
		}
	
	public ArrayList <Integer> getSeatInfo(int SeatId,int ClassId,Classroom c ){
		for (int i=0; i<c.getclassInfo(ClassId).size();i++) {
			if (c.getclassInfo(ClassId).get(i).getSeatId()== SeatId) {
				System.out.println(c.getclassInfo(ClassId).get(i).getNearSeatInfo().toString());
				return c.getclassInfo(ClassId).get(i).getNearSeatInfo();
				
			}
			
			
		}
		return null;
		
		
	}

	
	
	
	

	public ArrayList <Integer> getSeats(int ClassId, int SeatId,Classroom c) {
		
		c.getclassInfo(ClassId);
		return getSeatInfo(SeatId,ClassId,c );
	
	
	}
	
	
	
	
}

