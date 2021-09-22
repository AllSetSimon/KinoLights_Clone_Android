package dongdang.androind.kinolights.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class UserSummaryDTO {
    private int movieValue;
    private int reviewValue;
    private int following;
    private int follower;

    private String[] bestMovieUri;
    private String[] recentMovieUri;
    private int redRadioValue;
    private int greenRadioValue;

    /*
            없는것 국가, 장르 SQL로 해결
            리뷰 자신 리뷰 작성.
     */
    public UserSummaryDTO() {
        movieValue=reviewValue=following=follower=redRadioValue=greenRadioValue=0;
        bestMovieUri=recentMovieUri=null;

    }

    public UserSummaryDTO(int movieValue, int reviewValue, int following, int follower, String[] bestMovieUri, String[] recentMovieUri, int redRadioValue, int greenRadioValue) {
        this.movieValue = movieValue;
        this.reviewValue = reviewValue;
        this.following = following;
        this.follower = follower;
        this.bestMovieUri = bestMovieUri;
        this.recentMovieUri = recentMovieUri;
        this.redRadioValue = redRadioValue;
        this.greenRadioValue = greenRadioValue;
    }

    public int getMovieValue() {
        return movieValue;
    }

    public void setMovieValue(int movieValue) {
        this.movieValue = movieValue;
    }

    public int getReviewValue() {
        return reviewValue;
    }

    public void setReviewValue(int reviewValue) {
        this.reviewValue = reviewValue;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public String[] getBestMovieUri() {
        return bestMovieUri;
    }

    public void setBestMovieUri(String[] bestMovieUri) {
        this.bestMovieUri = bestMovieUri;
    }

    public String[] getRecentMovieUri() {
        return recentMovieUri;
    }

    public void setRecentMovieUri(String[] recentMovieUri) {
        this.recentMovieUri = recentMovieUri;
    }

    public int getRedRadioValue() {
        return redRadioValue;
    }

    public void setRedRadioValue(int redRadioValue) {
        this.redRadioValue = redRadioValue;
    }

    public int getGreenRadioValue() {
        return greenRadioValue;
    }

    public void setGreenRadioValue(int greenRadioValue) {
        this.greenRadioValue = greenRadioValue;
    }

}
