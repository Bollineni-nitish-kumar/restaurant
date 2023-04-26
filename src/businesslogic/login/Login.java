//$Id$
package businesslogic.login;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import beans.Loginbean;
import beans.Userbean;
import daos.logindao.LoginDao;

public class Login {
	private LoginDao logindao;
	public Loginbean beanobj=null;
	public boolean passwordValidates( String pass ) {
		if(pass==null) {
			return false;
		}
		   if( 8 <= pass.length() && pass.length() <= 32  )
		   {
			   String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,32}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(pass);
 
        return m.matches();
		   }
		   return false;
		}
	public boolean[] validateDetails(String username,String password) {
		boolean[] valid=new boolean[2];
		valid[1]=passwordValidates(password);
		if (username.length()>=6&&username.length()<=20&&username.matches("[a-zA-Z0-9]+")) {
		   valid[0]=true;
		}
		return valid;
	}
	public boolean  validateUserDetails(Loginbean loginbean) {
		boolean status=false;
		logindao=new LoginDao();
		try {
			List<Loginbean> list=logindao.Retrieve(loginbean);
			if(list!=null&&list.size()!=0) {
			beanobj=list.get(0);
			String normalPassword=loginbean.getPassword();
			String hashedPassword=beanobj.getPassword();
			if(BCrypt.checkpw(normalPassword, hashedPassword)) {
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
	public List<Userbean> getUserDetails(Loginbean loginbean){
		logindao=new LoginDao();
		List<Userbean> userlist=null;
		try {
			userlist = logindao.getDetails(loginbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}
	public String getRole(Loginbean loginbean) {
		logindao=new LoginDao();
		String role=null;
		try {
			role=logindao.retrieveRole(loginbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}
	public boolean checkRolePermission(String role,String permission) {
	      boolean check_flag=false;
		logindao=new LoginDao();
		//role_permission=logindao.retrieveRolePermission()
		List<String> list=null;
		try {
			 list=logindao.retrievePermission(role);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String str:list) {
			if(str.contentEquals(permission)) {
				check_flag=true;
				return check_flag;
			}
		}
		return check_flag;
	}

	
}
