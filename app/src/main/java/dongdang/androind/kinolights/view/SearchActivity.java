package dongdang.androind.kinolights.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.util.CustomEditText;
import dongdang.androind.kinolights.util.DrawableClickListener;

public class SearchActivity extends AppCompatActivity {
    Button searchBtnExit;
    CustomEditText searchEdt;
    ListView searchMovieListView;
    TextView requestSearchTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        searchBtnExit = (Button)findViewById(R.id.searchBtnExit);
        searchEdt = (CustomEditText)findViewById(R.id.searchEdt);
        searchMovieListView = (ListView)findViewById(R.id.searchListView);
        requestSearchTextView = (TextView)findViewById(R.id.requestSearchTextView);

        searchBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        searchEdt.setDrawableClickListener(new DrawableClickListener() {
            @Override
            public void onClick(DrawablePosition target) {
                searchEvent();
            }
        });
        searchEdt.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                searchEvent();
                return false;
            }
        });
        searchEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if(searchEdt.getText().equals("")) {
                    requestSearchTextView.setVisibility(View.VISIBLE);
                    searchMovieListView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    searchEvent();
                    requestSearchTextView.setVisibility(View.GONE);
                    searchMovieListView.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(searchEdt.getText().equals("")) {
                    requestSearchTextView.setVisibility(View.VISIBLE);
                    searchMovieListView.setVisibility(View.GONE);
                }
            }
        });
    }

    private void searchEvent() {
        searchMovieListView.setAdapter(Controller.getSearchAdapter(searchEdt.getText().toString()));
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        searchMovieListView.measure(0, expandSpec);
        searchMovieListView.getLayoutParams().height = searchMovieListView.getMeasuredHeight();
    }
}
