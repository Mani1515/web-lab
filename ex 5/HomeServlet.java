import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.*;

public class HomeServlet extends HttpServlet {
    private int hitCount;

    @Override
    public void init() {
        hitCount = 0; // Initialize hit count
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Increment hit count
        hitCount++;

        // Track session
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            userId = "User" + session.getId();
            session.setAttribute("userId", userId);
        }

        // Display page content
        out.println("<html><body>");
        out.println("<h2>Welcome to the College Webpage</h2>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
        out.println("<p>User ID: " + userId + "</p>");
        out.println("<p>Total Page Hits: " + hitCount + "</p>");
        out.println("<a href='HomeServlet'>Refresh Page</a>");
        out.println("</body></html>");
    }
}
