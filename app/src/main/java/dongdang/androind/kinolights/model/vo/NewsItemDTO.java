package dongdang.androind.kinolights.model.vo;

import android.graphics.drawable.Drawable;

public class NewsItemDTO {
    private Drawable imageViewId;
    private String newsContent;
    private int ago;
    private boolean visible;
    private int color;
    private int tag;

    public NewsItemDTO(Drawable imageViewId, String newsContent, int ago, boolean visible, int color) {
        this.imageViewId = imageViewId;
        this.newsContent = newsContent;
        this.ago = ago;
        this.visible = visible;
        this.color = color;
    }

    public NewsItemDTO(Drawable imageViewId, String newsContent, int ago) {
        this.imageViewId = imageViewId;
        this.newsContent = newsContent;
        this.ago = ago;
    }

    public NewsItemDTO(Drawable imageViewId, String newsContent, int ago, int tag) {
        this.imageViewId = imageViewId;
        this.newsContent = newsContent;
        this.ago = ago;
        this.tag = tag;
    }

    public Drawable getImageViewId() {
        return imageViewId;
    }

    public void setImageViewId(Drawable imageViewId) {
        this.imageViewId = imageViewId;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public int getAgo() {
        return ago;
    }

    public void setAgo(int ago) {
        this.ago = ago;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }
}
