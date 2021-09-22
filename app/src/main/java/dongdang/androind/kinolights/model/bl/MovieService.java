package dongdang.androind.kinolights.model.bl;




import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.dao.MovieDao;
import dongdang.androind.kinolights.model.dao.MovieScoreDao;
import dongdang.androind.kinolights.model.vo.ArchiveMovieInfoDTO;
import dongdang.androind.kinolights.model.vo.MovieSimpleInfoItemDTO;
import dongdang.androind.kinolights.model.vo.ProfileEditBestMovieItemDTO;

import dongdang.androind.kinolights.model.vo.ProfileEditImageManager;
import dongdang.androind.kinolights.model.vo.ProfileKinoInfoDTO;
import dongdang.androind.kinolights.util.ArchiveAdapter;
import dongdang.androind.kinolights.util.BestMovieAdapter;
import dongdang.androind.kinolights.util.MovieSimpleInfoAdapter;
import dongdang.androind.kinolights.util.ProfileEditBestMovieAdapter;
import dongdang.androind.kinolights.util.ProfileKinoAdapter;
import dongdang.androind.kinolights.util.ProfileWishAdapter;
import dongdang.androind.kinolights.util.SearchAdapter;
import dongdang.androind.kinolights.view.manager.ProfileEditSettingManager;


public class MovieService {
    public static final int all = 1;
    private static MovieDao movieDao = new MovieDao();
    private static MovieScoreDao movieScoreDao = new MovieScoreDao();
    public static void insertMovieContent() {
        movieDao.initMovieContent();

        movieDao.insertMovieContent("라라랜드", "드라마","2016","미국",R.drawable.movie1, 97.43, 4.39);
        movieDao.insertMovieContent("베테랑"," 드라마","2014", "한국",R.drawable.movie2, 93.36, 3.47);
        movieDao.insertMovieContent("어벤져스:인피니티 워", "액션","2018","미국", R.drawable.movie3,94.09, 3.87);
        movieDao.insertMovieContent("신과함께-죄와 벌", "드라마", "2017","한국",R.drawable.movie4, 33.91, 2.53);
        movieDao.insertMovieContent("설국열차", "드라마", "2013","한국",R.drawable.movie5, 97.17, 3.7);
        movieDao.insertMovieContent("부산행", "액션", "2016","한국",R.drawable.movie6,86.11, 3.31);
        movieDao.insertMovieContent("아바타", "액션", "2009","미국", R.drawable.movie7, 97.57, 4);
        movieDao.insertMovieContent("인터스텔라", "드라마", "2014","미국", R.drawable.movie8,95.59, 4.11);
        movieDao.insertMovieContent("겨울왕국", "코미디", "2013","미국", R.drawable.movie9,91.7, 3.55);

        movieDao.insertMovieContent("1987", "드라마", "2017","한국", R.drawable.movie10, 95.73, 3.87);
        movieDao.insertMovieContent("도둑들", "드라마", "2012","한국", R.drawable.movie11, 87.02, 3.19);
        movieDao.insertMovieContent("인셉션", "드라마", "2010","미국",  R.drawable.movie12,99.65, 4.4);
        movieDao.insertMovieContent("택시운전사", "드라마", "2017","한국", R.drawable.movie13,88.82, 3.41);
        movieDao.insertMovieContent("블랙 팬서", "드라마", "2018", "미국", R.drawable.movie14,90, 3.42);
        movieDao.insertMovieContent ("코코", "코미디", "2017", "미국", R.drawable.movie15,96.72, 3.93);
        movieDao.insertMovieContent ("어벤져스", "액션", "2012","미국",  R.drawable.movie16,94.35, 3.62);
        movieDao.insertMovieContent ("암살", "드라마", "2015", "한국", R.drawable.movie17,91.35, 3.33);
        movieDao.insertMovieContent ("타이타닉", "드라마","1997", "미국", R.drawable.movie18, 98.43, 4.21);
        movieDao.insertMovieContent ("광해 왕이 된 남자", "드라마", "2012","한국", R.drawable.movie19, 92.2, 3.51);
        movieDao.insertMovieContent ("데드풀 2", "코미디", "2018","미국",  R.drawable.movie20,92.63, 3.49);


        movieDao.insertMovieContent ("다크나이트", "드라마", "2008","미국",R.drawable.movie21,  99.3, 4.54);
        movieDao.insertMovieContent ("어벤져스:에이지 오브 울트론", "액션", "2015", "미국",R.drawable.movie22, 82.93, 3.23);
        movieDao.insertMovieContent ("레디 플레이어 원", "액션", "2018","미국", R.drawable.movie23, 98.03, 3.94);
        movieDao.insertMovieContent ("명량", "드라마", "2014","한국", R.drawable.movie24, 40, 2.6);
        movieDao.insertMovieContent ("7번방의 선물", "코미디", "2012","한국",  R.drawable.movie25,24.52, 2.17);
        movieDao.insertMovieContent ("범죄도시", "액션", "2017", "한국",R.drawable.movie26, 82.82, 3.16);
        movieDao.insertMovieContent("캡틴 아메리카:시빌 워", "액션", "2016","미국", R.drawable.movie27, 92.61, 3.67);
        movieDao.insertMovieContent ("센과 치히로의 행방불명", "어드벤처(모험)", "2002","일본",R.drawable.movie28,  98.77, 4.24);
        movieDao.insertMovieContent ("위플래쉬", "드라마", "2014","미국", R.drawable.movie29, 98.45, 4.23);
        movieDao.insertMovieContent ("셰이프 오브 워터: 사랑의 모양", "드라마", "2017", "미국", R.drawable.movie30,98.37, 4.12);
        movieDao.insertMovieContent  ("강철비", "드라마", "2017","한국",  R.drawable.movie31,92.4, 3.43);
        movieDao.insertMovieContent  ("신과함께-인과 연", "드라마", "2018", "한국", R.drawable.movie32,42.34, 2.62);
        movieDao.insertMovieContent  ("앤트맨과 와스트", "액션", "2018","미국",  R.drawable.movie33,90.98, 3.32);
        movieDao.insertMovieContent  ("아이언맨 3", "액션", "2013","미국", R.drawable.movie34, 95.81, 3.46);
        movieDao.insertMovieContent   ("비긴 어게인", "드라마", "2013","미국",  R.drawable.movie35,90.77, 3.54);
        movieDao.insertMovieContent   ("매드 맥스:분노의 도로","액션", "2015","미국",R.drawable.movie36,98.36, 4.31);
        movieDao.insertMovieContent   ("트루먼 쇼", "드라마", "1998", "미국", R.drawable.movie37,99.57, 4.16);
        movieDao.insertMovieContent  ("관상", "드라마", "2013","한국", R.drawable.movie38, 81.82, 3.1);

    }
    public static void insertCurrentMovieContent() {
        movieDao.initCurrentMovieContent();
        movieDao.insertCurrentMovieContent("기생충", "드라마", "2019","한국", R.drawable.current_movie1, 100, 4.54);
        movieDao.insertCurrentMovieContent("알라딘", "멜로/로맨스", "2019","미국", R.drawable.current_movie2, 75, 3.08);
        movieDao.insertCurrentMovieContent("악인전", "액션", "2019","한국", R.drawable.current_movie3, 70.27, 3.01);
        movieDao.insertCurrentMovieContent("고질라:킹 오브 몬스터", "액션", "2019","미국", R.drawable.current_movie4, 48.15, 2.7);
        movieDao.insertCurrentMovieContent("0.0MHz", "공포(호러)", "2018","한국", R.drawable.current_movie5, 0, 0);
        movieDao.insertCurrentMovieContent("어벤져스: 엔드게임", "액션", "2019","미국", R.drawable.current_movie6, 96.3, 4.05);
        movieDao.insertCurrentMovieContent("걸캅스", "코미디", "2018","한국", R.drawable.current_movie7, 50, 2.74);
        movieDao.insertCurrentMovieContent("교회오빠", "다큐멘터리", "2019","한국", R.drawable.current_movie8, 0, 0);
        movieDao.insertCurrentMovieContent("어린 의뢰인", "드라마", "2018","한국", R.drawable.current_movie9, 85, 3.07);
        movieDao.insertCurrentMovieContent("나의 특별한 형제", "드라마", "2018","한국", R.drawable.current_movie10, 83.33, 3.06);
    }
    public static void insertDueForMovieContent() {
        movieDao.initDueForMovieContent();
        movieDao.insertDueForMovieContent("엑스맨: 다크피닉스", "액션", "2019","미국", R.drawable.due_for_movie1, 0, 0);
        movieDao.insertDueForMovieContent("노리개: 그녀의 눈물", "드라마", "2012","한국", R.drawable.due_for_movie2, 0, 1.75);
        movieDao.insertDueForMovieContent("로켓맨", "드라마", "2019","미국", R.drawable.due_for_movie3, 0, 0);
        movieDao.insertDueForMovieContent("이웃집 토토로", "가족", "1988","일본", R.drawable.due_for_movie4, 98.31, 3.88);
        movieDao.insertDueForMovieContent("글로리아 벨", "드라마", "2018","미국", R.drawable.due_for_movie5, 0, 0);
        movieDao.insertDueForMovieContent("폴라로이드", "공포(호러)", "2018","캐나다 외", R.drawable.due_for_movie6, 0, 0);
        movieDao.insertDueForMovieContent("하나레이 베이", "드라마", "2018","일본", R.drawable.due_for_movie7, 0, 0);
        movieDao.insertDueForMovieContent("닥치고 피아노!", "다큐멘터리", "2018","독일 외", R.drawable.due_for_movie8, 0, 0);
        movieDao.insertDueForMovieContent("맨 인 블랙: 인터내셔널", "코미디", "2019","미국", R.drawable.due_for_movie9, 0, 0);
        movieDao.insertDueForMovieContent("틴 스피릿", "드라마", "2018","미국", R.drawable.due_for_movie10, 0, 0);

    }

    public static MovieSimpleInfoAdapter getCurrentScrreningAdapter() {
        ArrayList<MovieSimpleInfoItemDTO> arrayList = movieDao.selectCurrentMovie();
        return new MovieSimpleInfoAdapter(arrayList);
    }

    public static MovieSimpleInfoAdapter getdueForReleaseAdapter() {
        ArrayList<MovieSimpleInfoItemDTO> arrayList = movieDao.selectDueForMovie();
        return new MovieSimpleInfoAdapter(arrayList);
    }

    public static ArchiveAdapter getArchiveAdapter(int flag) {
        ArrayList<ArchiveMovieInfoDTO> arrayList = new ArrayList<>();
        ArrayList<MovieSimpleInfoItemDTO> temp = movieDao.selectEventContentAll();
        for(MovieSimpleInfoItemDTO dto: temp) {
            ArchiveMovieInfoDTO item  = new ArchiveMovieInfoDTO(dto);
            arrayList.add(item);
        }
        if(UserService.loginCheck()) {
            ArrayList<ArchiveMovieInfoDTO> list = movieScoreDao.selectMovieScoreContentAll(UserService.getUserInfo().getId());
            for(ArchiveMovieInfoDTO item : arrayList) {
                for(ArchiveMovieInfoDTO listItem : list) {
                    if(item.getName().equals(listItem.getName())) {
                        item.setMyRadioRedFlag(listItem.isMyRadioRedFlag());
                        item.setMyRadioGreenFlag(listItem.isMyRadioGreenFlag());
                        item.setMyStarScore(listItem.getStarScore());
                    }
                }
            }
        }
        return new ArchiveAdapter(arrayList);
    }

    public static ProfileEditBestMovieAdapter getSearchBestMovieAdapter(String name) {
        return new ProfileEditBestMovieAdapter(movieDao.selectSearchBestMovie(name));
    }
    public static ArrayList<MovieSimpleInfoItemDTO> getBestMoiveList() {
        return movieDao.selectBestMovie();
    }
    public static BestMovieAdapter getBestMovieAdapter() {
        return new BestMovieAdapter(movieDao.selectBestMovie());
    }

    public static ProfileKinoAdapter getProfileKinoAdapter() {
        ArrayList<ProfileKinoInfoDTO> arrayList = new ArrayList<>();

        return new ProfileKinoAdapter(arrayList);
    }

    public static ProfileWishAdapter getProfileWishAdapter() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.movie_sample);
        arrayList.add(R.drawable.movie_sample);
        arrayList.add(R.drawable.movie_sample);
        arrayList.add(R.drawable.movie_sample);
        arrayList.add(R.drawable.movie_sample);
        arrayList.add(R.drawable.movie_sample);
        ProfileWishAdapter wishAdapter = new ProfileWishAdapter(arrayList);
        return (wishAdapter.getCount()==0)? null:wishAdapter;
    }

    public static SearchAdapter getSearchAdapter(String title) {
        ArrayList<MovieSimpleInfoItemDTO> arrayList = movieDao.selectSearchMovie(title);
        return new SearchAdapter(arrayList);
    }

    public static void insertBestMovie(ProfileEditImageManager[] managers) {
        movieDao.deletBestMovie(UserService.getUserInfo().getId());
        for(ProfileEditImageManager m : managers) {
            if(m.getDto() != null)
                movieDao.insertBestMovie(UserService.getUserInfo().getId(),m.getDto().getName());
        }

    }
}
