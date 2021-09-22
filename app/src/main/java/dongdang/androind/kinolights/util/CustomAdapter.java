package dongdang.androind.kinolights.util;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.vo.NaviMenuVO;

public class CustomAdapter extends ArrayAdapter<NaviMenuVO> {
    private ArrayList<NaviMenuVO> items;


    public CustomAdapter(Context context, int textViewResourceId, ArrayList<NaviMenuVO> objects) {
        super(context, textViewResourceId, objects);
        this.items = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(parent.getContext());
            v = vi.inflate(R.layout.item_main_navigation_menu, parent, false);
        }

        // 인스턴스 연결
        ImageView imageViewLeft = (ImageView)v.findViewById(R.id.naviMenuImageViewLeft);
        ImageView imageViewRight = (ImageView)v.findViewById(R.id.naviMenuImageViewRight);
        TextView textView = (TextView)v.findViewById(R.id.naviMenutextView);

        // 리스트뷰의 아이템에 이미지를 변경한다.
        NaviMenuVO temp = items.get(position);
        imageViewLeft.setImageResource(temp.getImageView1());
        imageViewRight.setImageResource(temp.getImageView2());
        textView.setText(temp.getTextView());
        v.setOnClickListener(temp.getEvent());

        return v;
    }
}
