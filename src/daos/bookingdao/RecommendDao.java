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
public class RecommendDao {
	public List< Availablebean> retrieve(Bookingbean bookbean) throws ClassNotFoundException{
		List<Availablebean> lst=new ArrayList<>();
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

		            
		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select t1.table_number,t3.time_slot from \n" + 
		            		"  table_details t1 join table_status t2 on t2.table_id=t1.table_id \n" + 
		            		"  join timings t3 on t2.time_id=t3.time_id where t2.slot_id in (select slot_id from Customerorders where user_id=? group by user_id,slot_id order by count(slot_id) desc) limit 1 ;")){
			 
			 preparedStatement.setInt(1, bookbean.getUserid());
	         
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            if(rs.next()) {
	            	//Bookingbean beanobj=new Bookingbean();
	            	Availablebean beanobj=new Availablebean();
	            	beanobj.setTableno(rs.getInt("table_number"));
	            	beanobj.setTime(rs.getInt("time_slot"));
	            	lst.add(beanobj);
	            
	            }
	            preparedStatement.close();
	            connection.close();    
		 }
		 catch (SQLException e) {
	           e.printStackTrace();
	        }
		
		return lst;	
	}

}
