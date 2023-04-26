package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Addbean;
import beans.Availablebean;
import beans.Bookingbean;
import businesslogic.admin.Managetable;
import businesslogic.availability.Availability;
import businesslogic.booking.Recommend;

@WebServlet("/ClassifyServlet")
public class ClassifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Recommend recommend;
	private Managetable manage;
    public ClassifyServlet() {
        super();
        
    }
    public void init() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("submit");
		//int user=Integer.parseInt(request.getParameter("user"));
		//System.out.println(user);
		
		if(value.contentEquals("logout")) {
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("LOGINPAGES/logoutsuccessful.jsp");
		}
		else if(value.contentEquals("view my details")) {
			response.sendRedirect("LOGINPAGES/Viewmydetails.jsp");
		}
		else if(value.contentEquals("book table")) {
			HttpSession session=request.getSession();
			int userid=(int)session.getAttribute("userid");
			Bookingbean bookbean=new Bookingbean();
			bookbean.setUserid(userid);
			recommend=new Recommend();
			List<Availablebean> list=recommend.getRecommendations(bookbean);
				System.out.println(list.size());
				Availability availability=new Availability();
				Availablebean availbean=null;
				if(list!=null&&list.size()!=0) {
				  availbean=availability.checkTable(list.get(0));
				}
				else {
					request.setAttribute("freshUser",1);
				}
				if(availbean==null) {
					availbean=new Availablebean();
					availbean.setTableno(-1);
					availbean.setTime(-1);
				}
				
				session.setAttribute("recomdata",availbean);
				//RequestDispatcher rd=request.getRequestDispatcher("BOOKINGPAGES/booking.jsp");
				//rd.forward(request, response);
				response.sendRedirect("BOOKINGPAGES/booking.jsp");
			
			}
		
		else if(value.contentEquals("view availability")) {
			response.sendRedirect("AVAILABILITYPAGES/availability.jsp");
		}
		else if(value.contentEquals("view booking")) {
			RequestDispatcher reqd = request.getRequestDispatcher("ViewServlet");
			// Forward the Request Dispatcher object.
			reqd.forward(request, response);
			//response.sendRedirect("ViewServlet");
		}
		else if(value.contentEquals("manage tables")) {
			manage=new Managetable();
			List<Addbean> list=manage.getAllTables();
			request.setAttribute("tabledata",list);
			RequestDispatcher reqd=request.getRequestDispatcher("ADMINPAGES/Viewtables.jsp");
			reqd.forward(request, response);
			//response.sendRedirect("ADMINPAGES/Viewtables.jsp");
		}
		else if(value.contentEquals("view all bookings")) {
			RequestDispatcher reqd=request.getRequestDispatcher("AdminviewServlet");
			reqd.forward(request, response);
		}
		
		
	}

}
