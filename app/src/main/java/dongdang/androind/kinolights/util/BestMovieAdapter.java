package dongdang.androind.kinolights.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.bl.MovieService;
import dongdang.androind.kinolights.model.vo.MovieSimpleInfoItemDTO;

public class BestMovieAdapter extends BaseAdapter {
    private ArrayList<MovieSimpleInfoItemDTO> arrayList;

    public BestMovieAdapter(ArrayList<MovieSimpleInfoItemDTO> arrayList) {
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
            v = vi.inflate(R.layout.item_etc_movie_simple_info,parent, false);
            ImageView movieImage = (ImageView)v.findViewById(R.id.simpleInfoMovieImage);
            TextView simpleInfoMovieName = (TextView)v.findViewById(R.id.simpleInfoMovieName);
            TextView simpleInfoMovieGenre = (TextView)v.findViewById(R.id.simpleInfoMovieGenre);
            TextView simpleInfoMoviePremiere = (TextView)v.findViewById(R.id.simpleInfoMoviePremiere);
            TextView simpleInfoMovieRadioScore = (TextView)v.findViewById(R.id.simpleInfoMovieRadioScore);
            TextView simpleInfoMovieStarScore = (TextView)v.findViewById(R.id.simpleInfoMovieStarScore);

            MovieSimpleInfoItemDTO dto = arrayList.get(position);
            movieImage.setImageResource(dto.getImage());
            simpleInfoMovieName.setText(dto.getName());
            simpleInfoMovieGenre.setText(dto.getGenre());
            simpleInfoMoviePremiere.setText(dto.getPremire());
            simpleInfoMovieRadioScore.setText(dto.getRadioScore()+"%");
            simpleInfoMovieStarScore.setText(dto.getStarScore()+"점");

        }
        return v;
    }
}
