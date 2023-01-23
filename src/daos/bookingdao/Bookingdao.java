//$Id$
package daos.bookingdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Availablebean;
import beans.Bookingbean;
import beans.Viewbean;

public class Bookingdao {
	public List<Viewbean> getBookdetails(Bookingbean bookbean) throws ClassNotFoundException{
		List<Viewbean> list=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

		            
		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select t1.table_number,t1.no_seats,t1.cost_per_hour,t2.slot_id,t3.time_slot,t4.first_name,t4.last_name,t4.mobile_no from \n" + 
		            		"  table_details t1 join table_status t2 on t2.table_id=t1.table_id \n" + 
		            		"  join timings t3 on t2.time_id=t3.time_id join user_details t4 on t4.user_id=? where t2.slot_id in(select slot_id from orders where user_id=?);")){
			 
			 preparedStatement.setInt(1, bookbean.getUserid());
	         preparedStatement.setInt(2, bookbean.getUserid());
	         
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            while(rs.next()) {
	            	Viewbean beanobj=new Viewbean();
	            	beanobj.setSlotid(rs.getInt("slot_id"));
	            	beanobj.setTableno(rs.getInt("table_number"));
	            	beanobj.setNoseats(rs.getInt("no_seats"));
	            	beanobj.setCost(rs.getFloat("cost_per_hour"));
	            	beanobj.setTime(rs.getInt("time_slot"));
	            	beanobj.setFirstname(rs.getString("first_name"));
	            	beanobj.setLastname(rs.getString("last_name"));
	            	beanobj.setPhone(rs.getString("mobile_no"));
	            	list.add(beanobj);
	            }
	            preparedStatement.close();
	            connection.close();
	           
		 }
		 catch (SQLException e) {
	           e.printStackTrace();
	        }
		
		
		
		return list;
		
	}
	public Bookingbean retrieve(Bookingbean bookbean) throws ClassNotFoundException{
		//List<Bookingbean> list=new ArrayList<>();
		Bookingbean beanobj=new Bookingbean();
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

		            
		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select user_id from user_details where user_name=? or gmail=?")){
			 
			 preparedStatement.setString(1, bookbean.getUsername());
	         preparedStatement.setString(2, bookbean.getUsername());
	         System.out.println(bookbean.getUsername());
	         
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            if(rs.next()) {
	            	//Bookingbean beanobj=new Bookingbean();
	            	beanobj.setUserid(rs.getInt("user_id"));
	            
	            }
	            preparedStatement.close();
	            connection.close();    
		 }
		 catch (SQLException e) {
	           e.printStackTrace();
	        }
		
		return beanobj;
	}
	public boolean updateDetails(List<Availablebean> lst) throws ClassNotFoundException {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
	        try {
	        	Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");
	        
                
	        	for(Availablebean beanobj:lst) {
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("update table_status set avail_status=false where slot_id=? and table_id=? and time_id=? ");
	            preparedStatement.setInt(1, beanobj.getSlotid());
	            preparedStatement.setInt(2, beanobj.getTableid());
	            preparedStatement.setInt(3, beanobj.getTimeid());
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	        	}
	            connection.close();
	            
	        
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	         return true;	
	}
	public int updateOrders(List<Availablebean> lst,Bookingbean bookbean) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        int rs=0;
	        try {
	        	Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            // Step 2:Create a statement using connection object
	        	for(Availablebean availbean:lst) {
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("insert into orders(slot_id,user_id) values(?,?) ");
	            preparedStatement.setInt(1, availbean.getSlotid());
	            preparedStatement.setInt(2, bookbean.getUserid());
	           rs= preparedStatement.executeUpdate();
	            preparedStatement.close();
	        	}
	            connection.close();
	            
	            
	        }catch (SQLException e) {
	           e.printStackTrace();
	        }
	            return rs;		
	}

}
