package dongdang.androind.kinolights.model.vo;

public class ProfileKinoInfoDTO extends ArchiveMovieInfoDTO {
    private int myRatingBar;
    private String evalDate;

    public ProfileKinoInfoDTO(String name, String genre, String premire, String country, int image, double radioScore, double starScore, boolean myRadioGreenFlag, boolean myRadioRedFlag, double myStarScore, int myRatingBar, String evalDate) {
        super(name, genre, premire, country, image, radioScore, starScore, myRadioGreenFlag, myRadioRedFlag, myStarScore);
        this.myRatingBar = myRatingBar;
        this.evalDate = evalDate;
    }

    public int getMyRatingBar() {
        return myRatingBar;
    }

    public void setMyRatingBar(int myRatingBar) {
        this.myRatingBar = myRatingBar;
    }

    public String getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(String evalDate) {
        this.evalDate = evalDate;
    }
}
