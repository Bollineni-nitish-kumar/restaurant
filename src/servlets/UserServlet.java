package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Loginbean;
import businesslogic.login.Login;
import beans.Userbean;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    private Login login;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		System.out.println(username);
		System.out.println(pwd);
		Loginbean loginbean=new Loginbean();
		loginbean.setUsername(username);
		loginbean.setPassword(pwd);
		login=new Login();
		if(login.validateUserDetails(loginbean)) {
			List<Userbean> ulist=login.getUserDetails(loginbean);
			System.out.println(ulist.size());
			request.setAttribute("userdetails", ulist);
			RequestDispatcher rd=request.getRequestDispatcher("LOGINPAGES/Viewmydetails.jsp");
			rd.forward(request,response);
		}
		else {
			
		}
		
	}

}
