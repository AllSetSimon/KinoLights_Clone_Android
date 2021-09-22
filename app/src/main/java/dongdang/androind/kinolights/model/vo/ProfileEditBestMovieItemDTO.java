package dongdang.androind.kinolights.model.vo;

public class ProfileEditBestMovieItemDTO {
    private int image;
    private String name;
    private String year;

    public ProfileEditBestMovieItemDTO() {
    }

    public ProfileEditBestMovieItemDTO(int image, String name, String year) {
        this.image = image;
        this.name = name;
        this.year = year;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
