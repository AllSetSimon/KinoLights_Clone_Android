package dongdang.androind.kinolights.util;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.vo.ReviewItemDTO;

public class ReviewAdapter extends BaseAdapter {
    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ReviewItemDTO> listViewItemList = new ArrayList<ReviewItemDTO>() ;

    // ListViewAdapter의 생성자
    public ReviewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return listViewItemList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "listview_item" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_review, parent, false);
        }

      /*  private Drawable reviewmvpics;
        private Drawable userpics;
        private Drawable redBtn;
        private Drawable greenBtn;
        private String reviewmvTitle;
        private String reviewmvGenre;
        private String reviewmvYear;
        private String reviewmvScore;
        private String reviewmvStar;

        private String userName;
        private String revieDate;
        private String reviewmvContent;
        private String reviewmvRecom;
        private String reviewmvComm;
        private float mvRating;*/

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView reviewmvpics = (ImageView) convertView.findViewById(R.id.thisWeekmovieImage);
        ImageView userpics = (ImageView) convertView.findViewById(R.id.thisWeekUserImage);
        /*ImageView redBtn = (ImageView) convertView.findViewById(R.id.redButton);
        ImageView greenBtn = (ImageView) convertView.findViewById(R.id.greenButton);*/

        TextView reviewmvTitle = (TextView) convertView.findViewById(R.id.thisWeekmovieName);
        TextView reviewmvGenre = (TextView) convertView.findViewById(R.id.thisWeekmovieGenre);
        TextView reviewmvYear = (TextView) convertView.findViewById(R.id.thisWeekmoviePremiere);
        TextView reviewmvScore = (TextView) convertView.findViewById(R.id.thiskWeekMovieScore);
        TextView userName = (TextView) convertView.findViewById(R.id.thiskWeekUserName);
        TextView revieDate = (TextView) convertView.findViewById(R.id.reportingDate);
        TextView reviewmvContent = (TextView) convertView.findViewById(R.id.thiskWeekReviewContent);

        RatingBar reviewmvStar = (RatingBar) convertView.findViewById(R.id.ratingScore);

        RadioButton rbRed = (RadioButton) convertView.findViewById(R.id.btnRadio1);
        RadioButton rbGreen = (RadioButton) convertView.findViewById(R.id.btnRadio2);


        // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
        ReviewItemDTO listViewItem = listViewItemList.get(position);

        // 아이템 내 각 위젯에 데이터 반영

        reviewmvpics.setImageResource(listViewItem.getReviewmvpics());
        userpics.setImageResource(listViewItem.getUserpics());
        /*redBtn.setImageDrawable(listViewItem.getRedBtn());
        greenBtn.setImageDrawable(listViewItem.getGreenBtn());*/

        reviewmvTitle.setText(listViewItem.getReviewmvTitle());
        reviewmvGenre.setText(listViewItem.getReviewmvGenre());
        reviewmvYear.setText(listViewItem.getReviewmvYear());
        reviewmvScore.setText(listViewItem.getReviewmvScore());
        userName.setText(listViewItem.getUserName());
        revieDate.setText(listViewItem.getRevieDate());
        reviewmvContent.setText(listViewItem.getReviewmvContent());

        reviewmvStar.setRating(listViewItem.getMvRating());

        rbRed.setChecked(listViewItem.isRbRed());
        rbGreen.setChecked(listViewItem.isRbGreen());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(int icon, String title, String genre, String year, int usericon, String userName , String date, boolean rbRed, boolean rbGreen, float score, String content) {
        ReviewItemDTO item = new ReviewItemDTO();

        item.setReviewmvpics(icon);
        item.setReviewmvTitle(title);
        item.setReviewmvGenre(genre);
        item.setReviewmvYear(year);
        item.setUserpics(usericon);
        item.setUserName(userName);
        item.setRevieDate(date);
        item.setRbRed(rbRed);
        item.setRbGreen(rbGreen);
        item.setMvRating(score);
        item.setReviewmvContent(content);

        listViewItemList.add(item);
    }
}
