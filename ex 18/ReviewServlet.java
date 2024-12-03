import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class ReviewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReviewService service = new ReviewService();
        List<Review> reviews = service.getAllReviews();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Reviews</h1><table border='1'>");
        out.println("<tr><th>Type</th><th>Comment</th></tr>");

        for (Review r : reviews) {
            out.println("<tr><td>" + r.getType() + "</td><td>" + r.getComment() + "</td></tr>");
        }

        out.println("</table></body></html>");
    }
}
