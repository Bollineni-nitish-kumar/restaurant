package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Availablebean;
import beans.Loginbean;
import businesslogic.availability.Availability;
import businesslogic.login.Login;


@WebServlet("/AvailabilityServlet")
public class AvailabilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Availability availability;
	private Login login;
	public void init() {
		
		
	}
   
    public AvailabilityServlet() {
        super();    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session=request.getSession();
		  
		if((String)session.getAttribute("Username")==null) {
			   session.invalidate();
			   request.setAttribute("details",1);
			   RequestDispatcher rd=request.getRequestDispatcher("LOGINPAGES/index.jsp");
			   rd.forward(request, response);
		 }
		else {
			String user_name=(String)session.getAttribute("Username");
			Loginbean loginbean=new Loginbean();
			loginbean.setUsername(user_name);
			login=new Login();
			String role=login.getRole(loginbean);
			if(role.contentEquals("user")) {
			boolean has_permission=login.checkRolePermission(role,"view");
			if(has_permission) {
		   String subval=request.getParameter("submit");
		 if(subval!=null&&subval.contentEquals("get tables")) {
			int num_time=Integer.parseInt(request.getParameter("time"));
			Availablebean availbean=new Availablebean();
			availbean.setTime(num_time);
			List<Availablebean> list=null;
			System.out.println("i am in get tables availability servlet");
		    list=availability.getAllTables(availbean);
		    
		    request.setAttribute("alldetails",list);
		    System.out.println(list.size());
		    RequestDispatcher rd=request.getRequestDispatcher("/BOOKINGPAGES/booking.jsp");
		    rd.forward(request, response);
		 
		 }
			}
			else {
				response.sendRedirect("BOOKINGPAGES/booking.jsp");
			}
		 }
		 else{
				response.sendRedirect("BOOKINGPAGES/booking.jsp");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val=(String)request.getParameter("submit");
		String value=(String)request.getParameter("submitna");
		System.out.println(value);
		System.out.println(val);
		availability=new Availability();
		if(val!=null&&val.contentEquals("check")) {
		int num_of_seats=Integer.parseInt(request.getParameter("seats"));
		int num_time=Integer.parseInt(request.getParameter("time"));
		Availablebean availablebean=new Availablebean();
		availablebean.setSeats(num_of_seats);
		availablebean.setTime(num_time);
		//HttpSession session=request.getSession();
		//session.setAttribute("availbookseats", num_of_seats);
		//session.setAttribute("availbooktime", num_time);
		
		List<Availablebean> lst=availability.checkAvailability(availablebean);
		if(lst.size()==0) {
			response.sendRedirect("AVAILABILITYPAGES/notavailable.jsp");
		}else {
			request.setAttribute("tabledata", lst);
			System.out.println("Iam here");
			 RequestDispatcher rd = request.getRequestDispatcher("AVAILABILITYPAGES/available.jsp");
			 rd.forward(request, response);
			//request.getSession().setAttribute("tables",lst);
			
			//response.sendRedirect("AVAILABILITYPAGES/available.jsp");
		}
		}
		else if(val!=null&&val.contentEquals("check table")) {
			int table_no=Integer.parseInt(request.getParameter("table_no"));
			int num_time=Integer.parseInt(request.getParameter("time"));
			Availablebean availablebean=new Availablebean();
			availablebean.setTableno(table_no);
			availablebean.setTime(num_time);
			Availablebean beanobj=null;
			beanobj=availability.checkTable(availablebean);
			if(beanobj==null) {
				response.sendRedirect("AVAILABILITYPAGES/notavailable.jsp");
			}
			else {
				List<Availablebean> list=new ArrayList<>();
				list.add(beanobj);
				request.setAttribute("tabledata", list);
				System.out.println("Iam here");
				 RequestDispatcher rd = request.getRequestDispatcher("AVAILABILITYPAGES/available.jsp");
				 rd.forward(request, response);
			}
			
		}
		
		else if(value!=null && value.contentEquals("back")) {
			System.out.println("came");
			response.sendRedirect("AVAILABILITYPAGES/availability.jsp");
		}
		else if(value!=null&&value.contentEquals("home")) {
			response.sendRedirect("LOGINPAGES/homepage.jsp");
		}
		else if(value!=null&&value.contentEquals("logout")) {
			System.out.println("came");
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("LOGINPAGES/logoutsuccessful.jsp");
		}
		else if((val!=null)&&(val.contentEquals("back")||val.contentEquals("home"))){
			response.sendRedirect("LOGINPAGES/homepage.jsp");
		}
		else if(val!=null&&val.contentEquals("logout")) {
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("LOGINPAGES/logoutsuccessful.jsp");
		}
		
	}

}
