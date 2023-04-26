package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Resetbean;
import businesslogic.register.Registration;

@WebServlet("/ResetServlet")
public class ResetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private Registration registration;
    public ResetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String val=request.getParameter("submit");
		if(val.contentEquals("submit")) {
		String gmail=request.getParameter("gmail");
		registration=new Registration();
		String gmailRegex="^[a-z0-9]+(?!.*(?:\\+{2,}|\\-{2,}|\\.{2,}))(?:[\\.+\\-]{0,1}[a-z0-9])*@gmail\\.com$";
		if(registration.regexMatcher(gmail,gmailRegex)) {
            String token=registration.genToken();
            Resetbean resetbean=new Resetbean();
            resetbean.setGmail(gmail);
            resetbean.setToken(token);
            registration.storeToken(resetbean);
            registration.sendEmail(resetbean);
		}
		else {
			request.setAttribute("invalidMail",true);
			RequestDispatcher rd=request.getRequestDispatcher("REGISTERPAGES/Resetpage.jsp");
			rd.forward(request, response);
		}
		}
		else if(val.contentEquals("reset")) {
			String token=request.getParameter("token");
			String gmail=request.getParameter("gmail");
			System.out.println("i am in reset servlet");
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
