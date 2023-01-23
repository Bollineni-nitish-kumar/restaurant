//$Id$
package daos.adminview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Adminviewbean;


public class Adminviewdao {
	public List<Adminviewbean> retrieveAll() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		  List<Adminviewbean> list=new ArrayList<>();
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

		            
		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select t1.slot_id,t3.table_number,t3.no_seats,t3.cost_per_hour,t4.time_slot,t5.user_name from orders t1 join table_status t2 on t1.slot_id=t2.slot_id join table_details t3 on t2.table_id=t3.table_id join timings t4 on t4.time_id=t2.time_id join user_details t5 on t5.user_id=t1.user_id; ")){
	         
			    ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            while(rs.next()) {
					Adminviewbean adminviewbean=new Adminviewbean();
					adminviewbean.setTableno(rs.getInt("table_number"));
					adminviewbean.setSeats(rs.getInt("no_seats"));
					adminviewbean.setTimeslot(rs.getInt("time_slot"));
					adminviewbean.setCost(rs.getFloat("cost_per_hour"));
					adminviewbean.setUsername(rs.getString("user_name"));
					adminviewbean.setSlotid(rs.getInt("slot_id"));
					list.add(adminviewbean);
	            }
	            preparedStatement.close();
	            connection.close();  
		 }
		 catch (SQLException e) {
	           e.printStackTrace();
	        }
		 return list;
		
		
	}

}
