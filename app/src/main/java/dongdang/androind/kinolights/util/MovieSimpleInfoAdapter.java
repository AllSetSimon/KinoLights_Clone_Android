package dongdang.androind.kinolights.util;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.vo.MovieSimpleInfoItemDTO;

public class MovieSimpleInfoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<MovieSimpleInfoItemDTO> arrayList = new ArrayList<>();
    public MovieSimpleInfoAdapter(ArrayList<MovieSimpleInfoItemDTO> arrayList){
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       //xml세팅
        View xView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_etc_movie_simple_info,parent,false);

        return new RowCell(xView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //아이템 세팅
        ((RowCell)holder).image.setImageResource(arrayList.get(position).getImage());
        ((RowCell)holder).name.setText(arrayList.get(position).getName());
        ((RowCell)holder).genre.setText(arrayList.get(position).getGenre());
        ((RowCell)holder).premire.setText(arrayList.get(position).getPremire());
        ((RowCell)holder).radioScore.setText(Double.toString(arrayList.get(position).getRadioScore())+"%");
        ((RowCell)holder).starScore.setText(Double.toString(arrayList.get(position).getStarScore())+"점");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private class RowCell extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;
        private TextView genre;
        private TextView premire;
        private TextView radioScore;
        private TextView starScore;

        public RowCell(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.simpleInfoMovieImage);
            name = (TextView)view.findViewById(R.id.simpleInfoMovieName);
            genre = (TextView)view.findViewById(R.id.simpleInfoMovieGenre);
            premire = (TextView)view.findViewById(R.id.simpleInfoMoviePremiere);
            radioScore = (TextView)view.findViewById(R.id.simpleInfoMovieRadioScore);
            starScore = (TextView)view.findViewById(R.id.simpleInfoMovieStarScore);

        }


    }
}
