import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class UserFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<form action='InsuranceServlet' method='post'>");
        out.println("Name: <input type='text' name='name'><br>");
        out.println("Age: <input type='number' name='age'><br>");
        out.println("<input type='submit' value='Next'>");
        out.println("</form>");
    }
}
