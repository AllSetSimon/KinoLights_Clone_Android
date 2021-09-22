package dongdang.androind.kinolights.view.manager;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.beardedhen.androidbootstrap.BootstrapEditText;


import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.bl.UserService;
import dongdang.androind.kinolights.model.vo.MovieSimpleInfoItemDTO;
import dongdang.androind.kinolights.model.vo.ProfileEditBestMovieItemDTO;
import dongdang.androind.kinolights.model.vo.ProfileEditImageManager;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;
import dongdang.androind.kinolights.model.vo.UserDTO;
import dongdang.androind.kinolights.util.CustomEditText;
import dongdang.androind.kinolights.util.DrawableClickListener;
import dongdang.androind.kinolights.util.ProfileEditBestMovieAdapter;
import dongdang.androind.kinolights.view.MainActivity;

public class ProfileEditSettingManager implements SettingManager {
    AppCompatActivity context;
    private CustomEditText searchProfileBestMovie;
    private GridView gridViewprofileBestMovie;
    private int[] imageViewID;
    private ImageView currntImageView;
    private LinearLayout searchLayout;
    private ArrayList<MovieSimpleInfoItemDTO> arrayList;
    private ProfileEditImageManager[] profileEditImageManagers;
    private BootstrapEditText profileEditEdtEmailID;
    private BootstrapCircleThumbnail profileEditIvProfileImage;
    private BootstrapEditText profileEditEdtName;
    private BootstrapButton profileEditRadioMan, profileEditRadioWoman;
    private BootstrapEditText profileEditEdtIntroduce;
    private BootstrapEditText profileEditEdtPwdUpdate, profileEditEdtPwdUpdateChk;
    private BootstrapButton profileEditBtnSubmit;
    public ProfileEditSettingManager(AppCompatActivity context) {
        this.context =context;

    }

    @Override
    public void init() {
        profileEditIvProfileImage = (BootstrapCircleThumbnail)context.findViewById(R.id.profileEditIvProfileImage);
        searchProfileBestMovie = (CustomEditText)context.findViewById(R.id.searchProfileBestMovie);
        gridViewprofileBestMovie = (GridView)context.findViewById(R.id.profileEditGridView);
        profileEditEdtEmailID = (BootstrapEditText)context.findViewById(R.id.profileEditEdtEmailID);
        profileEditEdtName =(BootstrapEditText)context.findViewById(R.id.profileEditEdtName);
        profileEditRadioMan = (BootstrapButton)context.findViewById(R.id.profileEditRadioMan);
        profileEditRadioWoman = (BootstrapButton)context.findViewById(R.id.profileEditRadioWoman);
        profileEditEdtIntroduce = (BootstrapEditText)context.findViewById(R.id.profileEditEdtIntroduce);
        profileEditEdtPwdUpdate = (BootstrapEditText)context.findViewById(R.id.profileEditEdtPwdUpdate);
        profileEditEdtPwdUpdateChk = (BootstrapEditText)context.findViewById(R.id.profileEditEdtPwdUpdateChk);
        profileEditBtnSubmit = (BootstrapButton)context.findViewById(R.id.profileEditBtnSubmit);
        imageViewID = new int[] {R.id.profileEditBestMovieImage1,R.id.profileEditBestMovieImage2,R.id.profileEditBestMovieImage3,
                R.id.profileEditBestMovieImage4,R.id.profileEditBestMovieImage5};

        Controller.addLayout(new TabHostItemVO("profileEdit","프로필 편집",(LinearLayout)context.findViewById(R.id.profileEditActivityLayout)));

    }

    public void profileEditDataLoading() {
        UserDTO user = Controller.getUserInfo();
        profileEditEdtEmailID.setText(user.getId());
        profileEditEdtName.setText(user.getName());

        if(user.getSex() == UserService.USER_MAN) {
            profileEditRadioWoman.setSelected(false);
            profileEditRadioMan.setSelected(true);
        }
        else if(user.getSex() == UserService.USER_WOMAN) {
            profileEditRadioWoman.setSelected(true);
            profileEditRadioMan.setSelected(false);
        }
        if(!user.getIntroduce().equals(""))
            profileEditEdtIntroduce.setText(user.getIntroduce());
        if(!user.getProfileImageUri().equals(""))
            profileEditIvProfileImage.setImageURI(Uri.parse(user.getProfileImageUri()));

        profileEditEdtPwdUpdate.setText("");

        for(int i=0; i<imageViewID.length; i++) {
            ImageView v = context.findViewById(imageViewID[i]);
            v.setImageResource(R.drawable.imageview_add);
            v.setScaleType(ImageView.ScaleType.CENTER);
        }
        profileEditImageManagers = new ProfileEditImageManager[imageViewID.length];
        for(int i=0; i<profileEditImageManagers.length; i++) profileEditImageManagers[i] = new ProfileEditImageManager();


        for (int i=0; i<imageViewID.length; i++) {
            final int index = i;
            profileEditImageManagers[i].setImageView((ImageView)context.findViewById(imageViewID[i]));
            profileEditImageManagers[i].getImageView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currntImageView = (ImageView)v;
                    searchLayout = (LinearLayout)(context.findViewById(R.id.profileEditSearchLayout));
                    searchLayout.setVisibility(View.VISIBLE);
                    ((ScrollView)context.findViewById(R.id.contentScroll)).fullScroll(ScrollView.FOCUS_DOWN);
                    ((ScrollView)context.findViewById(R.id.contentScroll)).invalidate();
                }
            });
            profileEditImageManagers[i].getImageView().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    profileEditImageManagers[index].getDto().setName(null);
                    profileEditImageManagers[index].setImageView(null);
                    ((ImageView)v).setImageResource(R.drawable.imageview_add);
                    ((ImageView)v).setScaleType(ImageView.ScaleType.CENTER);
                    return false;
                }
            });
        }
        if((arrayList = Controller.getBestMoiveList())!=null) {
            for(int i=0;i<arrayList.size(); i++) {
                profileEditImageManagers[i].setDto(new ProfileEditBestMovieItemDTO());
                profileEditImageManagers[i].getDto().setName(arrayList.get(i).getName().toString());
                profileEditImageManagers[i].getImageView().setImageResource(arrayList.get(i).getImage());
                profileEditImageManagers[i].getImageView().setScaleType(ImageView.ScaleType.CENTER);
                profileEditImageManagers[i].getImageView().setAdjustViewBounds(true);
            }
        }
    }

    public BootstrapCircleThumbnail getProfileEditIvProfileImage() {
        return profileEditIvProfileImage;
    }

    @Override
    public void setEvent() {
        profileEditIvProfileImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                context.startActivityForResult(intent, MainActivity.PICK_FROM_ALBUM);
            }
        });

        searchProfileBestMovie.setDrawableClickListener(new DrawableClickListener() {
            @Override
            public void onClick(DrawablePosition target) {
                searchEvent(searchProfileBestMovie.getText().toString());
            }
        });
        searchProfileBestMovie.setOnEditorActionListener(new EditText.OnEditorActionListener(){
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
               searchEvent(searchProfileBestMovie.getText().toString());
               return false;
            }
        });

        gridViewprofileBestMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currntImageView == null) return;
                if(searchLayout == null) return;
                for(ProfileEditImageManager m : profileEditImageManagers) {
                    if(m.getImageView() == currntImageView) {
                        if(m.getDto()==null) m.setDto(new ProfileEditBestMovieItemDTO());
                        m.getDto().setName(((TextView) view.findViewById(R.id.nameProfileEditBestMovie)).getText().toString());
                    }
                }
                Drawable drawable = ((ImageView)view.findViewById(R.id.imageProfileEditBestMovie)).getDrawable();
                currntImageView.setImageDrawable(drawable);
                currntImageView.setAdjustViewBounds(true);
                searchLayout.setVisibility(View.GONE);
                searchProfileBestMovie.setText("");
                gridViewprofileBestMovie.setAdapter(null);
                int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
                gridViewprofileBestMovie.measure(0, expandSpec);
                gridViewprofileBestMovie.getLayoutParams().height = gridViewprofileBestMovie.getMeasuredHeight();
            }
        });


        profileEditBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDTO userDTO = Controller.getUserInfo();
                userDTO.setName(profileEditEdtName.getText().toString());

                if(profileEditRadioMan.isSelected()) userDTO.setSex(UserService.USER_MAN);
                else if(profileEditRadioWoman.isSelected()) userDTO.setSex(UserService.USER_WOMAN);
                if(!profileEditEdtPwdUpdate.getText().toString().equals(""))
                    userDTO.setPwd(profileEditEdtPwdUpdate.getText().toString());
                if(!profileEditEdtIntroduce.getText().toString().equals(""))
                    userDTO.setIntroduce(profileEditEdtIntroduce.getText().toString());
                Controller.insertBestMovie(profileEditImageManagers);
                if(Controller.updateUserInfo()) {
                    Controller.getProfileSettingManager().profileDataLoading();
                    Controller.setVisibleTabHostLayout("profile");
                }else
                    Toast.makeText(context,"수정실패!!",Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void searchEvent(String title) {
        gridViewprofileBestMovie.setAdapter(Controller.getSearchBestMovieAdapter(title));
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        gridViewprofileBestMovie.measure(0, expandSpec);
        gridViewprofileBestMovie.getLayoutParams().height = gridViewprofileBestMovie.getMeasuredHeight();
    }

}