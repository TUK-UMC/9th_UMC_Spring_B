package movie;

public class MovieReviewMain {
    public static void main(String[] args) {

        MovieReview[] reviews = new MovieReview[2];

        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한 루프";

        reviews[0] = inception;
        MovieReview aboutTime1 = new MovieReview();
        aboutTime1.title = "어바웃타임";
        aboutTime1.review = "인생 시간 영화";
        reviews[1] = aboutTime1;

        for (MovieReview review : reviews) {
            System.out.println("영화 제목: "+ review.title+", 영화 리뷰: "+review.review);
        }
    }
}
