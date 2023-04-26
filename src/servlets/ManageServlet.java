package servlets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Addbean;
import beans.Adminviewbean;
import businesslogic.admin.Managetable;
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Managetable manage;
    
    public ManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val=(String)request.getParameter("submit");
		if(val.contentEquals("Add table")) {
			manage=new Managetable();
			List<Addbean> list=manage.getAllTables();
			request.setAttribute("tabledata",list);
			RequestDispatcher rd=request.getRequestDispatcher("ADMINPAGES/Adddetails.jsp");
			rd.forward(request, response);
			//response.sendRedirect("ADMINPAGES/Adddetails.jsp");
		}
		else if(val.contentEquals("Remove table")) {
			manage=new Managetable();
			List<Addbean> list=manage.getAllTables();
			request.setAttribute("tabledata",list);
			RequestDispatcher rd=request.getRequestDispatcher("ADMINPAGES/Removetable.jsp");
			rd.forward(request, response);
			//response.sendRedirect("ADMINPAGES/Removetable.jsp");
		}
		else if(val.contentEquals("modify details")) {
			manage=new Managetable();
			List<Addbean> list=manage.getAllTables();
			request.setAttribute("tabledata",list);
			RequestDispatcher rd=request.getRequestDispatcher("ADMINPAGES/Modifydetails.jsp");
			rd.forward(request, response);
		}
		else if(val.contentEquals("manage")){
			response.sendRedirect("ADMINPAGES/managetable.jsp");
			
		}
		else if(val.contentEquals("cancel")) {
			final String[] selectedtables = request.getParameterValues("MY_JAVA_OBJECT");
			System.out.println(selectedtables.length);
			List<Adminviewbean> list=new ArrayList<>();
			if(selectedtables==null||selectedtables.length==0) {
				System.out.println("null here");
				response.sendRedirect("ADMINPAGES/notavailable.jsp");
			}
			else {
				for(String base64String:selectedtables) {
					final byte[] objToBytes = Base64.getDecoder().decode(base64String);
					ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
					ObjectInputStream ois = new ObjectInputStream(bais);
					try {
						list.add((Adminviewbean)ois.readObject());
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				manage=new Managetable();
				if(manage.cancelBookings(list)) {
					response.sendRedirect("ADMINPAGES/Cancelsuccess.jsp");
				}
				
				
				
			}
		}
	}

}
