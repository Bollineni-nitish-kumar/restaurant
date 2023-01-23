//$Id$
package beans;

public class Addbean implements java.io.Serializable{
	private int table_id;
	private int table_no;
	private int no_seats;
	private float price;
	public void setTableid(int table_id) {
		this.table_id=table_id;
	}
	public int getTableid() {
		return table_id;
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
	public void setPrice(float price) {
		this.price=price;
	}
	public float getPrice() {
		return price;
	}

}
