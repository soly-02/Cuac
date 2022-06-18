
public class Infection { // stores current infection data

	private boolean covidStatus;
	private String date;

	//to Countdown 8a to kanei h elena leei
	
	/*-------------- C O N S T R U C T O R------------------*/
	
	public Infection() {
		//super();
		this.covidStatus = false;
        this.date = "0";	
	}


	
	
	/*--------------- Getters Setters------------------*/
	
	
	public boolean getCovidStatus() {
		return covidStatus;
	}


	public void setCovidStatus(boolean covidStatus) {
		this.covidStatus = covidStatus;
	}
	
	public void setInfectionDate(String date) {
		this.date = date;
	}
	
	public String getInfectionDate() {
		return date;
	}
	
	
	
}

