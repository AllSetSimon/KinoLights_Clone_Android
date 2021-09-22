package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.vo.EventItemDTO;
import dongdang.androind.kinolights.util.EventAdapter;
import dongdang.androind.kinolights.util.EventOverdueAdapter;

public class EventSettingManager implements SettingManager {
    AppCompatActivity context;
    String[] eventTabIndicatorStr;
    String[] eventTabTagStr;
    int[] eventTabContentId;
    TabHost eventTabHost;
    RecyclerView eventOverdueRecyclerView, eventProceedRecyclerView;

    public EventSettingManager(AppCompatActivity context) {
       this.context = context;

    }

    @Override
    public void init() {
        Controller.insertEventProceedContent();
        Controller.insertEventOverdueContent();
        eventTabIndicatorStr=context.getResources().getStringArray(R.array.eventIndicatror);
        eventTabTagStr=context.getResources().getStringArray(R.array.eventTag);
        eventTabContentId=new int[]{R.id.event_proceed_layout,R.id.event_overdue_layout};
        eventTabHost = (TabHost)context.findViewById(R.id.eventTabHost);
        eventTabHost.setup();
        for(int i=0; i<eventTabTagStr.length; i++) {
            TabHost.TabSpec eventTabSpec = eventTabHost.newTabSpec(eventTabTagStr[i]).setIndicator(eventTabIndicatorStr[i]);
            eventTabSpec.setContent(eventTabContentId[i]);
            eventTabHost.addTab(eventTabSpec);
            eventTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    ((ScrollView)context.findViewById(R.id.contentScroll)).scrollTo(0,0);
                    ((ScrollView)context.findViewById(R.id.contentScroll)).smoothScrollTo(0,0);
                    ((ScrollView)context.findViewById(R.id.contentScroll)).invalidate();
                }
            });
        }
        eventProceedRecyclerView = (RecyclerView)context.findViewById(R.id.eventProceedRecyclerView);
        eventProceedRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        EventAdapter eventProceedAdapter = Controller.selectEventProceedContentAll(context);
        eventProceedRecyclerView.setAdapter(eventProceedAdapter);

        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        eventProceedRecyclerView.measure(0, expandSpec);
        eventProceedRecyclerView.getLayoutParams().height = eventProceedRecyclerView.getMeasuredHeight()+200;

        eventOverdueRecyclerView = (RecyclerView)context.findViewById(R.id.eventOverdueRecyclerView);
        eventOverdueRecyclerView.setLayoutManager(new LinearLayoutManager(context));

        EventOverdueAdapter eventOverdueAdapter = Controller.selectEventOverDueContentAll(context);
        eventOverdueRecyclerView.setAdapter(eventOverdueAdapter);
        int expandSpec2 = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        eventOverdueRecyclerView.measure(0, expandSpec2);
        eventOverdueRecyclerView.getLayoutParams().height = eventOverdueRecyclerView.getMeasuredHeight()+200;

    }

    @Override
    public void setEvent() {

    }


}
