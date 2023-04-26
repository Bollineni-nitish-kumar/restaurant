//$Id$
package beans;


public class Loginbean {
private String username;
private String password;
private int userid;
private String role;
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role=role;
}
public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
public void setUserid(int userid) {
	this.userid=userid;
	
}
public int getUserid() {
	return userid;
}

}
