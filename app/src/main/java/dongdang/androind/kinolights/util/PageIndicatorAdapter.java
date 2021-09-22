package dongdang.androind.kinolights.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.vo.ThisweekReviewItemDTO;

public class PageIndicatorAdapter extends PagerAdapter {

    private List<View> viewList;
    private ViewGroup parent;

    public PageIndicatorAdapter(ViewGroup parent) {
        this.viewList = new ArrayList<>();
        this.parent = parent;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        View view = viewList.get(position);
        collection.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    public void setData(@Nullable List<View> list) {
        this.viewList.clear();
        if (list != null && !list.isEmpty()) {
            this.viewList.addAll(list);
        }
        notifyDataSetChanged();

    }

    @NonNull
    public List<View> getData() {
        if (viewList == null) {
            viewList = new ArrayList<>();
        }

        return viewList;
    }
}