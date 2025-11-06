import org.springframework.stereotype.Service;
import java.util.List;
import com.example.chapter4.domain.review.entity.Review; // Review 엔티티 임포트
import com.example.chapter4.domain.review.repository.ReviewQueryDslRepository; // QueryDSL 커스텀 레포지토리 임포트

@Service
public class ReviewService {
    private final ReviewQueryDslRepository reviewRepository;

    public ReviewService(ReviewQueryDslRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getMyReviews(Long memberId, String storeName, Integer starFloor) {
        return reviewRepository.findMyReviews(memberId, storeName, starFloor);
    }
}
