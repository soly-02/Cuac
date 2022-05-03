import java.sql.Time;
import java.util.Date;

public class Seats {
	private Integer seatNum;
	private Date date;
	private Time time;
	private Classroom classroom;

	
	
	public Integer getSeatNum() {
		return seatNum;
	}



	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public Time getTime() {
		return time;
	}



	public void setTime(Time time) {
		this.time = time;
	}



	public Seats(Integer seatNum, Date date, Time time, Classroom classroom) {
		this.seatNum = seatNum;
		this.date = date;
		this.time = time;
		this.classroom = classroom;
	}
	
	
}
