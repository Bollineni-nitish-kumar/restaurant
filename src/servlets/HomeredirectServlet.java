package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/HomeredirectServlet")
public class HomeredirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HomeredirectServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val=(String)request.getParameter("submit");
		if(val.contentEquals("home")) {
			response.sendRedirect("LOGINPAGES/homepage.jsp");
		}
		else if(val.contentEquals("logout")) {
			HttpSession son=request.getSession();
			son.invalidate();
			response.sendRedirect("LOGINPAGES/logoutsuccessful.jsp");
		}
		else if(val.contentEquals("go to home")) {
			response.sendRedirect("LOGINPAGES/homepage.jsp");
		}
		
		
	}

}
