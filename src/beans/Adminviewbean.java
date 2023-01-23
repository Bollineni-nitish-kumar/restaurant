//$Id$
package beans;

import java.sql.Timestamp;

public class Adminviewbean implements java.io.Serializable {
	private int user_id;
	private int slot_id;
	private Timestamp timestamp;
	private int table_no;
	private int no_seats;
	private float cost_per_hour;
	private int time_slot;
	private String user_name;
	public int getTableno() {
		return table_no;
	}
	public void setTableno(int table_no) {
		this.table_no = table_no;
	}
	public int getSeats() {
		return no_seats;
	}
	public void setSeats(int no_seats) {
		this.no_seats = no_seats;
	}
	public float getCost() {
		return cost_per_hour;
	}
	public void setCost(float cost_per_hour) {
		this.cost_per_hour = cost_per_hour;
	}
	public int getTimeslot() {
		return time_slot;
	}
	public void setTimeslot(int time_slot) {
		this.time_slot = time_slot;
	}
	public String getUsername() {
		return user_name;
	}
	public void setUsername(String user_name) {
		this.user_name = user_name;
	}
	
	public void setUserid(int user_id) {
		this.user_id=user_id;
		
	}
	public int getUserid() {
		return user_id;
	}
	public void setSlotid(int slot_id) {
		this.slot_id=slot_id;
	}
	public int getSlotid() {
		return slot_id;
	}
	public void setTime(Timestamp timestamp) {
		this.timestamp=timestamp;
		
	}
	public Timestamp getTime() {
		return timestamp;
	}

}
