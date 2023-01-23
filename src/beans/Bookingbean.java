//$Id$
package beans;

public class Bookingbean {
	private int no_of_seats;
	private int time;
	private int slot_id;
	private int user_id;
	private String user_name;
	public void setSeats(int no_of_seats) {
		this.no_of_seats=no_of_seats;
	}
	public int getSeats() {
		return no_of_seats;
	}
	public void setUsername(String user_name) {
		this.user_name=user_name;
	}
	public String getUsername() {
		return user_name;
	}
	public void setSlotid(int slot_id) {
		this.slot_id=slot_id;
		
	}
	public int getSlotid() {
		return slot_id;
		
	}
	public void setUserid(int user_id) {
		this.user_id=user_id;
	}
	public int getUserid() {
		return user_id;
	}
	public void setTime(int  time) {
		this.time=time;
	}
	public int getTime() {
		return time;
	}

}
