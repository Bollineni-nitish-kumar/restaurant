//$Id$
package beans;

public class Viewbean implements java.io.Serializable{
	private int table_no;
	private int no_seats;
	private float cost;
	private int time;
	private String first_name;
	private String last_name;
	private String phone_no;
	private int slot_id;
	public void setSlotid(int slot_id) {
		this.slot_id=slot_id;
	}
	public int getSlotid() {
		return slot_id;
	}
	public void setTableno(int table_no) {
		this.table_no=table_no;
	}
	public int getTableno() {
		return table_no;
	}
	public void setNoseats(int no_seats) {
		this.no_seats=no_seats;
	}
	public int getNoseats() {
		return no_seats;
	}
	public void setCost(float cost) {
		this.cost=cost;
	}
	public float getCost() {
		return cost;
	}
	public void setTime(int time) {
		this.time=time;
	}
	public int getTime() {
		return time;
	}
	public void setFirstname(String first_name) {
		this.first_name=first_name;
	}
	public String getFirstname() {
		return first_name;
	}
	public void setLastname(String last_name) {
		this.last_name=last_name;
	}
	public String getLastname() {
		return last_name;
	}
	public void setPhone(String phone_no) {
		this.phone_no=phone_no;
	}
	public String getPhone() {
		return phone_no;
	}
	

}
