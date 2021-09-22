package dongdang.androind.kinolights.view.manager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;

public class LoginSettingManager implements SettingManager {
   AppCompatActivity context;

    LinearLayout loginLayout;
    BootstrapEditText loginEdtID, loginEdtPwd;
    BootstrapButton bbLogin,bbSignUp;

    public LoginSettingManager(AppCompatActivity context) {
        this.context = context;
    }
    @Override
    public void init() {
        loginLayout = (LinearLayout)context.findViewById(R.id.loginActivityLayout);
        Controller.addLayout(new TabHostItemVO("login","로그인",loginLayout));
        loginEdtID = (BootstrapEditText)context.findViewById(R.id.loginEdtID);
        loginEdtPwd = (BootstrapEditText)context.findViewById(R.id.loginEdtPwd);
        bbLogin = loginLayout.findViewById(R.id.loginActivityLogin);
    }

    @Override
    public void setEvent() {
        bbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = Controller.requestForLogin(loginEdtID.getText().toString().trim(),loginEdtPwd.getText().toString().trim());
                if(flag) {
                    Controller.getProfileSettingManager().profileDataLoading();
                    Controller.getDrawerSettingManager().drawerDataLoading();
                    Controller.setVisibleTabHostLayout("profile");
                    Controller.setVisibleNavigationView(context.findViewById(R.id.navigationView));
                    Toast.makeText(context,"로그인 성공!!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context,"로그인 실패!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        bbSignUp = loginLayout.findViewById(R.id.loginActivitySignUp);
        bbSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.setVisibleTabHostLayout("signUp");
            }
        });
    }
}