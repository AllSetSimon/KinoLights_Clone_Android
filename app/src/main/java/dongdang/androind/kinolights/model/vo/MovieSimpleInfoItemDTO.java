package dongdang.androind.kinolights.model.vo;

public class MovieSimpleInfoItemDTO {

    private String name;
    private String genre;
    private String premire;
    private String country;
    private int image;
    private double radioScore;
    private double starScore;

    public MovieSimpleInfoItemDTO() {
    }

    public MovieSimpleInfoItemDTO(String name, String genre, String premire, String country, int image, double radioScore, double starScore) {
        this.name = name;
        this.genre = genre;
        this.premire = premire;
        this.country = country;
        this.image = image;
        this.radioScore = radioScore;
        this.starScore = starScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPremire() {
        return premire;
    }

    public void setPremire(String premire) {
        this.premire = premire;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getRadioScore() {
        return radioScore;
    }

    public void setRadioScore(double radioScore) {
        this.radioScore = radioScore;
    }

    public double getStarScore() {
        return starScore;
    }

    public void setStarScore(double starScore) {
        this.starScore = starScore;
    }
}

