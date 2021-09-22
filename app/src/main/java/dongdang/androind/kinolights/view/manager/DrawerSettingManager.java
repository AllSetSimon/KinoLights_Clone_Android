package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.beardedhen.androidbootstrap.AwesomeTextView;
import com.beardedhen.androidbootstrap.BootstrapButton;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.bl.UserService;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;
import dongdang.androind.kinolights.model.vo.UserDTO;
import dongdang.androind.kinolights.util.CustomAdapter;
import dongdang.androind.kinolights.util.NaviMenu2Adapter;

public class DrawerSettingManager implements SettingManager {
    AppCompatActivity context;
    TabHost tabHost;
    DrawerLayout drawerLayout;
    ListView listView1, listView3;
    GridView listView2;
    BootstrapButton naviHeaderLogin, naviHeaderSignUP, naviHeaderLogout, naviHeaderEdit;

    AwesomeTextView naviHeaderUserName, naviHeaderUserIntroduce;


    public DrawerSettingManager(AppCompatActivity c, final TabHost tabHost) {
        this.context = c;
        this.tabHost = tabHost;
    }

    @Override
    public void init() {
        drawerLayout = (DrawerLayout)context.findViewById(R.id.drawerLayout);
        Controller.navigationViewDataSetup(tabHost,drawerLayout);
        Controller.setVisibleNavigationView(context.findViewById(R.id.mainNavigationView));
        //Navigation Menu 추가

        naviHeaderUserName = (AwesomeTextView)drawerLayout.findViewById(R.id.naviHeaderUserName);
        naviHeaderUserIntroduce = (AwesomeTextView)drawerLayout.findViewById(R.id.naviHeaderUserIntroduce);

        listView1 = (ListView)drawerLayout.findViewById(R.id.naviMenu1);
        CustomAdapter customAdapter = new CustomAdapter(context, 0, Controller.getNaviMenu1Data());
        listView1.setAdapter(customAdapter);
        listView2 = (GridView) drawerLayout.findViewById(R.id.naviMenu2);
        NaviMenu2Adapter naviMenu2Adapter = new NaviMenu2Adapter(Controller.getNaviMenu2Data(),getDrawerLayout(),tabHost);
        listView2.setAdapter(naviMenu2Adapter); //adapter에서 이벤트 동시 처리.
        listView3 = (ListView)drawerLayout.findViewById(R.id.naviMenu3);
        CustomAdapter customAdapter3 = new CustomAdapter(context, 0, Controller.getNaviMenu3Data());
        listView3.setAdapter(customAdapter3);

        naviHeaderLogin = (BootstrapButton)drawerLayout.findViewById(R.id.naviHeaderLogin);
        naviHeaderSignUP = (BootstrapButton)drawerLayout.findViewById(R.id.naviHeaderSignUP);
        naviHeaderLogout = (BootstrapButton)drawerLayout.findViewById(R.id.naviHeaderLogout);
        naviHeaderEdit = (BootstrapButton)drawerLayout.findViewById(R.id.naviHeaderEdit);

        LinearLayout linearLayout = context.findViewById(R.id.faqLayout);
        Controller.addLayout(new TabHostItemVO("faq","자주 묻는 질문",linearLayout));
    }

    @Override
    public void setEvent() {

        naviHeaderLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabHost.setCurrentTab(1);
                Controller.setVisibleTabHostLayout("profile");
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        naviHeaderSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabHost.setCurrentTab(1);
                Controller.setVisibleTabHostLayout("signUp");
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        naviHeaderLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.requestForLogout();
                Controller.setVisibleTabHostLayout("home");
                Controller.setVisibleNavigationView(context.findViewById(R.id.mainNavigationView));
                tabHost.setCurrentTab(0);
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        naviHeaderEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabHost.setCurrentTab(1);
                Controller.getProfileEditSettingManager().profileEditDataLoading();
                Controller.setVisibleTabHostLayout("profileEdit");
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public AppCompatActivity getContext() {
        return context;
    }

    public void drawerDataLoading() {
        UserDTO user = UserService.getUserInfo();
        naviHeaderUserName.setText(user.getName());
        naviHeaderUserIntroduce.setText(user.getIntroduce());
    }
}
