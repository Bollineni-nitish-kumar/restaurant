//$Id$
package daos.managetable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Addbean;
import beans.Adminviewbean;
import beans.Managebean;

public class ManageDao {
	public int  updateCancel(List<Adminviewbean> list) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		int rs=0;
		try{ 
			 Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");
			 
	          PreparedStatement preparedStatement1= connection
	  	            .prepareStatement("delete from orders where slot_id=?");
	  		 for(Adminviewbean bean:list) {
	  		 preparedStatement1.setInt(1,bean.getSlotid());
	            preparedStatement1.executeUpdate();
	            rs++;
	  		 }
	            preparedStatement1.close();
	            
	            PreparedStatement preparedStatement2= connection
	    	            .prepareStatement("update table_status set avail_status=true where slot_id=?");
	    		 for(Adminviewbean bean:list) {
	    		 preparedStatement2.setInt(1, bean.getSlotid());
	              preparedStatement2.executeUpdate();
	    		 }
	              preparedStatement2.close();
	          connection.close(); 
		 }
		 catch (SQLException e) {
	         e.printStackTrace();
	      }
		return rs;
	}
public List<Addbean> retrieveTables() throws ClassNotFoundException{
            List<Addbean> list=new ArrayList<>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");
		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select table_id,table_number,no_seats,cost_per_hour from table_details")){
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				Addbean bean=new Addbean();
				bean.setTableid(rs.getInt("table_id"));
				bean.setTableno(rs.getInt("table_number"));
				bean.setNoseats(rs.getInt("no_seats"));
				bean.setPrice(rs.getFloat("cost_per_hour"));
				list.add(bean);
				
			}  
	           preparedStatement.close();
	           connection.close();  
		 }
		 catch (SQLException e) {
	          e.printStackTrace();
	       }
		return list;	
	}
public int updateTableDetails(List<Addbean> list) throws ClassNotFoundException{
	Class.forName("com.mysql.cj.jdbc.Driver");
	int rs=0;
	try{ 
		 Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");
		 
          PreparedStatement preparedStatement= connection
  	            .prepareStatement("update table_details set table_number=?,no_seats=?,cost_per_hour=? where table_id=?");
  		 for(Addbean bean:list) {
  		 preparedStatement.setInt(1,bean.getTableno());
  		preparedStatement.setInt(2,bean.getNoseats());
  		preparedStatement.setFloat(3,bean.getPrice());
  		preparedStatement.setInt(4,bean.getTableid());
  		 preparedStatement.executeUpdate();
            rs++;
  		 }
  		preparedStatement.close();
          connection.close(); 
	 }
	 catch (SQLException e) {
         e.printStackTrace();
      }
	return rs;
}
	public List<Managebean> getDetails(Addbean addbean) throws ClassNotFoundException{
		List<Managebean> list=new ArrayList<>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

		            
		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select table_id from table_details where table_number=?;")){
			 
			 preparedStatement.setInt(1, addbean.getTableno());
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				Managebean managebean=new Managebean();
				managebean.setTableid(rs.getInt("table_id"));
				list.add(managebean);
				
			}
	           
	           preparedStatement.close();
	           connection.close();  
		 }
		 catch (SQLException e) {
	          e.printStackTrace();
	       }
		return list;
		
	}
	public List<Managebean> retrieveTimeDetails() throws ClassNotFoundException{
		List<Managebean> list=new ArrayList<>();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

		            
		            PreparedStatement preparedStatement = connection
		            .prepareStatement("select time_id from timings;")){
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				Managebean managebean=new Managebean();
				managebean.setTimeid(rs.getInt("time_id"));
				list.add(managebean);
				
			}
	           
	           preparedStatement.close();
	           connection.close();  
		 }
		 catch (SQLException e) {
	          e.printStackTrace();
		 }
		return list;
		
	}
public int updateDetails(Addbean addbean) throws ClassNotFoundException {
	int rs=0;
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	 try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");
            PreparedStatement preparedStatement = connection
	            .prepareStatement("insert into table_details(table_number,no_seats,cost_per_hour) values(?,?,?);")){
		 
		 preparedStatement.setInt(1, addbean.getTableno());
		 preparedStatement.setInt(2, addbean.getNoseats());
		 preparedStatement.setFloat(3, addbean.getPrice());
           rs=preparedStatement.executeUpdate();
           
           preparedStatement.close();
           connection.close();  
	 }
	 catch (SQLException e) {
          e.printStackTrace();
	 }
	return rs;
	
}
public int updateTable(List<Addbean> list) throws ClassNotFoundException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	int val=0;
	try{ 
		 Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");
		 
	       for(Addbean bean:list) {    
          PreparedStatement preparedStatement2= connection
  	            .prepareStatement("delete from table_status where table_id=?");
  		 preparedStatement2.setInt(1, bean.getTableid());
            preparedStatement2.executeUpdate();
            preparedStatement2.close();
	       
            PreparedStatement preparedStatement1= connection
    	            .prepareStatement("delete from table_details where table_id=?");
    		 
    		 preparedStatement1.setInt(1, bean.getTableid());
              preparedStatement1.executeUpdate();
              val++;
              preparedStatement1.close();
	       }
          connection.close(); 
	 }
	 catch (SQLException e) {
         e.printStackTrace();
      }
	return val;
	
}


public void updateStatus(Managebean managebean, List<Integer> list) throws ClassNotFoundException
{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	 try{ 
		 Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            for(Integer num:list)
	            {
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("insert into table_status(table_id,time_id,avail_status) values(?,?,?);");
		 
		 preparedStatement.setInt(1, managebean.getTableid());
		 preparedStatement.setInt(2, num);
		 preparedStatement.setBoolean(3, true);
           preparedStatement.executeUpdate();
           preparedStatement.close();
	            }
           connection.close();        
	 }
	 catch (SQLException e) {
          e.printStackTrace();
       }	
}
}
