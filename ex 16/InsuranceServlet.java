import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class InsuranceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("name", request.getParameter("name"));
        session.setAttribute("age", request.getParameter("age"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<form action='SummaryServlet' method='post'>");
        out.println("Insurance Type: <select name='insuranceType'>");
        out.println("<option value='Health'>Health</option>");
        out.println("<option value='Life'>Life</option>");
        out.println("</select><br>");
        out.println("<input type='hidden' name='hiddenField' value='Data123'>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
    }
}
