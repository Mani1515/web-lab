import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class InsuranceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String age = request.getParameter("age");
        String type = request.getParameter("type");

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Generate response
        out.println("<html><body>");
        out.println("<h2>Insurance Application Summary</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("<p>Selected Insurance Type: " + type + "</p>");
        out.println("<a href='insurance_form.html'>Back to Form</a>");
        out.println("</body></html>");
    }
}
