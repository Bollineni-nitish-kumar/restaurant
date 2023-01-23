package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Adminviewbean;
import businesslogic.admin.Adminview;

@WebServlet("/AdminviewServlet")
public class AdminviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  private Adminview adminview;
    public AdminviewServlet() {
        super();
    }
    public void init() {
   
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		adminview=new Adminview();
		List<Adminviewbean> list=adminview.getAllDetails();
		request.setAttribute("userdata", list);
		RequestDispatcher reqd=request.getRequestDispatcher("ADMINPAGES/Allbookings.jsp");
		reqd.forward(request, response);
		
	}

}
