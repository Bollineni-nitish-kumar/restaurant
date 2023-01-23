//$Id$
package daos.bookingdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import beans.Cancelbean;
import beans.Viewbean;

public class Canceldao {
	

	public int updateCancel(Cancelbean cancelbean,List<Viewbean> list) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        int rs=0;
	        Connection connection=null;
				connection = DriverManager
				    .getConnection("jdbc:mysql://localhost:3306/Restaurant", "root", "Nitish@2510");
		

	            // Step 2:Create a statement using connection object
				for(Viewbean viewbean:list) {
	            PreparedStatement preparedStatement1=null;
					preparedStatement1 = connection
					.prepareStatement("update table_status set avail_status=true where slot_id=? ");
				
					preparedStatement1.setInt(1, viewbean.getSlotid());
                   preparedStatement1.executeUpdate();
                   preparedStatement1.close();
	           
	           PreparedStatement preparedStatement2 = connection
	   	            .prepareStatement("delete from orders where slot_id=? ");
	   	        preparedStatement2.setInt(1, viewbean.getSlotid());
	   	        preparedStatement2.executeUpdate();
	          //  preparedStatement1.close();
	            preparedStatement2.close();
	            rs++;
				}
	            connection.close();
	            
	            
	            return rs;
	}
}
