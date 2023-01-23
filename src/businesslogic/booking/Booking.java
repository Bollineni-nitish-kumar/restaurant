//$Id$
package businesslogic.booking;
import java.util.List;


import beans.Availablebean;
import beans.Bookingbean;
import beans.Viewbean;
import daos.bookingdao.Bookingdao;

public class Booking {
	private Bookingdao bookdao;
	public List<Viewbean> getBookdetails(Bookingbean bookbean){
		bookdao=new Bookingdao();
		List<Viewbean> list=null;
		try {
			list = bookdao.getBookdetails(bookbean);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
public boolean bookingtable(List<Availablebean> lst,Bookingbean bookbean) {
		boolean status=false;
		 bookdao=new Bookingdao();
		try {
			bookdao.updateDetails(lst);
		} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
			   Bookingbean beanobj=null;
			try {
				beanobj = bookdao.retrieve(bookbean);
				System.out.println(bookbean.getUsername());
			} 
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			  
			   int myresult=0;
			   try {
				myresult=bookdao.updateOrders(lst,beanobj);
			} 
			  catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			   if(myresult!=0) {
				   status=true;
			   }
			   return status;
		
	}
	

}
