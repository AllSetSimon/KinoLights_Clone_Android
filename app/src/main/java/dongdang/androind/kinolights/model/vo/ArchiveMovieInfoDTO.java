package dongdang.androind.kinolights.model.vo;

public class ArchiveMovieInfoDTO extends MovieSimpleInfoItemDTO {
    boolean myRadioGreenFlag;
    boolean myRadioRedFlag;
    double myStarScore;

    public ArchiveMovieInfoDTO() {
    }

    public ArchiveMovieInfoDTO(boolean myRadioGreenFlag, boolean myRadioRedFlag, double myStarScore) {
        this.myRadioGreenFlag = myRadioGreenFlag;
        this.myRadioRedFlag = myRadioRedFlag;
        this.myStarScore = myStarScore;
    }

    public ArchiveMovieInfoDTO(String name, String genre, String premire, String country, int image, double radioScore, double starScore, boolean myRadioGreenFlag, boolean myRadioRedFlag, double myStarScore) {
        super(name, genre, premire, country, image, radioScore, starScore);
        this.myRadioGreenFlag = myRadioGreenFlag;
        this.myRadioRedFlag = myRadioRedFlag;
        this.myStarScore = myStarScore;
    }

    public ArchiveMovieInfoDTO(MovieSimpleInfoItemDTO m) {
        super(m.getName(),m.getGenre(),m.getPremire(),m.getCountry(),m.getImage(),m.getRadioScore(),m.getStarScore());
    }

    public boolean isMyRadioGreenFlag() {
        return myRadioGreenFlag;
    }

    public void setMyRadioGreenFlag(boolean myRadioGreenFlag) {
        this.myRadioGreenFlag = myRadioGreenFlag;
    }

    public boolean isMyRadioRedFlag() {
        return myRadioRedFlag;
    }

    public void setMyRadioRedFlag(boolean myRadioRedFlag) {
        this.myRadioRedFlag = myRadioRedFlag;
    }

    public double getMyStarScore() {
        return myStarScore;
    }

    public void setMyStarScore(double myStarScore) {
        this.myStarScore = myStarScore;
    }
}

