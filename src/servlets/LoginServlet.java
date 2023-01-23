package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		Loginbean loginbean=new Loginbean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);
		String user_button=request.getParameter("user_button");
		login=new Login();
		System.out.println(user_button);
	   if(user_button.equals("user signin")) {
		try {
			if(login.validateDetails(loginbean)) {
				HttpSession session=request.getSession();
				session.setAttribute("Username", request.getParameter("username"));
				session.setAttribute("userid",login.beanobj.getUserid());
				System.out.println(session.getAttribute("userid"));
				response.sendRedirect("LOGINPAGES/homepage.jsp");
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
			if(login.validateAdmindetails(loginbean)) {
				HttpSession session=request.getSession();
				session.setAttribute("Username", request.getParameter("username"));
				session.setAttribute("userid",login.beanobj.getUserid());
				response.sendRedirect("LOGINPAGES/Adminhomepage.jsp");
				
			}
			else {
				request.setAttribute("details", 0);
				RequestDispatcher rd=request.getRequestDispatcher("LOGINPAGES/index.jsp");
				rd.forward(request,response);
			//	response.sendRedirect("LOGINPAGES/index.jsp");
			}
		
      }
		else {
			response.sendRedirect("REGISTERPAGES/registration.jsp");
		}
		
		
		
	}

}
