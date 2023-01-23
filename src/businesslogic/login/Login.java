//$Id$
package businesslogic.login;
import java.util.List;

import beans.Loginbean;
import daos.logindao.LoginDao;

public class Login {
	private LoginDao logindao;
	public Loginbean beanobj=null;
	public boolean  validateDetails(Loginbean loginbean) {
		boolean status=false;
		logindao=new LoginDao();
		try {
			List<Loginbean> list=logindao.Retrieve(loginbean);
			if(list.size()!=0) {
			beanobj=list.get(0);
			if(beanobj.getUsername()!=null&&beanobj.getPassword()!=null) {
				status=true;
			}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	return status;
	}
	
	public boolean validateAdmindetails(Loginbean loginbean) {
		boolean status=false;
		logindao=new LoginDao();
		List<Loginbean> list=null;
		try {
			list = logindao.RetrieveAdmin(loginbean);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()!=0) {
			beanobj=list.get(0);
			status=true;
			
		}
		return status;
	}

	
}
