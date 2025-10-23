package in.ps.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/servlet2") 
public class Servlet2 extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession s=req.getSession(false);
		   String uname= (String)s.getAttribute("username");
	       String password = (String)s.getAttribute("password");
		 

	       
	       PrintWriter out=resp.getWriter();
	       resp.setContentType("text/html");
	       out.println("<h1>"+uname+" "+password+" "+req.getRequestedSessionId()+"</h1>"); 

	       
	       
	       
	}

}
