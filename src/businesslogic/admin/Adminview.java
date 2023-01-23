//$Id$
package businesslogic.admin;

import java.util.ArrayList;
import java.util.List;

import beans.Adminviewbean;
import daos.adminview.Adminviewdao;

public class Adminview {
	private Adminviewdao adminviewdao;
	public List<Adminviewbean> getAllDetails(){
		List<Adminviewbean> list=new ArrayList<>();
		adminviewdao=new Adminviewdao();
		try {
			list=adminviewdao.retrieveAll();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		return list;
		
	}

}
