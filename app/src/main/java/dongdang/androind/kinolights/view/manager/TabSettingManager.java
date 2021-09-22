package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;

public class TabSettingManager implements SettingManager {
    AppCompatActivity context;

    TabHost tabHost;
    String[] tabTagStr;
    String[] tabIndicatorStr;
    int[] tabContentId;
    int tabIndex;
    public TabSettingManager(AppCompatActivity context) {
        this.context = context;
    }

    @Override
    public void init() {
        tabTagStr = context.getResources().getStringArray(R.array.tabHostTag);
        tabIndicatorStr= context.getResources().getStringArray(R.array.tabHostIndicator);
        tabContentId=new int[]{R.id.homeActivityLayout,R.id.profileLayout,R.id.archiveLayout,R.id.reViewLayout,R.id.eventLayout};

        tabHost = (TabHost)context.findViewById(R.id.tabHost);
        tabHost.setup();
        for(tabIndex=0; tabIndex<tabTagStr.length; tabIndex++) {
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabTagStr[tabIndex]).setIndicator(tabIndicatorStr[tabIndex]);
            tabSpec.setContent(tabContentId[tabIndex]);
            LinearLayout layout = (LinearLayout)context.findViewById(tabContentId[tabIndex]);
            Controller.addLayout(new TabHostItemVO(tabTagStr[tabIndex], tabIndicatorStr[tabIndex], layout));
            tabHost.addTab(tabSpec);
            tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
                @Override
                public void onTabChanged(String tabId) {
                    Controller.setVisibleTabHostLayout(tabId);
                }
            });
        }
        tabHost.setCurrentTab(0);
    }

    @Override
    public void setEvent() {

    }

    public TabHost getTabHost() {
        return tabHost;
    }
}