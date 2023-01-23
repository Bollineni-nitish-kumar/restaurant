package servlets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Cancelbean;
import beans.Viewbean;
import businesslogic.booking.Cancellation;
@WebServlet("/CancelServlet")
public class CancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Cancellation cancel;
    public void init() {	
    }
    public CancelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val=request.getParameter("submit");
		cancel=new Cancellation();
		if(val.contentEquals("cancel")) {
			HttpSession session=request.getSession();
			Cancelbean cancelbean=new Cancelbean();
			int userid=(int)session.getAttribute("userid");
			cancelbean.setUserid(userid);
			final String[] selectedtables = request.getParameterValues("MY_JAVA_OBJECT");
			List<Viewbean> list=new ArrayList<>();
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
							list.add((Viewbean)ois.readObject());
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					System.out.println(list.size());
					if(cancel.cancelBooking(cancelbean,list)) {
						response.sendRedirect("BOOKINGPAGES/CancelSuccess.jsp");
					}
			}
		}
	  // if(cancel.cancelBooking(cancelbean)) {
		//   response.sendRedirect("BOOKINGPAGES/CancelSuccess.jsp");
	   //}
		
	}

}
