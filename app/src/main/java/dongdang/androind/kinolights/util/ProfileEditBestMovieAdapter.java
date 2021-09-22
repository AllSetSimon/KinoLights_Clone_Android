package dongdang.androind.kinolights.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.vo.ProfileEditBestMovieItemDTO;

public class ProfileEditBestMovieAdapter extends BaseAdapter {
    private ArrayList<ProfileEditBestMovieItemDTO> arrayList;

    public ProfileEditBestMovieAdapter(ArrayList<ProfileEditBestMovieItemDTO> arrayList) {
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
            v = vi.inflate(R.layout.item_profile_best_movie, parent, false);
        }
        ProfileEditBestMovieItemDTO profileEditBestMovieItemDTO = arrayList.get(position);
        ImageView imageView = (ImageView)v.findViewById(R.id.imageProfileEditBestMovie);
        imageView.setImageResource(profileEditBestMovieItemDTO.getImage());
        TextView textViewName = (TextView)v.findViewById(R.id.nameProfileEditBestMovie);
        textViewName.setText(profileEditBestMovieItemDTO.getName());
        TextView textViewYear = (TextView)v.findViewById(R.id.yearProfileEditBestMovie);
        textViewYear.setText(profileEditBestMovieItemDTO.getYear());
        return v;
    }

}
