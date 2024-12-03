import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecruitmentDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/recruitment_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    public List<Candidate> fetchSelectedCandidates(int threshold) {
        List<Candidate> candidates = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "SELECT name, score FROM candidates WHERE score >= ? ORDER BY score DESC";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, threshold);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                candidates.add(new Candidate(rs.getString("name"), rs.getInt("score")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidates;
    }
}