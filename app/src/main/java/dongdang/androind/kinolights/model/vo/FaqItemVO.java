package dongdang.androind.kinolights.model.vo;

import android.widget.LinearLayout;

public class FaqItemVO {
    private String title;
    private String content;
    private LinearLayout headerLayout;
    private LinearLayout contentLayout;

    public FaqItemVO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LinearLayout getHeaderLayout() {
        return headerLayout;
    }

    public void setHeaderLayout(LinearLayout headerLayout) {
        this.headerLayout = headerLayout;
    }

    public LinearLayout getContentLayout() {
        return contentLayout;
    }

    public void setContentLayout(LinearLayout contentLayout) {
        this.contentLayout = contentLayout;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
