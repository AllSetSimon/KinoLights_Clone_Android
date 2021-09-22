package dongdang.androind.kinolights.view;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;

import dongdang.androind.kinolights.model.vo.NewsItemDTO;

import dongdang.androind.kinolights.util.KinoDBHelperFactory;
import dongdang.androind.kinolights.util.SHContextMenu;
import dongdang.androind.kinolights.view.manager.ArchiveSettingManager;
import dongdang.androind.kinolights.view.manager.DrawerSettingManager;
import dongdang.androind.kinolights.view.manager.EventSettingManager;
import dongdang.androind.kinolights.view.manager.HomeSettingManager;
import dongdang.androind.kinolights.view.manager.JoinSettingManager;
import dongdang.androind.kinolights.view.manager.LoginSettingManager;
import dongdang.androind.kinolights.view.manager.ProfileEditSettingManager;
import dongdang.androind.kinolights.view.manager.ProfileSettingManager;
import dongdang.androind.kinolights.view.manager.ReviewSettingManager;
import dongdang.androind.kinolights.view.manager.SettingManager;
import dongdang.androind.kinolights.view.manager.SignUpSettingManager;
import dongdang.androind.kinolights.view.manager.TabSettingManager;


public class MainActivity extends AppCompatActivity {
    public static final int PICK_FROM_ALBUM = 10;
    Toolbar myToolbar;
    EditText searchMovie;
    ImageButton btnNaviView;
    ScrollView scrollView;
    SHContextMenu shContextMenu;

    // 액티비티 구성 매니저
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MODE_PRIVATE);

        // 위젯 연결
        this.bind();

        //Toolbar 설정 호출
        this.actionBarSetting();

        //메뉴 아이템 추가
        this.addShcontextMenu();

        //액티비티 화면 구성 매니저 생성

        Controller.setHomeSettingManager(new HomeSettingManager(MainActivity.this));
        Controller.setProfileSettingManager(new ProfileSettingManager(MainActivity.this));
        Controller.setArchiveSettingManager(new ArchiveSettingManager(MainActivity.this));
        Controller.setReviewSettingManager(new ReviewSettingManager(MainActivity.this));
        Controller.setTabSettingManager(new TabSettingManager(MainActivity.this));
        Controller.setLoginSettingManager(new LoginSettingManager(MainActivity.this));
        Controller.setSignUpSettingManager(new SignUpSettingManager(MainActivity.this));
        Controller.setJoinSettingManager(new JoinSettingManager(MainActivity.this));
        Controller.setProfileEditSettingManager(new ProfileEditSettingManager(MainActivity.this));
        Controller.setEventSettingManager(new EventSettingManager(MainActivity.this));

        Controller.setSettingManager();
        Controller.allSettingManagerInitAndsetEvent();
        Controller.setDrawerSettingManager(new DrawerSettingManager(MainActivity.this, Controller.getTabSettingManager().getTabHost()));
        Controller.initAndEventDrawerSettingManager();

        new EventManager();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == PICK_FROM_ALBUM && resultCode == RESULT_OK) {
            Controller.getProfileEditSettingManager().getProfileEditIvProfileImage().setImageURI(data.getData());
            Controller.getUserInfo().setProfileImageUri(data.getData().toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu,menu);
        return true ;
    }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        shContextMenu.showMenu();
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    private void bind() {
        myToolbar=(Toolbar) findViewById(R.id.toolbar);
        btnNaviView = (ImageButton)findViewById(R.id.btnNaviView);
        searchMovie=(EditText)findViewById(R.id.mainHeaderSearch);
        scrollView =(ScrollView)findViewById(R.id.contentScroll);
        Controller.setScrollView(scrollView);
        Controller.setContext(this);
        new KinoDBHelperFactory(MainActivity.this);
        Controller.insertMovieContent();
    }
    private void actionBarSetting() {
        /*
              myToolbar : 메인 액티비티 액션바
              btnNaviView : 네비게이션 드로어 오픈 버튼
         */
        //Toolbar 설정
        myToolbar.setTitle("");
        setSupportActionBar(myToolbar);//기본 액션바로 설정.
        // 네비게이션 드로어 오픈
        btnNaviView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.getDrawerSettingManager().getDrawerLayout().openDrawer(GravityCompat.START);
            }
        });
    }

    //menu_item 추가 메소드
    private void addShcontextMenu() {
        shContextMenu = new SHContextMenu(this);
        List<NewsItemDTO> itemList = new ArrayList<>();
        itemList.add(new NewsItemDTO(getResources().getDrawable(R.drawable.ic_launcher), "성결라이츠 회원분들만 참여하는 단관 GV 시사회 이벤트에 초대합니다!",3));
        itemList.add(new NewsItemDTO(getResources().getDrawable(R.drawable.ic_launcher), "성결라이츠 회원만 참석하는 단관 시사회 이벤트!!",4));
        itemList.add(new NewsItemDTO(getResources().getDrawable(R.drawable.ic_launcher), "<노리개:그녀의 눈물> 게릴라 시사회에 회원분들을 초대합니다.!",2));

        shContextMenu.setItemList(itemList);
        shContextMenu.setOnItemSelectListener(new SHContextMenu.OnItemSelectListener() {
            @Override
            public void onItemSelect(int position) {
                Toast.makeText(MainActivity.this, position + "", Toast.LENGTH_SHORT).show();
            }

        });
    }
    private class EventManager {
        EventManager() {
            searchMovie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intetnt = new Intent(getApplicationContext(), SearchActivity.class);
                    startActivity(intetnt);
                }});
        }

    }

}
