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

import beans.Availablebean;
import beans.Bookingbean;
import businesslogic.availability.Availability;
import businesslogic.booking.Booking;


@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Booking book;
       private Availability availability;
   public void init() {
	  
   }
    public BookingServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("submit");
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("Username");
		 book=new Booking();
		 availability=new Availability();
		if(value.contentEquals("book table")) {
			int table_no=Integer.parseInt(request.getParameter("tableno"));
			int time=Integer.parseInt(request.getParameter("timeslot"));
		Bookingbean bookbean=new Bookingbean();
			//bookbean.setSeats(no_of_seats);
		//	bookbean.setTime(time);
			bookbean.setUsername(user);
			System.out.println("inthe servlet");
			Availablebean availbean=new Availablebean();
			availbean.setTableno(table_no);
			availbean.setTime(time);
			Availablebean beanobj=null;
			beanobj=availability.checkTable(availbean);
			if(beanobj==null) {
				response.sendRedirect("AVAILABILITYPAGES/notavailable.jsp");
			}
			else {
				List<Availablebean> list=new ArrayList<>();
				list.add(beanobj);
				if(book.bookingtable(list,bookbean)) {
					
					
					request.setAttribute("bookedtables",list);
					//response.sendRedirect("BOOKINGPAGES/bookingsuccess.jsp");
					RequestDispatcher rd=request.getRequestDispatcher("BOOKINGPAGES/bookingsuccess.jsp");
					rd.forward(request,response);
				}
				
				
			}
			
	/*	if(book.bookIfAvail(bookbean)) {
				
				response.sendRedirect("BOOKINGPAGES/bookingsuccess.jsp");
				
			}
			else {
				response.sendRedirect("AVAILABILITYPAGES/notavailable.jsp");
			}
			*/
			
		}
		else if(value.contentEquals("book")) {
			Bookingbean bookbean=new Bookingbean();
			bookbean.setUsername(user);
			final String[] selectedtables = request.getParameterValues("MY_JAVA_OBJECT");
			List<Availablebean> list=new ArrayList<>();
			if(selectedtables==null) {
				System.out.println("null here");
				response.sendRedirect("AVAILABILITYPAGES/notavailable.jsp");
			}
			else {
			for(String base64String:selectedtables) {
				final byte[] objToBytes = Base64.getDecoder().decode(base64String);
				ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				try {
					list.add((Availablebean)ois.readObject());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(book.bookingtable(list,bookbean)) {
				
				
				request.setAttribute("bookedtables",list);
				//response.sendRedirect("BOOKINGPAGES/bookingsuccess.jsp");
				RequestDispatcher rd=request.getRequestDispatcher("BOOKINGPAGES/bookingsuccess.jsp");
				rd.forward(request,response);
			}
			
			
			
			//final String base64String = request.getparameter("MY_JAVA_OBJECT");
			//final byte[] objToBytes = Base64.getDecoder().decode(base64String);
			//ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
			//ObjectInputStream ois = new ObjectInputStream(bais);
			//return (ObjectClass) ois.readObject();
			//System.out.println(list.size());
			}
		}
		else if(value.contentEquals("logout")) {
			HttpSession son=request.getSession();
			son.invalidate();
			response.sendRedirect("LOGINPAGES/logoutsuccessful.jsp");
		}
		else if(value.contentEquals("back")) {
			response.sendRedirect("AVAILABILITYPAGES/availability.jsp");
		}
		
	}

}
