//$Id$
package beans;

public class Registerbean {
	private String first_name;
	private String last_name;
	private String mobile_no;
	private String gmail;
	private String user_name;
	private String user_password;
	private String gender;
	

	public void setFirstname(String first_name) {
	    this.first_name = first_name;
	}
	public String getFirstname() {
	    return first_name;
	}

	

	public void setLastname(String last_name) {
	    this.last_name=last_name;
	}
	public String getLastname() {
	    return last_name;
	}
	

	public void setMobile(String mobile_no) {
	    this.mobile_no = mobile_no;
	}

	public String getMobile() {
	    return mobile_no;
	}
	

	
	public void setGmail(String gmail) {
	    this.gmail = gmail;
	}
	public String getGmail() {
	    return gmail;
	}
    

	public void setUsername(String user_name) {
	    this.user_name = user_name;
	}
	public String getUsername() {
	    return user_name;
	}
	
	
	
	public void setUserpassword(String user_password) {
	    this.user_password= user_password;
	}
	public String getUserpassword() {
	    return user_password;
	}
	
	public void setGender(String gender) {
	    this.gender= gender;
	}
	public String getGender() {
	    return gender;
	}


}
