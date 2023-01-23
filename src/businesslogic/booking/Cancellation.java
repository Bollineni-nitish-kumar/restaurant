//$Id$
package businesslogic.booking;
import java.sql.SQLException;
import java.util.List;
import beans.Cancelbean;
import beans.Viewbean;
import daos.bookingdao.Canceldao;

public class Cancellation {
	private Canceldao canceldao;
	public boolean cancelBooking(Cancelbean cancelbean,List<Viewbean>list) {
		boolean status=false;
		canceldao=new Canceldao();
		int num=0;
		try {
			num=canceldao.updateCancel(cancelbean,list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num!=0) {
			status=true;
		}
		return status;
		
	}

}
