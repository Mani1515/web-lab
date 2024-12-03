import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve parameters from the HTML form
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate response
        out.println("<html><body>");
        out.println("<h2>Thank You for Submitting Your Details!</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body></html>");
    }
}
