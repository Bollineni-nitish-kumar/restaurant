package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Registerbean;
import businesslogic.register.Registration;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Registration registration;
    public RegisterServlet() {
        super();
        
    }
    public void init() {
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String  mobile_no=request.getParameter("mobile_no");
		String gmail=request.getParameter("gmail");
		String gender=request.getParameter("gender");
		String  user_name=request.getParameter("user_name");
		String  password=request.getParameter("password");
		registration=new Registration();
		String hashedPassword=registration.hashPassword(password);
		System.out.println(hashedPassword);
		Registerbean registerbean=new Registerbean();
		registerbean.setFirstname(first_name);
		registerbean.setLastname(last_name);
		registerbean.setMobile(mobile_no);
		registerbean.setGmail(gmail);
		registerbean.setGender(gender);
		registerbean.setUsername(user_name);
		registerbean.setUserpassword(password);
		registration=new Registration();
		boolean[] valid=registration.validDetails(registerbean);
		boolean cstatus=true;
		for(boolean k:valid) {
			if(!k) {
				cstatus=false;
			}
		}
		if(cstatus) {
			registerbean.setUserpassword(hashedPassword);
		int status=registration.alreadyExisted(registerbean);
		if(status!=0) {
			System.out.println("in the servlet");
			request.setAttribute("status", status);
			RequestDispatcher rd=request.getRequestDispatcher("REGISTERPAGES/registration.jsp");
			rd.forward(request,response);
			//response.sendRedirect("LOGINPAGES/index.jsp");
		}
		else {
			try {
				if(registration.registerDetails(registerbean)) {
					response.sendRedirect("REGISTERPAGES/registrationsuccessful.jsp");
				}
				else {
					response.sendRedirect("REGISTERPAGES/registration.jsp");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		else {
			
		}
		
		
	}

}
