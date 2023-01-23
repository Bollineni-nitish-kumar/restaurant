package servlets;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Addbean;
import beans.Viewbean;
import businesslogic.admin.Managetable;


@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Managetable managetable;
	public void init() {
	}
       
    public RemoveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	int num=Integer.parseInt(request.getParameter("table_number"));
		Removebean removebean=new Removebean();
		removebean.setTableno(num);
		managetable=new Managetable();
		if(managetable.removeTable(removebean)) {
			response.sendRedirect("ADMINPAGES/RemoveSuccess.jsp");
		}
		else {
			response.sendRedirect("ADMINPAGES/Removefail.jsp");
		}
		
	*/	
		String str=(String)request.getParameter("submit");
		if(str!=null&&str.contentEquals("back")) {
			response.sendRedirect("ADMINPAGES/managetable.jsp");
		}
		else if(str!=null&&str.contentEquals("save changes")) {
			final String[] selectedtables = request.getParameterValues("MY_JAVA_OBJECT");
			//List<Addbean> allList=new ArrayList<>();
			HashMap<Integer,Addbean> hm=new HashMap<>();
			if(selectedtables==null) {
				System.out.println("null here");
			}
			else {
				
				for(String base64String:selectedtables) {
					final byte[] objToBytes = Base64.getDecoder().decode(base64String);
					ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
					ObjectInputStream ois = new ObjectInputStream(bais);
					try {
						Addbean beanobj=(Addbean)ois.readObject();
						hm.put(beanobj.getTableid(),beanobj);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(hm.size());
				for(Integer obj:hm.keySet()) {
					System.out.println(obj);
				}
				
			}
			managetable=new Managetable();
			//int val=request.getParameter("selectedTables")
			 String[] selectedTables = request.getParameterValues("selectedTables");
			 if(selectedTables!=null) {
				 List<Addbean> list=new ArrayList<>();
			 for(String val:selectedTables) {
				 System.out.println(val);
			   // System.out.println(m);
				 Addbean bean=new Addbean();
			    int i1=Integer.parseInt(request.getParameter("input1_"+val));
			    System.out.println(i1);
			    int i2=Integer.parseInt(request.getParameter("input2_"+val));
			    System.out.println(i2);
			    float i3=Float.parseFloat(request.getParameter("input3_"+val));
			    System.out.println(i3);
			    bean.setTableid(Integer.parseInt(val));
			    bean.setTableno(i1);
			    bean.setNoseats(i2);
			    bean.setPrice(i3);
			    list.add(bean);
			 }
			 
			if( managetable.updateModify(list,hm)) {
				System.out.println("updated successfully");
				response.sendRedirect("ADMINPAGES/UpdateSuccess.jsp");
			}
			else {
				response.sendRedirect("ADMINPAGES/~UpdatePartial.jsp");
				System.out.println("not updated");
			}
		}
	  }
		else {
		final String[] selectedtables = request.getParameterValues("MY_JAVA_OBJECT");
		List<Addbean> list=new ArrayList<>();
		if(selectedtables==null) {
			System.out.println("null here");
			response.sendRedirect("ADMINPAGES/Removefail.jsp");
		}
		else {
				for(String base64String:selectedtables) {
					final byte[] objToBytes = Base64.getDecoder().decode(base64String);
					ByteArrayInputStream bais = new ByteArrayInputStream(objToBytes);
					ObjectInputStream ois = new ObjectInputStream(bais);
					try {
						list.add((Addbean)ois.readObject());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(list.size());
				boolean status=false;
				managetable=new Managetable();
				status=managetable.removeTable(list);
				if(status) {
					response.sendRedirect("ADMINPAGES/RemoveSuccess.jsp");
				}
				else {
					response.sendRedirect("ADMINPAGES/Removefail.jsp");
				}
		}
		}
	}

}
