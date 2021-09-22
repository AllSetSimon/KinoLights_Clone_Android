package dongdang.androind.kinolights.view.manager;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;
import dongdang.androind.kinolights.view.MainActivity;

public class JoinSettingManager implements SettingManager{
    AppCompatActivity context;

    LinearLayout joinLayout;
    EditText edtID;
    EditText edtPassword, edtPasswordOk;
    TextView tvPasswordChk;
    EditText edtName;
    CheckBox cbInfo, cbTerms;
    Button btnJoin;
    boolean passwordFlag;
    public JoinSettingManager(AppCompatActivity context) {
        this.context = context;
    }

    public void init() {
        joinLayout = (LinearLayout)context.findViewById(R.id.joinActivityLayout);
        Controller.addLayout(new TabHostItemVO("join","회원가입",joinLayout));
        edtID = (EditText)context.findViewById(R.id.joinEdtEmail);
        edtPassword = (EditText)context.findViewById(R.id.joinEdtPWD);
        edtPasswordOk = (EditText)context.findViewById(R.id.joinEdtPWDOK);
        tvPasswordChk = (TextView)context.findViewById(R.id.joinTvPwdCheck);
        edtName = (EditText)context.findViewById(R.id.joinEdtName);
        cbInfo = (CheckBox)context.findViewById(R.id.cbInfo);
        cbTerms = (CheckBox)context.findViewById(R.id.cbTerms);
        btnJoin = (Button)context.findViewById(R.id.joinBtnRegi);


    }

    public void setEvent() {
        edtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                edtPasswordOk.setText("");
                passwordFlag=false;
                if(edtPassword.getText().toString().length()<8 ) {
                    tvPasswordChk.setText("비밀번호는 8자리이상이어야합니다!");
                    tvPasswordChk.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        edtPasswordOk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edtPasswordOk.getText().toString().length()<7 ) {
                    passwordFlag=false;
                    tvPasswordChk.setText("비밀번호는 8자리이상이어야합니다!");
                    tvPasswordChk.setVisibility(View.VISIBLE);
                    return;
                }else {
                    tvPasswordChk.setVisibility(View.GONE);
                }

                if(edtPassword.getText().toString().equals(edtPasswordOk.getText().toString())) {
                    passwordFlag=true;
                    tvPasswordChk.setText("비밀번호가 일치합니다.");
                    tvPasswordChk.setVisibility(View.VISIBLE);
                }else {
                    passwordFlag=false;
                    tvPasswordChk.setText("비밀번호가 일치하지 않습니다.");
                    tvPasswordChk.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
        btnJoin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!passwordFlag || !cbInfo.isChecked() || !cbTerms.isChecked()) {
                    Toast.makeText(context,"양식을 갖춰주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean flag = Controller.requestForJoin(edtID.getText().toString().trim(),edtPassword.getText().toString().trim(),
                        edtName.getText().toString().trim());

                if(flag){
                    Toast.makeText(context,"회원가입 성공!",Toast.LENGTH_SHORT).show();
                    Controller.setVisibleTabHostLayout("profile");
                }else {
                    Toast.makeText(context,"회원가입 실패!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
