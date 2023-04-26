package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Bookingbean;
import beans.Viewbean;
import businesslogic.booking.Booking;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Booking book;
       public void init() {
		
       }
 public ViewServlet() {
        super();
 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session=request.getSession();
	 PrintWriter out=response.getWriter();
	 out.println("hii"+session.getAttribute("userid"));
	 Bookingbean bookbean=new Bookingbean();
	 bookbean.setUserid((int)session.getAttribute("userid"));
	 book=new Booking();
	 List<Viewbean> list=book.getBookdetails(bookbean);
	 if(list.size()==0) {
		 response.sendRedirect("BOOKINGPAGES/nobooking.jsp");
	 }
	 else {
		 session.setAttribute("userdata", list);
		 System.out.println(list.size());
		 RequestDispatcher rd = request.getRequestDispatcher("BOOKINGPAGES/viewbooking.jsp");
		 rd.forward(request, response);
	 }
	 
	 
	}

}
