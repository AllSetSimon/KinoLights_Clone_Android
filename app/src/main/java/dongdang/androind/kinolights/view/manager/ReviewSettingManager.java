package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;

public class ReviewSettingManager implements SettingManager{
    AppCompatActivity context;
    ListView recentReviewListView,bestReviewListView;
    BootstrapButton btnRecentReview, btnBestReview;
    View.OnClickListener btnReviewEvnet;

    public ReviewSettingManager(AppCompatActivity context) {
        this.context = context;
        final ViewGroup viewGroup = (ViewGroup)(context.findViewById(R.id.reViewLayout));
        btnReviewEvnet= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.setVisibleReviewLayout(viewGroup,v.getId());
            }
        };
    }

    @Override
    public void init() {
        recentReviewListView = (ListView)context.findViewById(R.id.recentReviewListView);
        bestReviewListView = (ListView)context.findViewById(R.id.bestReviewListView);
        btnRecentReview = (BootstrapButton)context.findViewById(R.id.btnRecentReview);
        btnBestReview = (BootstrapButton)context.findViewById(R.id.btnBestReview);
    }

    @Override
    public void setEvent() {
        btnBestReview.setOnClickListener(btnReviewEvnet);
        btnRecentReview.setOnClickListener(btnReviewEvnet);
        btnRecentReview.callOnClick();
    }
}