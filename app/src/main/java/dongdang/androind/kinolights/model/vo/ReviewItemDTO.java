package dongdang.androind.kinolights.model.vo;

import android.graphics.drawable.Drawable;

public class ReviewItemDTO {
    private int reviewmvpics;
    private int userpics;
    /*private Drawable redBtn;
    private Drawable greenBtn;*/
    private boolean rbRed;
    private boolean rbGreen;
    private String reviewmvTitle;
    private String reviewmvGenre;
    private String reviewmvYear;
    private String reviewmvScore;
    private String reviewmvStar;
    private String userName;
    private String revieDate;
    private String reviewmvContent;
    private float mvRating;

    public ReviewItemDTO() {
    }

    public ReviewItemDTO(int icon, String title, String genre, String year, int usericon, String userName , String date, boolean rbRed, boolean rbGreen, float score, String content) {
        this.reviewmvpics=icon;
        this.reviewmvTitle=title;
        this.reviewmvGenre=genre;
        this.reviewmvYear=year;
        this.userpics=usericon;
        this.userName=userName;
        this.revieDate=date;
        this.rbRed=rbRed;
        this.rbGreen=rbGreen;
        this.mvRating=score;
        this.reviewmvContent=content;

    }

        public boolean isRbRed() {
        return rbRed;
    }

    public void setRbRed(boolean rbRed) {
        this.rbRed = rbRed;
    }

    public boolean isRbGreen() {
        return rbGreen;
    }

    public void setRbGreen(boolean rbGreen) {
        this.rbGreen = rbGreen;
    }

    public int getReviewmvpics() {
        return reviewmvpics;
    }

    public void setReviewmvpics(int reviewmvpics) {
        this.reviewmvpics = reviewmvpics;
    }

    public int getUserpics() {
        return userpics;
    }

    public void setUserpics(int userpics) {
        this.userpics = userpics;
    }
/* public Drawable getRedBtn() {
        return redBtn;
    }

    public void setRedBtn(Drawable redBtn) {
        this.redBtn = redBtn;
    }

    public Drawable getGreenBtn() {
        return greenBtn;
    }

    public void setGreenBtn(Drawable greenBtn) {
        this.greenBtn = greenBtn;
    }*/

    public String getReviewmvTitle() {
        return reviewmvTitle;
    }

    public void setReviewmvTitle(String reviewmvTitle) {
        this.reviewmvTitle = reviewmvTitle;
    }

    public String getReviewmvGenre() {
        return reviewmvGenre;
    }

    public void setReviewmvGenre(String reviewmvGenre) {
        this.reviewmvGenre = reviewmvGenre;
    }

    public String getReviewmvYear() {
        return reviewmvYear;
    }

    public void setReviewmvYear(String reviewmvYear) {
        this.reviewmvYear = reviewmvYear;
    }

    public String getReviewmvScore() {
        return reviewmvScore;
    }

    public void setReviewmvScore(String reviewmvScore) {
        this.reviewmvScore = reviewmvScore;
    }

    public String getReviewmvStar() {
        return reviewmvStar;
    }

    public void setReviewmvStar(String reviewmvStar) {
        this.reviewmvStar = reviewmvStar;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRevieDate() {
        return revieDate;
    }

    public void setRevieDate(String revieDate) {
        this.revieDate = revieDate;
    }

    public String getReviewmvContent() {
        return reviewmvContent;
    }

    public void setReviewmvContent(String reviewmvContent) {
        this.reviewmvContent = reviewmvContent;
    }

    public float getMvRating() {
        return mvRating;
    }

    public void setMvRating(float mvRating) {
        this.mvRating = mvRating;
    }
}
