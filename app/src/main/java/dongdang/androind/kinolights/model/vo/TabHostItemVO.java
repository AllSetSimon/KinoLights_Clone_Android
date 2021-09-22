package dongdang.androind.kinolights.model.vo;

import android.widget.LinearLayout;


public class TabHostItemVO {
   private String tag;
   private String indicator;
   private LinearLayout linearLayout;

    public TabHostItemVO(String tag, String indicator, LinearLayout linearLayout) {
        this.tag = tag;
        this.indicator = indicator;
        this.linearLayout = linearLayout;
    }

    public String getTag() {
        return tag;
    }

    public String getIndicator() {
        return indicator;
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }
}
