import java.util.List;

public class CertificationService {
    private CertificationDAO dao = new CertificationDAO();

    public List<Candidate> getRankList() {
        return dao.fetchRankedCandidates();
    }
}
