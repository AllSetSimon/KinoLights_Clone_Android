package dongdang.androind.kinolights.model.bl;


import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.beardedhen.androidbootstrap.BootstrapButton;

import java.util.ArrayList;
import java.util.Iterator;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.controller.Controller;
import dongdang.androind.kinolights.model.vo.FaqItemVO;
import dongdang.androind.kinolights.model.vo.NaviMenuVO;
import dongdang.androind.kinolights.model.vo.ProfileItemVO;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;
import dongdang.androind.kinolights.util.ArchiveAdapter;
import dongdang.androind.kinolights.util.FaqRecyclerViewAdapter;
import dongdang.androind.kinolights.util.MovieSimpleInfoAdapter;
import dongdang.androind.kinolights.util.ReviewAdapter;
import dongdang.androind.kinolights.view.MainActivity;
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

public class ViewManageService {

    private static ArrayList<TabHostItemVO> tabHostItemVOS = new ArrayList<>();
    private static ArrayList<TabHostItemVO> archiveFilterItemVOS = new ArrayList<>();
    private static ArrayList<NaviMenuVO> naviMenu1Data = new ArrayList<NaviMenuVO>();
    private static ArrayList<NaviMenuVO> naviMenu3Data = new ArrayList<NaviMenuVO>();
    private static ArrayList<String> naviMenu2Data=new ArrayList<String>();
    private static ArrayList<ProfileItemVO> profileItemVOS = new ArrayList<>();
    private static ArrayList<FaqItemVO> faqList = new ArrayList<>();
    private static Context context = null;
    private static DrawerLayout drawerLayout = null;
    private static ScrollView scrollView = null;

    private static DrawerSettingManager drawerSettingManager;
    private static HomeSettingManager homeSettingManager;
    private static ProfileSettingManager profileSettingManager;
    private static ArchiveSettingManager archiveSettingManager;
    private static ReviewSettingManager reviewSettingManager;
    private static TabSettingManager tabSettingManager;
    private static LoginSettingManager loginSettingManager;
    private static SignUpSettingManager signUpSettingManager;
    private static JoinSettingManager joinSettingManager;
    private static ProfileEditSettingManager profileEditSettingManager;
    private static EventSettingManager eventSettingManager;

    private static SettingManager[] settingManager;
    //SettingMnager;

    public static void setDrawerSettingManager(DrawerSettingManager drawerSettingManager) {
        ViewManageService.drawerSettingManager = drawerSettingManager;
    }

    public static void setHomeSettingManager(HomeSettingManager homeSettingManager) {
        ViewManageService.homeSettingManager = homeSettingManager;
    }

    public static void setProfileSettingManager(ProfileSettingManager profileSettingManager) {
        ViewManageService.profileSettingManager = profileSettingManager;
    }

    public static void setArchiveSettingManager(ArchiveSettingManager archiveSettingManager) {
        ViewManageService.archiveSettingManager = archiveSettingManager;
    }

    public static void setReviewSettingManager(ReviewSettingManager reviewSettingManager) {
        ViewManageService.reviewSettingManager = reviewSettingManager;
    }

    public static void setTabSettingManager(TabSettingManager tabSettingManager) {
        ViewManageService.tabSettingManager = tabSettingManager;
    }

    public static void setLoginSettingManager(LoginSettingManager loginSettingManager) {
        ViewManageService.loginSettingManager = loginSettingManager;
    }

    public static void setSignUpSettingManager(SignUpSettingManager signUpSettingManager) {
        ViewManageService.signUpSettingManager = signUpSettingManager;
    }

    public static void setJoinSettingManager(JoinSettingManager joinSettingManager) {
        ViewManageService.joinSettingManager = joinSettingManager;
    }

    public static void setProfileEditSettingManager(ProfileEditSettingManager profileEditSettingManager) {
        ViewManageService.profileEditSettingManager = profileEditSettingManager;
    }

    public static void setEventSettingManager(EventSettingManager eventSettingManager) {
        ViewManageService.eventSettingManager = eventSettingManager;
    }

    public static EventSettingManager getEventSettingManager() {
        return eventSettingManager;
    }
    public static ProfileEditSettingManager getProfileEditSettingManager() {
        return profileEditSettingManager;
    }
    public static TabSettingManager getTabSettingManager() {
        return tabSettingManager;
    }
    public static ProfileSettingManager getProfileSettingManager() {
        return profileSettingManager;
    }
    public static DrawerSettingManager getDrawerSettingManager() {
        return drawerSettingManager;
    }
    public static void initAndEventDrawerSettingManager() {
        drawerSettingManager.init();
        drawerSettingManager.setEvent();
    }
    public static void setSettingManager() {
        settingManager = new SettingManager[]{
                homeSettingManager,profileSettingManager,loginSettingManager,
                archiveSettingManager,reviewSettingManager,tabSettingManager,
                signUpSettingManager,joinSettingManager,profileEditSettingManager,
                eventSettingManager
        };
    }
    public static void allSettingManagerInitAndsetEvent() {
        for(SettingManager manager:settingManager) {
            manager.init();manager.setEvent();
        }
    }
    //TabHost
    public static void setScrollView(ScrollView s) {
        scrollView = s;
    }
    public static void setContext(Context c) {
        context = c;
    }
    public static boolean addLayout(TabHostItemVO itemVO) {
        return tabHostItemVOS.add(itemVO);
    }

    public static void allLayoutGone() {
        for(TabHostItemVO itemVO : tabHostItemVOS)
            itemVO.getLinearLayout().setVisibility(View.GONE);
    }

    public static TabHostItemVO searchByTag(String tag) {
        for(TabHostItemVO vo : tabHostItemVOS)
            if(vo.getTag().equals(tag)) return vo;
        return null;
    }

    public static void setVisibleTabHostLayout(String tag) {
        allLayoutGone();
        if(tag.equals("profile"))
            if (!UserService.loginCheck()) {
                tag="login";
            }
        if(tag.equals("archive")) {
            archiveSettingManager.getArchiveGridView().setAdapter(Controller.getArchiveAdapter(MovieService.all));
        }
        searchByTag(tag).getLinearLayout().setVisibility(View.VISIBLE);
        scrollView.scrollTo(0,0);
        scrollView.smoothScrollTo(0,0);
        scrollView.invalidate();
    }

    //ArchiveTabHost

    public static boolean addArchiveFilterLayout(TabHostItemVO itemVO) {
        return archiveFilterItemVOS.add(itemVO);
    }

    public static void allArchiveFilterLayoutGone() {
        for(TabHostItemVO itemVO : archiveFilterItemVOS)
            itemVO.getLinearLayout().setVisibility(View.GONE);
    }

    public static TabHostItemVO searchByArchiveFilterTag(String tag) {
        for(TabHostItemVO archiveFilterItemVO : archiveFilterItemVOS)
            if(archiveFilterItemVO.getTag().equals(tag)) return archiveFilterItemVO;
        return null;
    }

    public static void setVisibleArchiveFilterLayout(String tag) {
        allArchiveFilterLayoutGone();
        if(tag.equals("profile")) {
            if(!UserService.loginCheck()) {
                searchByArchiveFilterTag("login").getLinearLayout().setVisibility(View.VISIBLE);
                return;
            }
        }
        searchByArchiveFilterTag(tag).getLinearLayout().setVisibility(View.VISIBLE);
    }

    //profile
    public static void connectButtonToContent(Button button, LinearLayout linearLayout) {
        profileItemVOS.add(new ProfileItemVO(linearLayout,button,button.getText().toString()));
    }
    public static ProfileItemVO searchByProfileButtonTag(String tag) {
        for(ProfileItemVO p:profileItemVOS) if(p.getTag().equals(tag)) return p;
        return null;
    }
    public static void setVisibleProfileContent(int id) {
       for(ProfileItemVO vo : profileItemVOS) {
           if(vo.getButton().getId() == id) {
                vo.getButton().setBackgroundColor(Color.rgb(0x43,0x74,0xD9));
               vo.getContent().setVisibility(View.VISIBLE);
           }else {
               vo.getButton().setBackgroundColor(Color.argb(0,0x43,0x74,0xD9));
               vo.getContent().setVisibility(View.GONE);
           }
       }
    }


    //NavigationView
    public static void navigationViewDataSetup(TabHost tabHost, DrawerLayout drawerLayout) {
        naviMenu1Data.clear();naviMenu2Data.clear();naviMenu3Data.clear();
        initNaviMenu1Data(tabHost,drawerLayout);
        initNaviMenu2Data();
        initNaviMenu3Data(drawerLayout);
    }
    private static void initNaviMenu1Data(final TabHost tabHost,final DrawerLayout drawerLayout) {
        Integer[] naviMenu1DataId= {R.drawable.profile24,R.string.naviProfile,R.drawable.menu_arrow};
        NaviMenuVO temp = new NaviMenuVO(naviMenu1DataId[0],context.getResources().getString(naviMenu1DataId[1]),naviMenu1DataId[2]);
        temp.setEvent(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller.setVisibleTabHostLayout("profile");
                tabHost.setCurrentTab(1);
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        naviMenu1Data.add(temp);
    }

    private static void initNaviMenu2Data() {
        Integer[] naviMenu2DataId= {R.string.profileSummary,R.string.profileKino,
                R.string.profileReview,R.string.profileWish};
        for(int id : naviMenu2DataId) naviMenu2Data.add(context.getResources().getString(id));
    }

    private static void initNaviMenu3Data(final DrawerLayout drawerLayout) {
        Integer[][] naviMenu3DataId= {
                {R.drawable.enquire24px,R.string.naviEnquire,R.drawable.menu_arrow},
                {R.drawable.faq24px,R.string.naviFaq,R.drawable.menu_arrow}
        };
        for(Integer[] i : naviMenu3DataId){
            NaviMenuVO temp = new NaviMenuVO(i[0],context.getResources().getString(i[1]),i[2]);
            temp.setEvent(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String string = ((TextView)v.findViewById(R.id.naviMenutextView)).getText().toString();
                    if(string.equals(context.getResources().getString(R.string.naviEnquire))){
                        View dialogView = (View)View.inflate(context,R.layout.dialog_enquire,null);
                        Button dialogEnquireExitButton = (Button)dialogView.findViewById(R.id.dialogEnquireExitButton);
                        AlertDialog.Builder dlg = new AlertDialog.Builder(context);
                        final AlertDialog alertDialog = dlg.create();
                        alertDialog.setView(dialogView);
                        alertDialog.show();
                        dialogEnquireExitButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });
                    }else if(string.equals(context.getResources().getString(R.string.naviFaq))) {
                        LinearLayout faqLinearLayout = searchByTag("faq").getLinearLayout();

                        setVisibleTabHostLayout("faq");
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        //dao 사용할것.

                        faqList.add(new FaqItemVO("Q.키노라이츠라는 이름은 어떤 뜻이며 무엇을 제공하는 서비스 인가요?","키노라이츠는 독일어로 영화를 뜻하는 키노(Kino)와 본 서비스의 핵심 콘텐츠인 신호등 불빛에서 딴 라이츠(Lights)의 합성어로 영화 전문 평점, 리뷰 플랫폼입니다."));
                        faqList.add(new FaqItemVO("Q.신호등 평가와 별점 평가가 동시에 존재하는 이유와 둘의 차이는 무엇인가요?","신호등의 불빛으로 영화를 평가한다는 방식은 키노라이츠 서비스 만의 차별화된 특징입니다. 대부분의 사용자에게 익숙한 10분위 평점(별점) 체계를 보완, 강화하는 이원화 된 평가 체계로 기존 별점 시스템에 앞서 영화에 대한 관객의 선호도(취향)에 따라, 초록(괜찮아요), 빨강(별로예요)의 평가를 추가했습니다."));

                        faqList.add(new FaqItemVO("Q.등록되지 않은 영화 추가 및 영화 정보 수정은 어떻게 요청할 수 있나요?","완성도 높고 방대한 영화 데이터베이스 구축은 저희 키노라이츠 서비스의 핵심 가치 중 하나입니다. 따라서 아직 등재되지 않은 영화나, 잘못된 정보 수정은 서비스 하단의 '이용문의 및 DB제보'메뉴 또는 영화 상세페이지 우측 상단의 'DB제보'버튼을 통해 언제든지 신청 주시면 확인 후 신속하게 반영해드리겠습니다."));

                        faqList.add(new FaqItemVO("Q.영화 맞춤형 추천 서비스는 무엇이며 어디서 받아볼 수 있나요?","유저 개인이 남긴 평가를 기반으로 맞춤형 영화 추천을 제공하는 키노라이츠 AI 엔진 추천 기능은 서비스 메인화면 또는 상단의 '영화추천' 메뉴를 통해 확인하실 수 있습니다. 데이터 분석에는 자신의 취향을 나타내는 키노라이츠 만의 신호등 평가가 메인으로 사용되며, 해당 유저의 별점 평가를 추가 반영하여 더욱 정교한 영화추천을 제공합니다. 영화를 추천받기 위해서는 최소 30편의 영화 신호등 평가가 필요합니다. 평가가 30편을 초과하게 되면, 서비스 메인에 자동으로 나만의 맞춤형 추천 화면이 나타나게 됩니다."));

                        faqList.add(new FaqItemVO("Q.VOD 최저가 비교 서비스는 무엇이며 어디에서 확인할 수 있나요?","국내 제공되는 합법VOD 업체들의 최저가를 비교하여 합리적인 소비를 도와드리는 키노라이츠 VOD 가격 비교 기능은 현재 영화 상세페이지 내에서 확인하실 수 있습니다."));

                        faqList.add(new FaqItemVO("Q.예전에 본 영화들을 한꺼번에 평가하고 싶어요.","서비스 상단의 '아카이브'메뉴를 이용하시면 연대별/국가별/장르별 필터를 이용하여 아직 평가하지 않은 작품들을 한꺼번에 손쉽게 평가할 수 있습니다. 영화추천 메뉴를 통해 추천받은 영화 중 이미 감상한 작품들을 계속해서 지워나가며 평가를 늘리는 방법도 재미있어요! :)"));

                        faqList.add(new FaqItemVO("Q.비밀번호를 변경하고 싶어요.","로그인한 상태에서 [프로필]-[프로필 편집]버튼을 클릭하시면 새 비밀번호로 기존의 비밀번호를 변경하실 수 있습니다."));

                        faqList.add(new FaqItemVO("Q.비밀번호를 잊어버렸어요.","로그인 메뉴에서 비밀번호 찾기 버튼을 누르시면 가입 시 기재하신 메일로 비밀번호를 재설정 하실 수 있는 인증 메일이 도착합니다."));

                        faqList.add(new FaqItemVO("Q.인증회원 제도는 무엇이며 어떻게 지원할 수 있나요?","키노라이츠는 영화 평가의 조작, 왜곡을 막기 위해 일정한 검증 체계를  거친 회원들이라는 뜻의 '인증회원'제도를 도입하였습니다. 회원 모두가 영화의 평가와 리뷰 작성에 참여할 수 있으나 인증회원들의 평가로만 평점 지수가 집계되며, 추천 수와 관계없이 일반회원보다 인증회원의 리뷰가, 그 중에서도 양질의 리뷰가 우선하여 노출되는 알고리즘을 적용하였습니다."));

                        faqList.add(new FaqItemVO("Q.인증회원은 어떠한 기준으로 선정되나요?","영화를 사랑하는 마니아 회원들에게 주어지는 키노라이츠 인증회원은 1. 충분한 관람 편수, 2. 작성하신 리뷰의 내용, 3. 영화에 대한 자신만의 평가 기준이 명확히 자리 잡혀 있는지의 여부 등을 다각적으로 고려해 선정됩니다."));


                        RecyclerView faqRecyclerView= faqLinearLayout.findViewById(R.id.faqRecyclerView);
                        faqRecyclerView.setAdapter(new FaqRecyclerViewAdapter(faqList));
                        faqRecyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false){
                            public boolean canScrollVertically() { // 세로스크롤 막기
                                return false;
                            }
                        });
                        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
                        faqRecyclerView.measure(0, expandSpec);
                        faqRecyclerView.getLayoutParams().height = faqRecyclerView.getMeasuredHeight()+400;

                    }
                }
            });
            naviMenu3Data.add(temp);
        }

    }

    public static ArrayList<NaviMenuVO> getNaviMenu1Data() {
        return naviMenu1Data;
    }

    public static ArrayList<NaviMenuVO> getNaviMenu3Data() {
        return naviMenu3Data;
    }

    public static ArrayList<String> getNaviMenu2Data() {
        return naviMenu2Data;
    }

    public static void setVisibleNavigationView(View v) {
        View guest = v.findViewById(R.id.naviHeaderGuest);
        View member = v.findViewById(R.id.naviHeader);
        if(UserService.loginCheck()) {
            guest.setVisibility(View.GONE);
            member.setVisibility(View.VISIBLE);
            v.findViewById(R.id.naviMenu2).setVisibility(View.VISIBLE);
        }else {
            guest.setVisibility(View.VISIBLE);
            member.setVisibility(View.GONE);
            v.findViewById(R.id.naviMenu2).setVisibility(View.GONE);
        }
    }
    private static NaviMenuVO searchByTextInNaviMenu3Data(String name) {
        for(NaviMenuVO naviMenuVO : naviMenu3Data)
            if(naviMenuVO.getTextView().toString().equals(name)) return naviMenuVO;
        return null;
    }

    public static void setVisibleFaqItem(LinearLayout linearLayout) {
        for(FaqItemVO faqItemVO : faqList) {
            if(faqItemVO.getHeaderLayout() == linearLayout) {
                if(faqItemVO.getContentLayout().getVisibility() == View.VISIBLE) faqItemVO.getContentLayout().setVisibility(View.GONE);
                else faqItemVO.getContentLayout().setVisibility(View.VISIBLE);
            }
            else faqItemVO.getContentLayout().setVisibility(View.GONE);
        }
    }
    //review
    public static void setVisibleReviewLayout(ViewGroup v, int id) {
        ListView recentReviewListView = (ListView)v.findViewById(R.id.recentReviewListView);
        ListView bestReviewListView = (ListView)v.findViewById(R.id.bestReviewListView);
        BootstrapButton btnRecentReview = (BootstrapButton)v.findViewById(R.id.btnRecentReview);
        BootstrapButton btnBestReview = (BootstrapButton)v.findViewById(R.id.btnBestReview);

        if(id == R.id.btnRecentReview) {
            btnRecentReview.setTextColor(Color.rgb(36,120,255));
            btnBestReview.setTextColor(Color.rgb(255,255,255));
            ReviewService.selectRecentReviewItem(v.getContext(),recentReviewListView);
            recentReviewListView.setVisibility(View.VISIBLE);
            int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
            recentReviewListView.measure(0, expandSpec);
            recentReviewListView.getLayoutParams().height = recentReviewListView.getMeasuredHeight();
            bestReviewListView.setVisibility(View.INVISIBLE);
        }else if(id == R.id.btnBestReview) {
            btnRecentReview.setTextColor(Color.rgb(255,255,255));
            btnBestReview.setTextColor(Color.rgb(36,120,255));
            ReviewService.selectBestReviewItem(v.getContext(),bestReviewListView);
            recentReviewListView.setVisibility(View.INVISIBLE);
            int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
            bestReviewListView.measure(0, expandSpec);
            bestReviewListView.getLayoutParams().height = bestReviewListView.getMeasuredHeight();
            bestReviewListView.setVisibility(View.VISIBLE);
        }
    }

    public static void setVisibleProfileReviewLayout(ViewGroup v, int id) {
        ListView writeReviewListView = (ListView)v.findViewById(R.id.writeReviewListView);
        ListView favoriteReviewListView = (ListView)v.findViewById(R.id.favoriteReviewListView);
        BootstrapButton profileReviewWriteBtn = (BootstrapButton)v.findViewById(R.id.profileReviewWriteBtn);
        BootstrapButton profileReviewFavoriteBtn = (BootstrapButton)v.findViewById(R.id.profileReviewFavoriteBtn);
        TextView textView = (TextView)v.findViewById(R.id.profileReviewMessage);
        ReviewAdapter reviewAdapter = null;
        if(id == R.id.profileReviewWriteBtn) {
            profileReviewWriteBtn.setTextColor(Color.rgb(36,120,255));
            profileReviewFavoriteBtn.setTextColor(Color.rgb(255,255,255));
            reviewAdapter = ReviewService.selectMyWritingReviewItem(v.getContext());
            if(reviewAdapter==null) {
                textView.setText("님이 작성한 리뷰가 없어요.");
                return;
            }
            writeReviewListView.setAdapter(reviewAdapter);
            textView.setVisibility(View.GONE);
            favoriteReviewListView.setVisibility(View.GONE);
            writeReviewListView.setVisibility(View.VISIBLE);
            int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
            writeReviewListView.measure(0, expandSpec);
            writeReviewListView.getLayoutParams().height = writeReviewListView.getMeasuredHeight();

        }else if(id == R.id.profileReviewFavoriteBtn) {
            profileReviewWriteBtn.setTextColor(Color.rgb(255,255,255));
            profileReviewFavoriteBtn.setTextColor(Color.rgb(36,120,255));
            reviewAdapter = ReviewService.selectMyFavoriteReviewItem(v.getContext());
            if(reviewAdapter==null) {
                textView.setText("님이 좋아요한 리뷰가 없어요.");
                return;
            }
            favoriteReviewListView.setAdapter(reviewAdapter);
            textView.setVisibility(View.GONE);
            writeReviewListView.setVisibility(View.INVISIBLE);
            favoriteReviewListView.setVisibility(View.VISIBLE);

            int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
            favoriteReviewListView.measure(0, expandSpec);
            favoriteReviewListView.getLayoutParams().height = favoriteReviewListView.getMeasuredHeight();

        }
    }


}
