package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.gc.materialdesign.views.ProgressBarDeterminate;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.intrusoft.scatter.ChartData;
import com.intrusoft.scatter.PieChart;

import java.util.ArrayList;
import java.util.List;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.bl.UserService;
import dongdang.androind.kinolights.model.vo.UserDTO;
import dongdang.androind.kinolights.util.BestMovieAdapter;
import dongdang.androind.kinolights.util.ProfileWishAdapter;

public class ProfileSettingManager implements SettingManager {
   AppCompatActivity context;

    PieChart pieChart;
    LineChart lineChart;
    ProgressBarDeterminate[] progressBar;
    ListView myRecentReviewListView, myBestReviewListView;
    GridView profileSummaryBestMovieGridView;
    int[] buttonID;
    int[] contentID;

    TextView noBestMovieTextView;
    TextView profileTextViewName;
    ImageView profileImageView;
    TextView profileIntroduce;
    public ProfileSettingManager(AppCompatActivity context) {
        this.context = context;
    }
    //profileSummary
    @Override
    public void init() {
        profileTextViewName = context.findViewById(R.id.profileTextViewName);
        profileImageView = context.findViewById(R.id.profileImageView);
        profileIntroduce = context.findViewById(R.id.profileTextViewIntroduce);


        buttonID = new int[]{R.id.profileSummaryBtn,R.id.profileKinoBtn,R.id.profileReViewBtn,R.id.profileWishBtn};
        contentID = new int[]{R.id.profileSummaryLayout,R.id.profileKinoLayout,R.id.profileReViewLayout,R.id.profileWishLayout};
        for(int i=0; i<buttonID.length; i++) {
            Button b = (Button)context.findViewById(buttonID[i]);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Controller.setVisibleProfileContent(v.getId());
                }
            });
            Controller.connectButtonToContent(b,(LinearLayout)context.findViewById(contentID[i]));
        }
        Controller.setVisibleProfileContent(context.findViewById(R.id.profileSummaryBtn).getId());
    }
    public void profileDataLoading(){
        UserDTO userDTO = Controller.getUserInfo();
        profileTextViewName.setText(userDTO.getName());
        if(userDTO.getProfileImageUri()!=null)
            profileImageView.setImageURI(Uri.parse(userDTO.getProfileImageUri()));
        if(userDTO.getIntroduce()!=null)
            profileIntroduce.setText(userDTO.getIntroduce());

        profileSummarySetting();
        profileKinoSetting();
        profileReviewSetting();
        profileWishSetting();

    }

    @Override
    public void setEvent() {

    }

    private void profileSummarySetting() {
        setMyBestMovieSetting();
        setMyBestReviewListViewSetting();
        setMyRecentReviewListViewSetting();
        pieChartSetting();
        linChartSetting();
        genreSetting();
    }
    private void setMyBestMovieSetting() {
        profileSummaryBestMovieGridView = context.findViewById(R.id.profileSummaryBestMovieGridView);
        noBestMovieTextView = (TextView)context.findViewById(R.id.noBestMovieTextView);
        BestMovieAdapter adapter = Controller.getBestMovieAdapter();
        if(adapter == null)  noBestMovieTextView.setVisibility(View.VISIBLE);
        else {
            profileSummaryBestMovieGridView.setAdapter(adapter);
            noBestMovieTextView.setVisibility(View.GONE);
            profileSummaryBestMovieGridView.setVisibility(View.VISIBLE);
            int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
            profileSummaryBestMovieGridView.measure(0, expandSpec);
            profileSummaryBestMovieGridView.getLayoutParams().height = profileSummaryBestMovieGridView.getMeasuredHeight();
        }

    }
    private void setMyBestReviewListViewSetting() {
        myBestReviewListView = (ListView)context.findViewById(R.id.profileSummaryListViewFavoriteTop3);
        myBestReviewListView.setAdapter(Controller.selectMyBestReviewItem(context,myBestReviewListView));
        setListViewHeightBasedOnChildren(myBestReviewListView);
    }
    private void setMyRecentReviewListViewSetting() {
        myRecentReviewListView = (ListView)context.findViewById(R.id.profileSummaryListViewRecentTop3);
        myRecentReviewListView.setAdapter(Controller.selectMyRecentReviewItem(context,myRecentReviewListView));
        setListViewHeightBasedOnChildren(myRecentReviewListView);
    }
    private void pieChartSetting() {
        //https://github.com/IntruderShanky/Scatter-PieChart
        pieChart = (PieChart)context.findViewById(R.id.pie_chart);
        List<ChartData> data = new ArrayList<>();
        data.add(new ChartData("Red", 50, Color.WHITE, Color.parseColor("#FF0000")));
        data.add(new ChartData("Green", 50, Color.WHITE, Color.parseColor("#22741C")));
        pieChart.setChartData(data);

    }
    private void linChartSetting() {
        lineChart = (LineChart)context.findViewById(R.id.lineChart);
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0.0f, 0));
        entries.add(new Entry(0.5f, 0));
        entries.add(new Entry(1.0f, 0));
        entries.add(new Entry(1.5f, 2));
        entries.add(new Entry(2.0f, 2));
        entries.add(new Entry(2.5f, 2));
        entries.add(new Entry(3.0f, 5));
        entries.add(new Entry(3.5f, 2));
        entries.add(new Entry(4.0f, 3));
        entries.add(new Entry(4.5f, 2));
        entries.add(new Entry(5.0f, 1));

        LineDataSet lineDataSet = new LineDataSet(entries, "SKU StarChart");
        lineDataSet.setLineWidth(2);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setCircleHoleColor(Color.BLUE);
        lineDataSet.setColor(Color.parseColor("#FFA1B4DC"));
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawCircles(true);
        lineDataSet.setDrawHorizontalHighlightIndicator(false);
        lineDataSet.setDrawHighlightIndicators(false);
        lineDataSet.setDrawValues(false);

        LineData lineData = new LineData(lineDataSet);
        lineChart.setData(lineData);

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.enableGridDashedLine(8, 24, 0);

        xAxis.setLabelCount(11,true);
        YAxis yLAxis = lineChart.getAxisLeft();
        yLAxis.setDrawLabels(false);
        yLAxis.setDrawAxisLine(false);
        yLAxis.setDrawGridLines(false);

        YAxis yRAxis = lineChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);

        Description description = new Description();
        description.setText("");

        lineChart.setDoubleTapToZoomEnabled(false);
        lineChart.setDrawGridBackground(false);
        lineChart.setDescription(description);
        lineChart.animateY(2000, Easing.EaseInCubic);
        lineChart.invalidate();
    }
    private void genreSetting() {
        int[] progressId = {R.id.progressDrama,R.id.progressAction,R.id.progressSF,R.id.progressMelo,R.id.progressMusical,R.id.progressMusic,R.id.progressAdventure};
        progressBar = new ProgressBarDeterminate[progressId.length];

        for(int i=0; i<progressId.length; i++) {
            progressBar[i] = (ProgressBarDeterminate)context.findViewById(progressId[i]);
            progressBar[i].setProgress((i+1)*10);
        }

    }

    //profileKino
    private void profileKinoSetting() {
        profileKInoMovieSetting();
    }
    private void profileKInoMovieSetting() {
        GridView gridView = (GridView)context.findViewById(R.id.profileKinoGridView);
        gridView.setAdapter(Controller.getProfileKinoAdapter());
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        gridView.measure(0, expandSpec);
        gridView.getLayoutParams().height = gridView.getMeasuredHeight();
    }

    View.OnClickListener reviewEvent = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Controller.setVisibleProfileReviewLayout((ViewGroup)(context.findViewById(R.id.profileReViewLayout)),v.getId());
        }
    };
    private void profileReviewSetting() {
        profileWriteAndFavoriteReviewSetting();
    }
    private void profileWriteAndFavoriteReviewSetting() {
        BootstrapButton profileReviewWriteBtn = (BootstrapButton)context.findViewById(R.id.profileReviewWriteBtn);
        BootstrapButton profileReviewFavoriteBtn = (BootstrapButton)context.findViewById(R.id.profileReviewFavoriteBtn);
        profileReviewFavoriteBtn.setOnClickListener(reviewEvent);
        profileReviewWriteBtn.setOnClickListener(reviewEvent);
        profileReviewWriteBtn.callOnClick();
    }

    private void profileWishSetting() {
        profileWishGridViewSetting();
    }
    private void profileWishGridViewSetting() {
        GridView profileWishGridView = (GridView)context.findViewById(R.id.profileWishGridView);
        TextView message = (TextView)context.findViewById(R.id.profileWishMessage);
        ProfileWishAdapter wishAdapter = Controller.profileWishAdapter();
        if(wishAdapter == null) {
            message.setVisibility(View.VISIBLE);
            profileWishGridView.setVisibility(View.GONE);
        }else {
            message.setVisibility(View.GONE);
            profileWishGridView.setAdapter(wishAdapter);
            profileWishGridView.setVisibility(View.VISIBLE);

            int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
            profileWishGridView.measure(0, expandSpec);
            profileWishGridView.getLayoutParams().height = profileWishGridView.getMeasuredHeight();
        }
    }
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter adapter = listView.getAdapter();
        int listviewHeight = 0;
        listView.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        listviewHeight = listView.getMeasuredHeight() * adapter.getCount() + (adapter.getCount() * listView.getDividerHeight());
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = listviewHeight;
        listView.setLayoutParams(params);
        listView.requestLayout();

    }
}
