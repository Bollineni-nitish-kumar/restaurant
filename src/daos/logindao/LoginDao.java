//$Id$
package daos.logindao;
import beans.Loginbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
	
	public List<Loginbean> RetrieveAdmin(Loginbean loginbean) throws ClassNotFoundException{
		List<Loginbean> list=new ArrayList<>();
		 Class.forName("com.mysql.cj.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("select admin_id,admin_name,admin_password from admin_details where admin_name = ? and admin_password = ? ")) {
	            preparedStatement.setString(1, loginbean.getUsername());
	            preparedStatement.setString(2, loginbean.getPassword());

	            
	            ResultSet rs=null;
	            rs=preparedStatement.executeQuery();
	            
	            if(rs.next()) {
	            	Loginbean bean=new Loginbean();
	            	loginbean.setUserid(rs.getInt("admin_id"));
	            	loginbean.setUsername(rs.getString("admin_name"));
	            	loginbean.setPassword(rs.getString("admin_password"));
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
	public List<Loginbean> Retrieve(Loginbean loginBean) throws ClassNotFoundException {
       
        List<Loginbean> list=new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select user_id,user_name,user_password from user_details where (user_name = ? or gmail=?) and user_password = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getUsername());
            preparedStatement.setString(3, loginBean.getPassword());

            
            ResultSet rs=null;
            rs=preparedStatement.executeQuery();
            
            if(rs.next()) {
            	Loginbean loginbean=new Loginbean();
            	loginbean.setUserid(rs.getInt("user_id"));
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

}
