package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.rd.PageIndicatorView;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;

public class HomeSettingManager implements SettingManager{
    AppCompatActivity context;
    ViewPager pager;
    RecyclerView currentRecyclerView,dueForRecycleView;

    public HomeSettingManager(AppCompatActivity context) {
        this.context = context;
    }

    @Override
    public void init() {
        pager = (ViewPager)context.findViewById(R.id.viewPager);
        pager.setAdapter(Controller.selectThisweekReviewItem((ViewGroup)context.findViewById(R.id.viewPager)));
        PageIndicatorView pageIndicatorView = (PageIndicatorView)context.findViewById(R.id.pageIndicatorView);
        Controller.insertCurrentMovieContent();
        Controller.insertDueForContent();
        currentRecyclerView =(RecyclerView)context.findViewById(R.id.currentScreeningView);
        currentRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL,false));
        currentRecyclerView.setAdapter(Controller.getCurrentScrreningAdapter());
        dueForRecycleView =(RecyclerView)context.findViewById(R.id.dueForReleaseView);
        dueForRecycleView.setLayoutManager(new LinearLayoutManager(context,LinearLayout.HORIZONTAL,false));
        dueForRecycleView.setAdapter(Controller.getdueForReleaseAdapter());
    }

    @Override
    public void setEvent() {

    }
}