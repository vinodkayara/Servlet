package in.ps.demo;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // Fetch existing session without creating a new one
        HttpSession session = req.getSession(false);

        if (session != null) {
            // Retrieve attributes before invalidating
            String name = (String) session.getAttribute("username");
            String password = (String) session.getAttribute("password");
            String id = session.getId();

            // Display user and session info
            out.println("<h2>User: " + name + "</h2>");
            out.println("<h3>Session ID: " + id + "</h3>");
            out.println("<p>Session is being invalidated...</p>");

            // Destroy the session
            session.invalidate();

            out.println("<h3>Session destroyed successfully.</h3>");
            out.println("<a href='login.jsp'>Login Again</a>");
        } else {
            // Session already expired or doesn't exist
            out.println("<h2>No active session found!</h2>");
            out.println("<a href='login.jsp'>Go to Login</a>");
        }

        out.close();
    }
}
