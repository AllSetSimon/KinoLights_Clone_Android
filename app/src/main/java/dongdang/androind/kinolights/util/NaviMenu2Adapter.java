package dongdang.androind.kinolights.util;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.Toast;

import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;

public class NaviMenu2Adapter extends BaseAdapter {

    private ArrayList<String> arrayList;
    private DrawerLayout drawerLayout;
    private TabHost tabHost;
    public NaviMenu2Adapter(ArrayList<String> objects, DrawerLayout drawerLayout, TabHost tabHost) {
       this.arrayList = objects;
       this.drawerLayout = drawerLayout;
       this.tabHost = tabHost;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public View getView(int position, View convertView, final ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = LayoutInflater.from(parent.getContext());
            v = vi.inflate(R.layout.item2_main_navigation_menu, parent, false);
        }
        final Button btn = (Button)v.findViewById(R.id.naviMenuItem2);
        btn.setText(arrayList.get(position));
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.LEFT);
                tabHost.setCurrentTab(1);
                Controller.setVisibleTabHostLayout("profile");
                Controller.searchByProfileButtonTag(((Button)btn).getText().toString()).getButton().callOnClick();
            }
        });
        return v;
    }
}
