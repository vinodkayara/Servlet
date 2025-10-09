package in.ps.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insert")
public class insert  extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//reading form data 
		String name =req.getParameter("name");
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		int i=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo5", "root", "tiger");
			String query="INSERT INTO EMP VALUES(0,?,?,?,SYSDATE())";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, mail);
			ps.setString(3, password);
			i=ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=resp.getWriter();
		if(i>0) {
			out.println("<h1>Data Added successfully!</h1>");
		}else {
			out.println("<h1>Not added</h1>");
		}
	}
	

}
