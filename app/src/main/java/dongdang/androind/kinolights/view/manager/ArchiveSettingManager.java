package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.bl.MovieService;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;

public class ArchiveSettingManager implements SettingManager {
    AppCompatActivity context;
    String[] archiveTabTagStr;
    String[] archiveTabIndicatorStr;
    int[] archiveTabContentId=new int[]{R.id.archiveFilterPriceContent,R.id.archiveFilterChannelContent,R.id.archiveFilterGradeContent};
    int archiveTabIndex;
    TabHost archiveTabHost;
    GridView archiveGridView;
    public ArchiveSettingManager(AppCompatActivity context) {
        this.context =context;
    }

    @Override
    public void init() {
        archiveTabTagStr = context.getResources().getStringArray(R.array.archiveTag);
        archiveTabIndicatorStr= context.getResources().getStringArray(R.array.archiveIndicator);

        archiveTabHost = (TabHost)context.findViewById(R.id.tabHostPlayFilter);
        archiveTabHost.setup();

        for(archiveTabIndex=0; archiveTabIndex<archiveTabTagStr.length; archiveTabIndex++) {
            TabHost.TabSpec archiveTabSpec = archiveTabHost.newTabSpec(archiveTabTagStr[archiveTabIndex]).setIndicator(archiveTabIndicatorStr[archiveTabIndex]);
            archiveTabSpec.setContent(archiveTabContentId[archiveTabIndex]);
            LinearLayout layout = (LinearLayout)context.findViewById(archiveTabContentId[archiveTabIndex]);
            Controller.addArchiveFilterLayout(new TabHostItemVO(archiveTabTagStr[archiveTabIndex], archiveTabIndicatorStr[archiveTabIndex], layout));

            archiveTabHost.addTab(archiveTabSpec);
            archiveTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    Controller.setVisibleArchiveFilterLayout(tabId);
                }
            });
        }
        archiveGridView = (GridView)context.findViewById(R.id.archiveGridView);
        archiveGridView.setAdapter(Controller.getArchiveAdapter(MovieService.all));
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        archiveGridView.measure(0, expandSpec);
        archiveGridView.getLayoutParams().height = archiveGridView.getMeasuredHeight();
    }

    public GridView getArchiveGridView() {
        return archiveGridView;
    }

    @Override
    public void setEvent() {

    }
}