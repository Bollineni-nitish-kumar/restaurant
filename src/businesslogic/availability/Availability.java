//$Id$
package businesslogic.availability;

import java.util.List;

import beans.Availablebean;
import daos.availabledao.AvailableDao;

public class Availability {
	private AvailableDao availabledao;

	 public List<Availablebean> checkAvailability(Availablebean availablebean) {
		 availabledao=new AvailableDao();
			List<Availablebean> list=null;
		 try {
			list=availabledao.retrieve(availablebean);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		 return list;
	
	 }
	 public List<Availablebean> getAllTables(Availablebean availbean){
		 availabledao=new AvailableDao();
		 List<Availablebean> list=null;
		 try {
		      list=availabledao.retrieveTablesDetails(availbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	 }
	public Availablebean checkTable(Availablebean availbean) {
		availabledao=new AvailableDao();
		Availablebean beanobj=null;
		try {
			beanobj=availabledao.getDetails(availbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beanobj;
	}
}
