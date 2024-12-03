import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

public class RecruitmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RecruitmentService service = new RecruitmentService();
        List<Candidate> selectedCandidates = service.getSelectedCandidates();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h1>Selected Candidates</h1><table border='1'>");
        out.println("<tr><th>Rank</th><th>Name</th><th>Score</th></tr>");

        int rank = 1;
        for (Candidate c : selectedCandidates) {
            out.println("<tr><td>" + rank++ + "</td><td>" + c.getName() + "</td><td>" + c.getScore() + "</td></tr>");
        }

        out.println("</table></body></html>");
    }
}
