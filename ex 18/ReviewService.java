import java.util.List;

public class ReviewService {
    private ReviewDAO dao = new ReviewDAO();

    public List<Review> getAllReviews() {
        return dao.fetchReviews();
    }
}
