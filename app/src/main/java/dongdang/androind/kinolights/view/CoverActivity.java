package dongdang.androind.kinolights.view;

import android.content.Intent;
import android.os.Handler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import dongdang.androind.kinolights.R;

public class CoverActivity extends AppCompatActivity {
    /**
     *  CoverImage를  1초 띄우고 메인화면을 전환.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover);

        //시간지역 메소드
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                //딜레이 후 시작할 작업들을 입력

                Intent intetnt = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intetnt);
            }
        }, 1000);
    }
}
