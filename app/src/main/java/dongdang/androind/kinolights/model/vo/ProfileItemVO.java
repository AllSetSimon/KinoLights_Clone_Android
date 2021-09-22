package dongdang.androind.kinolights.model.vo;

import android.widget.Button;
import android.widget.LinearLayout;

public class ProfileItemVO {
    LinearLayout content;
    Button button;
    String tag;

    public ProfileItemVO(LinearLayout content, Button button, String tag) {
        this.content = content;
        this.button = button;
        this.tag = tag;
    }


    public LinearLayout getContent() {
        return content;
    }

    public Button getButton() {
        return button;
    }

    public String getTag() {
        return tag;
    }
}
