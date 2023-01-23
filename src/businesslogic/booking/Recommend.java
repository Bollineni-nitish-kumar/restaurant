//$Id$
package businesslogic.booking;

import java.util.ArrayList;
import java.util.List;

import beans.Availablebean;
import beans.Bookingbean;
import daos.bookingdao.RecommendDao;

public class Recommend {
	private RecommendDao recomdao;
       public List<Availablebean> getRecommendations(Bookingbean bookbean){
    	   recomdao=new RecommendDao();
    	   List<Availablebean> list=null;
    	   try {
			list=recomdao.retrieve(bookbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   return list;
    	   
    	   
       }
}
