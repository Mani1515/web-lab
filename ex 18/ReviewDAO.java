import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/review_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    public List<Review> fetchReviews() {
        List<Review> reviews = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "SELECT type, comment FROM reviews";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                reviews.add(new Review(rs.getString("type"), rs.getString("comment")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }
}
