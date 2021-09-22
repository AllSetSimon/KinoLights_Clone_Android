package dongdang.androind.kinolights.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.vo.MovieSimpleInfoItemDTO;


public class SearchAdapter extends BaseAdapter {
    private ArrayList<MovieSimpleInfoItemDTO> listViewItemList = new ArrayList<>() ;

    public SearchAdapter(ArrayList<MovieSimpleInfoItemDTO> listViewItemList) {
        this.listViewItemList = listViewItemList;
    }

    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
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
            v = vi.inflate(R.layout.item_search, parent, false);
        }
        ImageView imageView = (ImageView)v.findViewById(R.id.searchMovieImage);
        TextView searchMoiveTitle = (TextView)v.findViewById(R.id.searchMoiveTitle);
        TextView searchMovieGenre = (TextView)v.findViewById(R.id.searchMovieGenre);
        TextView searchPremiere = (TextView)v.findViewById(R.id.searchPremiere);

        imageView.setImageResource(listViewItemList.get(position).getImage());
        searchMoiveTitle.setText(listViewItemList.get(position).getName());
        searchMovieGenre.setText(listViewItemList.get(position).getGenre());
        searchPremiere.setText(listViewItemList.get(position).getPremire());

        return v;
    }
}
