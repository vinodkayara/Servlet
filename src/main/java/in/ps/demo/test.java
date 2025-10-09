package in.ps.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/login")

public class test extends GenericServlet{
	
	public test(){
		System.out.println("servlet object is created");
	}
	public void init(ServletConfig config) throws ServletException{
		System.out.println("servlet object initialized");
	}
	

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		System.out.println("service() called");
		//collecting the request from the user
		String uname=req.getParameter("username");
		String pass=req.getParameter("password");
		
		//providing the response to the user
			System.out.println(uname+" "+pass);
			
			//abstract class-PrintWriter
			PrintWriter out=resp.getWriter();
			out.println("<h1>Welcome"+uname+"</h1>");
		
	}
	
	public void destroy() {
		System.out.println("destroy() called");
	}

}
