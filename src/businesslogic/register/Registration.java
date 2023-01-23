//$Id$
package businesslogic.register;

import java.util.List;

import beans.Registerbean;
import daos.registerdao.RegistrationDao;

public class Registration {
	private RegistrationDao registerdao;
	public int alreadyExisted(Registerbean registerbean) {
		int status=0;
		registerdao=new RegistrationDao();
		try {
			List<Registerbean> list=registerdao.Retrieve(registerbean);
			if(list.size()==0) {
			
				return status;
			}
			Registerbean beanobject=list.get(0);
			if(beanobject.getUsername().contentEquals(registerbean.getUsername())){
				status=1;
				return status;
			}
			else if(beanobject.getGmail().contentEquals(registerbean.getGmail())) {
				status=2;
				return status;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	public boolean registerDetails(Registerbean registerbean) throws ClassNotFoundException {
		boolean status=false;
		registerdao=new RegistrationDao();
		  registerdao.insertDetails(registerbean);
		  if(alreadyExisted(registerbean)!=0) {
			status=true;
		  }
		return status;
	}

}
