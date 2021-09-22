package dongdang.androind.kinolights.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.vo.ProfileKinoInfoDTO;

public class ProfileWishAdapter extends BaseAdapter {
    private ArrayList<Integer> arrayList;

    public ProfileWishAdapter(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(parent.getContext());
            v = vi.inflate(R.layout.item_profile_wish_movie, parent, false);
        }
        ImageView imageView = v.findViewById(R.id.profileWishMovieImage);
        imageView.setImageResource(arrayList.get(position));
        return v;
    }
}
