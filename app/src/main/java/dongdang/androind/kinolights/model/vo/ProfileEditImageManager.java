package dongdang.androind.kinolights.model.vo;

import android.widget.ImageView;

public class ProfileEditImageManager {
    private ImageView imageView;
    private ProfileEditBestMovieItemDTO dto;

    public ProfileEditImageManager() {
    }

    public ProfileEditImageManager(ImageView imageView, ProfileEditBestMovieItemDTO dto) {
        this.imageView = imageView;
        this.dto = dto;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public ProfileEditBestMovieItemDTO getDto() {
        return dto;
    }

    public void setDto(ProfileEditBestMovieItemDTO dto) {
        this.dto = dto;
    }
}
