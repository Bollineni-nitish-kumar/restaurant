//$Id$
package daos.availabledao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Availablebean;


public class AvailableDao {
	public Availablebean getDetails(Availablebean availbean) throws ClassNotFoundException {
		Availablebean beanobj=null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from table_status t1 join table_details t2 on t1.table_id=t2.table_id \n" + 
            "join timings t3 on t1.time_id=t3.time_id  where t2.table_number=? and t3.time_slot=? and t1.avail_status=true;")) {
            preparedStatement.setInt(1, availbean.getTableno());
            preparedStatement.setInt(2, availbean.getTime());
            ResultSet rs=null;
            rs=preparedStatement.executeQuery();
            while(rs.next()) {
            	beanobj=new Availablebean();
            	beanobj.setCost(rs.getFloat("cost_per_hour"));
            	beanobj.setSeats(rs.getInt("no_seats"));
            	beanobj.setTableno(rs.getInt("table_number"));
            	beanobj.setTime(rs.getInt("time_slot"));
            	beanobj.setSlotid(rs.getInt("slot_id"));
            	beanobj.setTableid(rs.getInt("table_id"));
            	beanobj.setTimeid(rs.getInt("time_id"));
            	beanobj.setAvailstatus(rs.getBoolean("avail_status"));
           }
            
            preparedStatement.close();
            connection.close();
            
            
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return beanobj;
		
	}
	
	public List<Availablebean> retrieve(Availablebean availablebean) throws ClassNotFoundException{
		List<Availablebean> list=new ArrayList<>();
		
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select * from table_status t1 join table_details t2 on t1.table_id=t2.table_id \n" + 
	            "join timings t3 on t1.time_id=t3.time_id  where t2.no_seats=? and t3.time_slot=? and t1.avail_status=true;")) {
	            preparedStatement.setInt(1, availablebean.getSeats());
	            preparedStatement.setInt(2, availablebean.getTime());
	           
	            
	            
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            while(rs.next()) {
	            	Availablebean beanobj=new Availablebean();
	            	beanobj.setCost(rs.getFloat("cost_per_hour"));
	            	beanobj.setSeats(rs.getInt("no_seats"));
	            	beanobj.setTableno(rs.getInt("table_number"));
	            	beanobj.setTime(rs.getInt("time_slot"));
	            	beanobj.setSlotid(rs.getInt("slot_id"));
	            	beanobj.setTableid(rs.getInt("table_id"));
	            	beanobj.setTimeid(rs.getInt("time_id"));
	            	beanobj.setAvailstatus(rs.getBoolean("avail_status"));
	            	list.add(beanobj);
	           }
	            
	            preparedStatement.close();
	            connection.close();
	            
	            
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	            
	            return list;
	}
	public List<Availablebean> retrieveTablesDetails(Availablebean availablebean) throws ClassNotFoundException{
		List<Availablebean> list=new ArrayList<>();
		
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement(" select t2.slot_id,t2.time_id,t2.table_id,t2.avail_status,t1.table_number,t1.no_seats,t1.cost_per_hour,t3.time_slot from table_status t2 join table_details t1 on t1.table_id=t2.table_id join timings t3 "
	            		+ "on t3.time_id=t2.time_id where t3.time_slot=? and t2.avail_status=true;")) {
	            preparedStatement.setInt(1, availablebean.getTime());
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            while(rs.next()) {
	            	Availablebean beanobj=new Availablebean();
	            	beanobj.setCost(rs.getFloat("cost_per_hour"));
	            	beanobj.setSeats(rs.getInt("no_seats"));
	            	beanobj.setTableno(rs.getInt("table_number"));
	            	beanobj.setTime(rs.getInt("time_slot"));
	            	beanobj.setSlotid(rs.getInt("slot_id"));
	            	beanobj.setTableid(rs.getInt("table_id"));
	            	beanobj.setTimeid(rs.getInt("time_id"));
	            	beanobj.setAvailstatus(rs.getBoolean("avail_status"));
	            	list.add(beanobj);
	           }
	            
	            preparedStatement.close();
	            connection.close();   
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	            
	            return list;
	}

}
