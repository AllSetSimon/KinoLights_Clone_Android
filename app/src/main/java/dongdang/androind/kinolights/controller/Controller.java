package dongdang.androind.kinolights.controller;


import android.app.Activity;
import android.content.Context;
import android.graphics.Movie;
import android.media.midi.MidiOutputPort;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TabHost;

import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

import dongdang.androind.kinolights.model.bl.EventService;
import dongdang.androind.kinolights.model.bl.MovieService;
import dongdang.androind.kinolights.model.bl.ReviewService;
import dongdang.androind.kinolights.model.bl.UserService;
import dongdang.androind.kinolights.model.bl.ViewManageService;
import dongdang.androind.kinolights.model.vo.MovieSimpleInfoItemDTO;
import dongdang.androind.kinolights.model.vo.NaviMenuVO;
import dongdang.androind.kinolights.model.vo.ProfileEditImageManager;
import dongdang.androind.kinolights.model.vo.ProfileItemVO;
import dongdang.androind.kinolights.model.vo.TabHostItemVO;
import dongdang.androind.kinolights.model.vo.UserDTO;
import dongdang.androind.kinolights.util.ArchiveAdapter;
import dongdang.androind.kinolights.util.BestMovieAdapter;
import dongdang.androind.kinolights.util.EventAdapter;
import dongdang.androind.kinolights.util.EventOverdueAdapter;
import dongdang.androind.kinolights.util.KinoDBHelper;
import dongdang.androind.kinolights.util.MovieSimpleInfoAdapter;
import dongdang.androind.kinolights.util.PageIndicatorAdapter;
import dongdang.androind.kinolights.util.ProfileEditBestMovieAdapter;
import dongdang.androind.kinolights.util.ProfileKinoAdapter;
import dongdang.androind.kinolights.util.ProfileWishAdapter;
import dongdang.androind.kinolights.util.ReviewAdapter;
import dongdang.androind.kinolights.util.SearchAdapter;
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

public class Controller {

    //ViewManageService

        //settingManager
    public static void setDrawerSettingManager(DrawerSettingManager drawerSettingManager) {
            ViewManageService.setDrawerSettingManager(drawerSettingManager);
    }

    public static void setHomeSettingManager(HomeSettingManager homeSettingManager) {
        ViewManageService.setHomeSettingManager(homeSettingManager);
    }

    public static void setProfileSettingManager(ProfileSettingManager profileSettingManager) {
        ViewManageService.setProfileSettingManager(profileSettingManager);
    }

    public static void setArchiveSettingManager(ArchiveSettingManager archiveSettingManager) {
        ViewManageService.setArchiveSettingManager(archiveSettingManager);
    }

    public static void setReviewSettingManager(ReviewSettingManager reviewSettingManager) {
        ViewManageService.setReviewSettingManager(reviewSettingManager);
    }

    public static void setTabSettingManager(TabSettingManager tabSettingManager) {
        ViewManageService.setTabSettingManager(tabSettingManager);
    }

    public static void setLoginSettingManager(LoginSettingManager loginSettingManager) {
        ViewManageService.setLoginSettingManager(loginSettingManager);
    }

    public static void setSignUpSettingManager(SignUpSettingManager signUpSettingManager) {
        ViewManageService.setSignUpSettingManager(signUpSettingManager);
    }

    public static void setJoinSettingManager(JoinSettingManager joinSettingManager) {
        ViewManageService.setJoinSettingManager(joinSettingManager);
    }

    public static void setProfileEditSettingManager(ProfileEditSettingManager profileEditSettingManager) {
        ViewManageService.setProfileEditSettingManager(profileEditSettingManager);
    }

    public static void setEventSettingManager(EventSettingManager eventSettingManager) {
        ViewManageService.setEventSettingManager(eventSettingManager);
    }
    public static void initAndEventDrawerSettingManager() {
       ViewManageService.initAndEventDrawerSettingManager();
    }
    public static void setSettingManager() {
        ViewManageService.setSettingManager();
    }
    public static void allSettingManagerInitAndsetEvent() {
        ViewManageService.allSettingManagerInitAndsetEvent();
    }
    public static TabSettingManager getTabSettingManager() {
        return ViewManageService.getTabSettingManager();
    }
    public static DrawerSettingManager getDrawerSettingManager() {
        return ViewManageService.getDrawerSettingManager();
    }
    public static ProfileSettingManager getProfileSettingManager() {
        return ViewManageService.getProfileSettingManager();
    }
    public static EventSettingManager getEventSettingManager() {
        return ViewManageService.getEventSettingManager();
    }
    public static ProfileEditSettingManager getProfileEditSettingManager() {
        return ViewManageService.getProfileEditSettingManager();
    }
    //TabHost
    public static boolean addLayout(TabHostItemVO itemVO) { return ViewManageService.addLayout(itemVO); }
    public static void setVisibleTabHostLayout(String tag) { ViewManageService.setVisibleTabHostLayout(tag);    }
    public static TabHostItemVO searchByTag(String tag) { return  ViewManageService.searchByTag(tag); }

    //ArchiveTabHost
    public static boolean addArchiveFilterLayout(TabHostItemVO itemVO) {
        return ViewManageService.addArchiveFilterLayout(itemVO);
    }
    public static TabHostItemVO searchByArchiveFilterTag(String tag) {
        return  ViewManageService.searchByArchiveFilterTag(tag);
    }
    public static void setVisibleArchiveFilterLayout(String tag) {
        ViewManageService.setVisibleArchiveFilterLayout(tag);
    }

    public static ArchiveAdapter getArchiveAdapter(int flag) {
        return MovieService.getArchiveAdapter(flag);
    }
    public static void setScrollView(ScrollView scrollView) {
        ViewManageService.setScrollView(scrollView);
    }
    public static void setContext(Context context) {
        ViewManageService.setContext(context);
    }

//profile
    public static void connectButtonToContent(Button button, LinearLayout linearLayout) {
        ViewManageService.connectButtonToContent(button,linearLayout);
    }
    public static void setVisibleProfileContent(int id) {
        ViewManageService.setVisibleProfileContent(id);
    }
    public static ProfileItemVO searchByProfileButtonTag(String tag) {
        return ViewManageService.searchByProfileButtonTag(tag);
    }
    public static void setVisibleReviewLayout(ViewGroup v, int id) {
        ViewManageService.setVisibleReviewLayout(v,id);
    }
    public static void setVisibleProfileReviewLayout(ViewGroup v, int id) {
        ViewManageService.setVisibleProfileReviewLayout(v,id);
    }

    public static ProfileKinoAdapter getProfileKinoAdapter() {
        return MovieService.getProfileKinoAdapter();
    }

    public static ProfileWishAdapter profileWishAdapter() {
        return MovieService.getProfileWishAdapter();
    }

//profileEdit
    public static ProfileEditBestMovieAdapter getSearchBestMovieAdapter(String name) {
        return MovieService.getSearchBestMovieAdapter(name);
    }

//review
    public static PageIndicatorAdapter selectThisweekReviewItem(ViewGroup parent) {
        return ReviewService.selectThisweekReviewItem(parent);
    }
    public static ReviewAdapter selectMyBestReviewItem(Context context, ListView listView) {
        return ReviewService.selectMyBestReviewItem(context,listView);
    }
    public static ReviewAdapter selectMyRecentReviewItem(Context context, ListView listView) {
        return ReviewService.selectMyRecentReviewItem(context,listView);
    }

//NavigationView
    public static void navigationViewDataSetup(TabHost tabHost, DrawerLayout drawerLayout) {
        ViewManageService.navigationViewDataSetup(tabHost,drawerLayout);
    }

    public static ArrayList<NaviMenuVO> getNaviMenu1Data() {
        return ViewManageService.getNaviMenu1Data();
    }

    public static ArrayList<NaviMenuVO> getNaviMenu3Data() {
        return ViewManageService.getNaviMenu3Data();
    }

    public static ArrayList<String> getNaviMenu2Data() {
        return ViewManageService.getNaviMenu2Data();
    }
    public static void setVisibleNavigationView(View v) {
        ViewManageService.setVisibleNavigationView(v);
    }

//MovieService
    public static MovieSimpleInfoAdapter getCurrentScrreningAdapter() {
        return MovieService.getCurrentScrreningAdapter();
    }
    public static MovieSimpleInfoAdapter getdueForReleaseAdapter() {
        return MovieService.getdueForReleaseAdapter();
    }
    public static void insertMovieContent(){
        MovieService.insertMovieContent();
    }
    public static void insertCurrentMovieContent(){
        MovieService.insertCurrentMovieContent();
    }
    public static void insertDueForContent(){
        MovieService.insertDueForMovieContent();
    }
    public static SearchAdapter getSearchAdapter(String title) {
        return MovieService.getSearchAdapter(title);
    }

    public static ArrayList<MovieSimpleInfoItemDTO> getBestMoiveList() {
        return MovieService.getBestMoiveList();
    }
    public static BestMovieAdapter getBestMovieAdapter() {
        return MovieService.getBestMovieAdapter();
    }
    public static void insertBestMovie(ProfileEditImageManager[] managers) {
        MovieService.insertBestMovie(managers);
    }
//DataLoading
    public static UserDTO getUserInfo() {
        return UserService.getUserInfo();
    }

//UserService

    public static boolean requestForLogin(String id, String pwd) {
        return UserService.requestForLogin(id,pwd);
    }
    public static boolean requestForJoin(String id, String pwd,String name){
        return UserService.requestForJoin(id,pwd,name);
    }
    public static boolean updateUserInfo(){
        return UserService.updateUserInfo();
    }
    public static void requestForLogout() {
        UserService.requestForLogout();
    }
    public static boolean loginCheck() {
        return UserService.loginCheck();
    }

//EventService

    public static void insertEventProceedContent() {
         EventService.insertEventProceedContent();
    }
    public static void insertEventOverdueContent() {
        EventService.insertEventOverdueContent();
    }
    public static EventAdapter selectEventProceedContentAll(Context context) {
        return EventService.selectEventProceedContentAll(context);
    }
    public static EventOverdueAdapter selectEventOverDueContentAll(Context context) {
        return EventService.selectEventOverDueContentAll(context);
    }
}
