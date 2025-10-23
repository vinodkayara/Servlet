package in.ps.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet{
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   String uname= req.getParameter("username");
	       String password = req.getParameter("password");
		 
	       HttpSession s=req.getSession(true);
	       s.setAttribute("username", uname);
	       s.setAttribute("password", password);
	       
	       PrintWriter out=resp.getWriter();
	       resp.setContentType("text/html");
	       
	       out.println("<a href='servlet2'>Page 2</a>"); 
	       out.println("<a href='servlet3'>Page 3</a>");
	       out.println("<a href='logout'>Logout</a>");
	}

}
