//$Id$
package beans;

public class Availablebean implements java.io.Serializable{
	private int no_of_seats;
	private int slot_id;
	private boolean avail_status;
	private int num_time;
	private int table_id;
	private int time_id;
	private int table_no;
	private float cost;
    public void setTableno(int table_no) {
    	this.table_no=table_no;
    }
    public int getTableno() {
    	return table_no;
    }
    public void setCost(float cost) {
    	this.cost=cost;
    }
    public float getCost() {
    	return  cost;
    }
	public void setSeats(int no_of_seats) {
		this.no_of_seats=no_of_seats;
	}
	public int getSeats() {
		return no_of_seats;
	}
	
	public void setTime(int  num_time) {
		this.num_time=num_time;
	}
	public int getTime() {
		return num_time;
	}
	public void setTableid(int table_id) {
		this.table_id=table_id;
	}
	public int getTableid() {
		return table_id;
	}
	public void setTimeid(int time_id) {
		this.time_id=time_id;
	}
	public int getTimeid() {
		return time_id;
	}
	
	public void setSlotid(int slot_id) {
		this.slot_id=slot_id;
	}
	public int getSlotid() {
		return slot_id;
	}
	public void setAvailstatus(boolean avail_status) {
		this.avail_status=avail_status;
	}
	public boolean getAvailstatus() {
		return avail_status;
	}

}
