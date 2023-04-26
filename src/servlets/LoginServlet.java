package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.owasp.encoder.Encode;
import beans.Loginbean;
import businesslogic.login.Login;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Loginbean loginbean;   
   
    public LoginServlet() {
        super();
        
    }
    private Login login;
    public void init() {
    	
    	
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		login=new Login();
		String user_button=request.getParameter("user_button");
		System.out.println(user_button);
		if(user_button.contentEquals("Register")) {
			response.sendRedirect("REGISTERPAGES/registration.jsp");
		}
		else if(user_button.contentEquals("click")) {
			response.sendRedirect("REGISTERPAGES/Resetpage.jsp");
		}
		else {
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean[] valid=login.validateDetails(username,password);
		if(valid[0]&&valid[1]) {
		String role=null;
		Loginbean loginbean=new Loginbean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);
	
	   if(user_button.equals("user signin")) {
		try {
			if(login.validateUserDetails(loginbean)) {
				role=login.getRole(loginbean);
				System.out.println(role);
				if(role!=null&&role.contentEquals("user")) {
				HttpSession session=request.getSession();
				String uname=request.getParameter("username");
				String sanitizedUsername=Encode.forHtml(uname);
				session.setAttribute("Username",sanitizedUsername);
				session.setAttribute("userid",login.beanobj.getUserid());
				session.setAttribute("role",role);
				int user_id=(int)session.getAttribute("userid");
				System.out.println(session.getAttribute("userid"));
				response.sendRedirect("LOGINPAGES/homepage.jsp");
				}
			}
			else {
				request.setAttribute("details", 0);
				RequestDispatcher rd=request.getRequestDispatcher("LOGINPAGES/index.jsp");
				rd.forward(request,response);
				//response.sendRedirect("LOGINPAGES/index.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if(user_button.equals("admin signin")) {
			 System.out.println(loginbean.getUsername());
	            System.out.println(loginbean.getPassword());
			if(login.validateAdmindetails(loginbean)) {
				role=login.getRole(loginbean);
				System.out.println("i am"+role);
				if(role!=null&&role.contentEquals("admin")) {
				HttpSession session=request.getSession();
				String uname=request.getParameter("username");
				String sanitizedUsername=Encode.forHtml(uname);
				
				session.setAttribute("Username",sanitizedUsername);
				session.setAttribute("userid",login.beanobj.getUserid());
				session.setAttribute("role",role);
				response.sendRedirect("LOGINPAGES/Adminhomepage.jsp");
				}
				
			}
			else {
				request.setAttribute("details", 0);
				RequestDispatcher rd=request.getRequestDispatcher("LOGINPAGES/index.jsp");
				rd.forward(request,response);
			//	response.sendRedirect("LOGINPAGES/index.jsp");
			}
		
     }
		}
		else {
			if(!valid[0]) {
				request.setAttribute("invalidUsername",true);
			}
			if(!valid[1]) {
				request.setAttribute("invalidPassword",true);
			}
			RequestDispatcher rd=request.getRequestDispatcher("LOGINPAGES/index.jsp");
			rd.forward(request, response);
		}
		
		
		
		}
	}

}
