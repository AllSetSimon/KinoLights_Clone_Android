package dongdang.androind.kinolights.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.vo.ProfileKinoInfoDTO;


public class ProfileKinoAdapter extends BaseAdapter {
    private ArrayList<ProfileKinoInfoDTO> arrayList;

    public ProfileKinoAdapter(ArrayList<ProfileKinoInfoDTO> arrayList) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(parent.getContext());
            v = vi.inflate(R.layout.item_etc_profile_kino_movie_info, parent, false);
        }
        return v;
    }
}
