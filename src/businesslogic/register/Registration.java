//$Id$
package businesslogic.register;

import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import beans.Registerbean;
import beans.Resetbean;
import businesslogic.login.Login;
import daos.registerdao.RegistrationDao;

public class Registration {
	private RegistrationDao registerdao;
	private Login login;
	public boolean regexMatcher(String input,String regex) {
		//String regex="^[A-Za-z]+[A-Za-z ]*$";
		Pattern p=Pattern.compile(regex);
		Matcher m=p.matcher(input);
		return m.matches();
	}
	
	public boolean[] validDetails(Registerbean registerbean) {
		boolean[] valid=new boolean[7];
		login=new Login();
		String fname=registerbean.getFirstname();
		String nameRegex="^[A-Za-z]+[A-Za-z ]*$";
		valid[0]=regexMatcher(fname,nameRegex);
		String lname=registerbean.getLastname();
		valid[1]=regexMatcher(lname,nameRegex);
		String mobile=registerbean.getMobile();
		String mnRegex="^[6-9][0-9]{9}$";
		valid[2]=regexMatcher(mobile,mnRegex);
		String gmail=registerbean.getGmail();
        String gmailRegex="^[a-z0-9]+(?!.*(?:\\+{2,}|\\-{2,}|\\.{2,}))(?:[\\.+\\-]{0,1}[a-z0-9])*@gmail\\.com$";
		valid[3]=regexMatcher(gmail,gmailRegex);
		String gender=registerbean.getGender();
		String genderRegex="(?:Male|Female|other)$";
		valid[4]=regexMatcher(gender,genderRegex);
        String username=registerbean.getUsername();
        String password=registerbean.getUserpassword();
        boolean[] uvalid=login.validateDetails(username, password);
        valid[5]=uvalid[0];
        valid[6]=uvalid[1];
        return valid;	
	}
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
	 private  String generateSalt(int length) {
	        String salt=BCrypt.gensalt();
	        return  salt;
	    }
	public String hashPassword(String password) {
		//int workload = 12; // Increase this if you want to make the hashing more secure
        String salt = generateSalt(16);
        String hashedPassword = BCrypt.hashpw(password, salt);
        return hashedPassword;
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
	public String genToken() {
		return UUID.randomUUID().toString();
	}
	public void storeToken(Resetbean resetbean) {
		registerdao=new RegistrationDao();
		try {
			registerdao.updateToken(resetbean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sendEmail(Resetbean resetbean) {
		String resetLink = "http://localhost:8080/Restauranttable/ResetServlet?gmail="+resetbean.getGmail()+"&token="+resetbean.getToken()+"&submit=reset";
		String message = "To reset your password, click on this link: " + resetLink;
		Emailsender sender=new Emailsender();
		sender.sendEmail("bollineninitish1@gmail.com","Niti@2019",resetbean.getGmail(), "Password Reset", message);
	}

}
