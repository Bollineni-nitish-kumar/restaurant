//$Id$
package daos.registerdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Registerbean;
import beans.Resetbean;

public class RegistrationDao {
	public void insertDetails(Registerbean registerbean) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection
	            .prepareStatement("insert into user_details(user_name,first_name,last_name,mobile_no,gmail,user_password,gender) values(?,?,?,?,?,?,? )") ){
			 preparedStatement.setString(1, registerbean.getUsername());
	            preparedStatement.setString(2, registerbean.getFirstname());
	            preparedStatement.setString(3, registerbean.getLastname());
	            preparedStatement.setString(4, registerbean.getMobile());
	            preparedStatement.setString(5, registerbean.getGmail());
	            preparedStatement.setString(6, registerbean.getUserpassword());
	            //preparedStatement.setString(7, registerbean.getGender());
	           String gender=registerbean.getGender();
	           char ch='O';
	           if(gender.contentEquals("Male")) {
	        	   ch='M';
	           }
	           else if(gender.contentEquals("Female")) {
	        	   ch='F';
	           }
	           else {
	        	   ch='O';
	           }
	           preparedStatement.setString(7,ch+"");
	           
	            preparedStatement.executeUpdate();
	            preparedStatement.close();
	            connection.close();
	            } catch (SQLException e) {
	           e.printStackTrace();
	        }

		
	}
	public void updateToken(Resetbean resetbean) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("insert into Tokens(token,gmail) values(?,?);")) {
            preparedStatement.setString(1, resetbean.getToken());
            preparedStatement.setString(2, resetbean.getGmail());
          
            int rs=preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();  
        } catch (SQLException e) {
           e.printStackTrace();
        }

		
	}
	public List<Registerbean> Retrieve(Registerbean registerbean) throws ClassNotFoundException {
	       
        List<Registerbean> list=new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select user_name,gmail from user_details where user_name = ? or gmail=?  ")) {
            preparedStatement.setString(1, registerbean.getUsername());
            preparedStatement.setString(2, registerbean.getGmail());
            ResultSet rs=null;
            rs=preparedStatement.executeQuery();
            
            if(rs.next()) {
            	Registerbean bean=new Registerbean();
            	
            	bean.setUsername(rs.getString("user_name"));
            	bean.setGmail(rs.getString("gmail"));
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

}
