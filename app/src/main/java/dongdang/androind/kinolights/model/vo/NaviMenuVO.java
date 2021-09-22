package dongdang.androind.kinolights.model.vo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class NaviMenuVO {
    int imageView1, imageView2;
    String textView;
    View.OnClickListener event;
    public NaviMenuVO(int imageView1,  String textView, int imageView2) {
        this.imageView1 = imageView1;
        this.imageView2 = imageView2;
        this.textView = textView;
    }

    public int getImageView1() {
        return imageView1;
    }

    public int getImageView2() {
        return imageView2;
    }

    public String getTextView() {
        return textView;
    }

    public void setEvent(View.OnClickListener event) {
        this.event = event;
    }
    public View.OnClickListener getEvent() {
        return this.event;
    }
}
