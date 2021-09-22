package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;

public class SignUpSettingManager implements SettingManager{
    AppCompatActivity context;
    LinearLayout signUpLayout;
    BootstrapButton bbSignUp;

    public SignUpSettingManager(AppCompatActivity context) {
        this.context = context;
    }
    public void init() {
        signUpLayout = (LinearLayout)context.findViewById(R.id.signUpActivityLayout);
        Controller.addLayout(new TabHostItemVO("signUp","회원가입방법",signUpLayout));
        bbSignUp = signUpLayout.findViewById(R.id.signUpActivitySignUp);

    }
    public void setEvent() {
        bbSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.setVisibleTabHostLayout("join");
            }
        });
    }
}