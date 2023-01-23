package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Addbean;
import businesslogic.admin.Managetable;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Managetable managetable;
	public void init() {
		
	}
	
    
    public AddServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str=(String)request.getParameter("submit");
		System.out.println(str);
		if(str!=null&&str.contentEquals("back")) {
			System.out.println("here in add servlet");
			response.sendRedirect("ADMINPAGES/managetable.jsp");
		}
		else {
		int table_no=Integer.parseInt(request.getParameter("table_number"));
		int no_seats=Integer.parseInt(request.getParameter("no_seats"));
		float price=Float.parseFloat(request.getParameter("cost_per_hour"));
		Addbean addbean=new Addbean();
		addbean.setTableno(table_no);
		addbean.setNoseats(no_seats);
		addbean.setPrice(price);
		managetable =new Managetable();
		if(managetable.addTable(addbean)) {
			response.sendRedirect("ADMINPAGES/AddingSuccess.jsp");
		}
		}
		
	}

}
