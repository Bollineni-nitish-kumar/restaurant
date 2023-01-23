package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminredirectServlet")
public class AdminredirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AdminredirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val=(String)request.getParameter("submit");
		if(val.contentEquals("Go to home")) {
			response.sendRedirect("LOGINPAGES/Adminhomepage.jsp");
		}
		if(val.contentEquals("home page")) {
			response.sendRedirect("LOGINPAGES/Adminhomepage.jsp");
		}
		if(val.contentEquals("home")) {
			response.sendRedirect("LOGINPAGES/Adminhomepage.jsp");
		}
		else if(val.contentEquals("back")) {
			response.sendRedirect("LOGINPAGES/Adminhomepage.jsp");
			
		}
		else if(val.contentEquals("logout")) {
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("LOGINPAGES/logoutsuccessful.jsp");
		}
	}

}
