

import java.util.ArrayList;


public class Notifications {
  
	 String[] message= new String[3];
	/*-------------- C O N S T R U C T O R------------------*/

	public Notifications(int type, String info) {
		
		if (type==1) {
			
			message[0]=" кгнг пистопоигтийоу (ТАДЕ) се (ТАДЕ) леяес ";
			
			
		}
		else if (type==2) {
			
			message[1]=" кгнг йаяамтимас се (ТАДЕ) леяес ";
			
			
		}
		else if (type==3) {
			
			
			message[2]=" пяосовг! стис (гл/миа), бяехгйате йомта се йяоусла стгм аихоуса (аихоуса), ыяа (ыяа), хесг(хесг),"
					+ "паяайакоуле йамте йама тест яе адекжиа ";
			
			
			
		}
	}
	
}
