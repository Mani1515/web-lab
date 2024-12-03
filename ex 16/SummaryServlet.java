import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class SummaryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");
        String age = (String) session.getAttribute("age");
        String insuranceType = request.getParameter("insuranceType");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Summary</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Age: " + age + "<br>");
        out.println("Insurance Type: " + insuranceType);
    }
}
