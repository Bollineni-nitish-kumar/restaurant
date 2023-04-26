//$Id$
package daos.logindao;
import beans.Loginbean;
import beans.Userbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class LoginDao {
	
	public List<Loginbean> RetrieveAdmin(Loginbean loginbean) throws ClassNotFoundException{
		List<Loginbean> list=new ArrayList<>();
		
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select admin_id,admin_username from admin_details where admin_username = ? and admin_password = ? ")) {
	            preparedStatement.setString(1, loginbean.getUsername());
	            preparedStatement.setString(2, loginbean.getPassword());
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            
	            if(rs.next()) {
	            	Loginbean bean=new Loginbean();
	            	loginbean.setUserid(rs.getInt("admin_id"));
	            	loginbean.setUsername(rs.getString("admin_username"));
	 
	            	list.add(bean);	
	            }
	            else {
	            	return list;
	            }
	            preparedStatement.close();
	            connection.close();   
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	       return list;
	}
	public List<Userbean> getDetails(Loginbean loginbean) throws ClassNotFoundException{
		List<Userbean> list=new ArrayList<>();
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        try {
	        	Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select user_id,user_name,first_name,last_name,mobile_no,gmail,user_password from user_details where (user_name = ? or gmail=?) and user_password = ?;"); 
	            preparedStatement.setString(1, loginbean.getUsername());
	            preparedStatement.setString(2, loginbean.getUsername());
	            preparedStatement.setString(3, loginbean.getPassword());
	           
	          ResultSet rs=null;
	         rs=preparedStatement.executeQuery();
	            while(rs.next()) {
	            	System.out.println("i am here");
	            	Userbean ubean=new Userbean();
	            	ubean.setUserid(rs.getInt("user_id"));
	            	ubean.setFirstname(rs.getString("first_name"));
	            	ubean.setLastname(rs.getString("last_name"));
	            	ubean.setMobilno(rs.getString("mobile_no"));
	            	ubean.setGmail(rs.getString("gmail"));
	            	System.out.println(rs.getString("gmail"));
	            	ubean.setUsername(rs.getString("user_name"));
	            	ubean.setPassword(rs.getString("user_password"));
	            	list.add(ubean);
	            }
	            preparedStatement.close();
	            connection.close();    
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	        return list;
	    }
	
	public List<Loginbean> Retrieve(Loginbean loginBean) throws ClassNotFoundException {
       
        List<Loginbean> list=new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
        	Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

            PreparedStatement preparedStatement = connection
            .prepareStatement("select user_id,user_name,user_password from user_details where (user_name = ? or gmail=?);");
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getUsername());
           // preparedStatement.setString(3, loginBean.getPassword());

        		ResultSet rs=null;
        		
           rs=preparedStatement.executeQuery();	
            if(rs.next()) {
            	Loginbean loginbean=new Loginbean();
            	loginbean.setUserid(rs.getInt("user_id"));
            	System.out.println(rs.getString("user_name"));
            	loginbean.setUsername(rs.getString("user_name"));
            	loginbean.setPassword(rs.getString("user_password"));
            	list.add(loginbean);
            	
            } 
            else {
            	return list;
            }
           
           preparedStatement.close();
          
            connection.close();
       
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return list;
    }
	public String retrieveRole(Loginbean loginbean) throws ClassNotFoundException {
		String role=null;
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select role from Users where user_name = ?  ")) {
	            preparedStatement.setString(1, loginbean.getUsername());
	            System.out.println(loginbean.getUsername());
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            
	            if(rs.next()) {
	            	role=rs.getString("role");
	            }
	            
	            preparedStatement.close();
	            connection.close();
	           } catch (SQLException e) {
	           e.printStackTrace();
	        }
	         return role;
		
	}
	public List<String> retrievePermission(String role) throws ClassNotFoundException{
		List<String> list=new ArrayList<>();
		
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select role_permissions from Roles where role_name=? ")) {
	            preparedStatement.setString(1, role);
	           
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            
	            while(rs.next()) {
	            	list.add(rs.getString("role_permissions"));
	            }
	            preparedStatement.close();
	            connection.close();   
	        } catch (SQLException e) {
	           e.printStackTrace();
	        }
	       return list;
	}

}
