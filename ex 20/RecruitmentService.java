import java.util.List;

public class RecruitmentService {
    private RecruitmentDAO dao = new RecruitmentDAO();

    public List<Candidate> getSelectedCandidates() {
        return dao.fetchSelectedCandidates(80);
    }
}
