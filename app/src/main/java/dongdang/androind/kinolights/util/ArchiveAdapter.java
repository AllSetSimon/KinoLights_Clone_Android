package dongdang.androind.kinolights.util;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.vo.ArchiveMovieInfoDTO;

public class ArchiveAdapter extends BaseAdapter {
    private ArrayList<ArchiveMovieInfoDTO> arrayList;

    public ArchiveAdapter(ArrayList<ArchiveMovieInfoDTO> arrayList) {
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
            v = vi.inflate(R.layout.item_etc_archive_movie_info, parent, false);
            LinearLayout linearLayout = v.findViewById(R.id.archiveMyScoreLayout);
            ImageView movieImage = (ImageView)v.findViewById(R.id.simpleInfoMovieImage);
            TextView simpleInfoMovieName = (TextView)v.findViewById(R.id.simpleInfoMovieName);
            TextView simpleInfoMovieGenre = (TextView)v.findViewById(R.id.simpleInfoMovieGenre);
            TextView simpleInfoMoviePremiere = (TextView)v.findViewById(R.id.simpleInfoMoviePremiere);
            TextView simpleInfoMovieRadioScore = (TextView)v.findViewById(R.id.simpleInfoMovieRadioScore);
            TextView simpleInfoMovieStarScore = (TextView)v.findViewById(R.id.simpleInfoMovieStarScore);
            RadioButton achiveMovieInfoBtnRadio1 = (RadioButton)v.findViewById(R.id.achiveMovieInfoBtnRadio1);
            RadioButton achiveMovieInfoBtnRadio2 = (RadioButton)v.findViewById(R.id.achiveMovieInfoBtnRadio2);
            RatingBar achiveMovieInfoRatingScore = (RatingBar)v.findViewById(R.id.achiveMovieInfoRatingScore);

            ArchiveMovieInfoDTO dto = arrayList.get(position);
            movieImage.setImageResource(dto.getImage());
            simpleInfoMovieName.setText(dto.getName());
            simpleInfoMovieGenre.setText(dto.getGenre());
            simpleInfoMoviePremiere.setText(dto.getPremire());
            simpleInfoMovieRadioScore.setText(dto.getRadioScore()+"%");
            simpleInfoMovieStarScore.setText(dto.getStarScore()+"점");

            if(Controller.loginCheck()) {
                linearLayout.setVisibility(View.VISIBLE);
                achiveMovieInfoBtnRadio1.setChecked(dto.isMyRadioRedFlag());
                achiveMovieInfoBtnRadio2.setChecked(dto.isMyRadioGreenFlag());
                achiveMovieInfoRatingScore.setRating((float)(dto.getMyStarScore()));

            }
            else linearLayout.setVisibility(View.GONE);

        }
        return v;
    }
}
