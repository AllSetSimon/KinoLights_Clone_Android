package dongdang.androind.kinolights.model.vo;

public class ThisweekReviewItemDTO {
    private int thisWeekMovieImage;
    private int thisWeekMovieUserImage;
    private String movieName, genre, premiere, userName, reportingDate,
    reviewContent, recommendation, comment;
    private double thisWeekscore, thisWeekRatingScore;
    private double myRatingScore;
    private boolean myRadioScore;

    public ThisweekReviewItemDTO(int thisWeekMovieImage, int thisWeekMovieUserImage, String movieName, String genre,
                                String premiere, String userName, String reportingDate, String reviewContent, String recommendation,
                                String comment, double thisWeekscore, double thisWeekRatingScore, double myRatingScore, boolean myRadioScore) {
        this.thisWeekMovieImage = thisWeekMovieImage;
        this.thisWeekMovieUserImage = thisWeekMovieUserImage;
        this.movieName = movieName;
        this.genre = genre;
        this.premiere = premiere;
        this.userName = userName;
        this.reportingDate = reportingDate;
        this.reviewContent = reviewContent;
        this.recommendation = recommendation;
        this.comment = comment;
        this.thisWeekscore = thisWeekscore;
        this.thisWeekRatingScore = thisWeekRatingScore;
        this.myRatingScore = myRatingScore;
        this.myRadioScore = myRadioScore;
    }

    public int getThisWeekMovieImage() {
        return thisWeekMovieImage;
    }

    public void setThisWeekMovieImage(int thisWeekMovieImage) {
        this.thisWeekMovieImage = thisWeekMovieImage;
    }

    public int getThisWeekMovieUserImage() {
        return thisWeekMovieUserImage;
    }

    public void setThisWeekMovieUserImage(int thisWeekMovieUserImage) {
        this.thisWeekMovieUserImage = thisWeekMovieUserImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPremiere() {
        return premiere;
    }

    public void setPremiere(String premiere) {
        this.premiere = premiere;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(String reportingDate) {
        this.reportingDate = reportingDate;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getThisWeekscore() {
        return thisWeekscore;
    }

    public void setThisWeekscore(double thisWeekscore) {
        this.thisWeekscore = thisWeekscore;
    }

    public double getThisWeekRatingScore() {
        return thisWeekRatingScore;
    }

    public void setThisWeekRatingScore(double thisWeekRatingScore) {
        this.thisWeekRatingScore = thisWeekRatingScore;
    }

    public double getMyRatingScore() {
        return myRatingScore;
    }

    public void setMyRatingScore(double myRatingScore) {
        this.myRatingScore = myRatingScore;
    }

    public boolean isMyRadioScore() {
        return myRadioScore;
    }

    public void setMyRadioScore(boolean myRadioScore) {
        this.myRadioScore = myRadioScore;
    }
}
