package dongdang.androind.kinolights.model.bl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.dao.ReviewDao;
import dongdang.androind.kinolights.model.vo.ReviewItemDTO;
import dongdang.androind.kinolights.util.PageIndicatorAdapter;
import dongdang.androind.kinolights.util.ReviewAdapter;

public class ReviewService {

    public static PageIndicatorAdapter selectThisweekReviewItem(ViewGroup parent) {
        PageIndicatorAdapter adapter = new PageIndicatorAdapter(parent);
        ArrayList<View> viewList =new ArrayList<>();
        ArrayList<ReviewItemDTO> listViewItemList = new ArrayList<>();
        listViewItemList.add(new ReviewItemDTO(R.drawable.recent_review1,"기생충", "드라마", "2019",R.drawable.movie_sample,"양기자","2019.06.01 16:24", false,true,5,
                        "여러 컷들이나 아이템이 이 영화에 고스란히 녹여 있었다.\n" +
                        "어찌본다면 본인의 필모그래피를 함축적으로 보여주고 싶었던 것이 아닐까."));
        listViewItemList.add(new ReviewItemDTO(R.drawable.recent_review2,"레버넌트:죽음에서 돌아온 자","어드벤처","2015", R.drawable.movie_sample,"고정규","2019.06.01 15:16",false,false  ,4,
                "레버넌트를 보고 있노라면 선악의 구분을 나눈다는 것이 무의미하게 느껴진다.\n" +
                        "이 영화에서 주인공은 초반에 치명상을 입는다. 그리고 동료들은 \n" +
                        "산을 너머야 하는 상황 속 에서 그의 처우를 어떻게 할 것인지에 대해 토론을 벌인다."));
        listViewItemList.add(new ReviewItemDTO(R.drawable.recent_review3,"택시 드라이머","드라마","1976", R.drawable.movie_sample,"owlppami","2019.06.01 11:16,",false,true  , 3,
                        "'트래비스'란 인물이 꼭 현실과 동떨어진 인물은 아니란 생각이 듭니다.\n" +
                        "단순히 이성에게 차이거나 믿었던 이에게 배신당했을 때의 상실감과 분노를 떠올려보면 말이죠.\n" +
                        "그래도 영화만으로는 이해가 어려운건 사실.\n"));

        viewList.add(getView(listViewItemList,0,parent));
        viewList.add(getView(listViewItemList,1,parent));
        viewList.add(getView(listViewItemList,2,parent));
        adapter.setData(viewList);
        return adapter;
    }
    public static View getView(ArrayList<ReviewItemDTO> listViewItemList, int position, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();
        LayoutInflater vi = LayoutInflater.from(parent.getContext());
        View view = vi.inflate(R.layout.item_home_thisweek_review, parent, false);

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        ImageView reviewmvpics = (ImageView) view.findViewById(R.id.thisWeekmovieImage);
        ImageView userpics = (ImageView) view.findViewById(R.id.thisWeekUserImage);


        TextView reviewmvTitle = (TextView) view.findViewById(R.id.thisWeekmovieName);
        TextView reviewmvGenre = (TextView) view.findViewById(R.id.thisWeekmovieGenre);
        TextView reviewmvYear = (TextView) view.findViewById(R.id.thisWeekmoviePremiere);
        TextView reviewmvScore = (TextView) view.findViewById(R.id.thiskWeekMovieScore);
        TextView userName = (TextView) view.findViewById(R.id.thiskWeekUserName);
        TextView revieDate = (TextView) view.findViewById(R.id.reportingDate);
        TextView reviewmvContent = (TextView) view.findViewById(R.id.thiskWeekReviewContent);

        RatingBar reviewmvStar = (RatingBar) view.findViewById(R.id.ratingScore);

        RadioButton rbRed = (RadioButton) view.findViewById(R.id.btnRadio1);
        RadioButton rbGreen = (RadioButton) view.findViewById(R.id.btnRadio2);

        ReviewItemDTO listViewItem = listViewItemList.get(position);

        reviewmvpics.setImageResource(listViewItem.getReviewmvpics());
        userpics.setImageResource(listViewItem.getUserpics());

        reviewmvTitle.setText(listViewItem.getReviewmvTitle());
        reviewmvGenre.setText(listViewItem.getReviewmvGenre());
        reviewmvYear.setText(listViewItem.getReviewmvYear());
        userName.setText(listViewItem.getUserName());
        revieDate.setText(listViewItem.getRevieDate());
        reviewmvContent.setText(listViewItem.getReviewmvContent());

        reviewmvStar.setRating(listViewItem.getMvRating());

        rbRed.setChecked(listViewItem.isRbRed());
        rbGreen.setChecked(listViewItem.isRbGreen());

        return view;
    }
    public static ReviewAdapter selectRecentReviewItem(Context context, ListView listView) {
        ReviewAdapter adapter = new ReviewAdapter() ;
        listView.setAdapter(adapter);
        //데이터베이스에서 값을 가져온후 DTO 형태로 가져오면 삽입할것.

        adapter.addItem(R.drawable.recent_review1,"기생충", "드라마", "2019",R.drawable.movie_sample,"양기자","2019.06.01 16:24", false,true,5,
                "새벽에 독립영화관으로 <지리멸렬>을 봤다. \n" +
                        "거기에 나오는 골목을 바라보는 시선이나 \n" +
                        "바퀴벌레와 같은 인물, 그리고 노상방뇨 등 \n" +
                        "여러 컷들이나 아이템이 이 영화에 고스란히 녹여 있었다.\n" +
                        "어찌본다면 본인의 필모그래피를 함축적으로 보여주고 싶었던 것이 아닐까.");
        adapter.addItem(R.drawable.recent_review2,"레버넌트:죽음에서 돌아온 자","어드벤처","2015", R.drawable.movie_sample,"고정규","2019.06.01 15:16",false,false  ,4,
                "레버넌트를 보고 있노라면 선악의 구분을 나눈다는 것이 무의미하게 느껴진다.\n" +
                        "이 영화에서 주인공은 초반에 치명상을 입는다. 그리고 동료들은 \n" +
                        "산을 너머야 하는 상황 속 에서 그의 처우를 어떻게 할 것인지에 대해 토론을 벌인다.\n" +
                        "치명상을 입은 동료를 그저 놔두고 가는 것(기지로 돌아가서 구호품과 함께 다시 오겠다고 하지만, \n" +
                        "그의 상태로 보면 그것은 놔두고 가는것에 대한 면피용 발언이었을 수 있다.)이 그를 죽이고 가는 것 보다 \n" +
                        "더 인도적이라고 할 수 있을까? ");
        adapter.addItem(R.drawable.recent_review3,"택시 드라이머","드라마","1976", R.drawable.movie_sample,"owlppami","2019.06.01 11:16,",false,true  , 3,
                "세상에 염증을 느낀 '트래비스'의 혼란과 폭발.\n" +
                        "그냥 슬쩍 줄거리만 보게 되면 이 무슨 황당한 중2병 환자의 이야기인가 싶지만,\n" +
                        "소외된 자의 상처, 끓어오르는 분노, 주체할 수 없는 폭발을 보여주는\n" +
                        "'트래비스'란 인물이 꼭 현실과 동떨어진 인물은 아니란 생각이 듭니다.\n" +
                        "단순히 이성에게 차이거나 믿었던 이에게 배신당했을 때의 상실감과 분노를 떠올려보면 말이죠.\n" +
                        "그래도 영화만으로는 이해가 어려운건 사실.\n");
        adapter.addItem(R.drawable.recent_review4,"고질라: 킹 오브 몬스터","액션","2019", R.drawable.movie_sample,"DaDaSi","2019.05.31 16:55",true,false  ,2,
                "오늘 보고 온 영화는 [고질라, 킹 오브 몬스터]입니다.\n" +
                        "해석하면 고질라, 괴물의 왕 정도 되겠죠? 그것도 스크린 엑스로 보고 왔습니다.\n" +
                        "사실, 이 영화는 4DX로 보는 것이 가장 좋을 것 같으나 저는 영화를 볼 때 편안한 관람을\n" +
                        "추구하기 때문에 스크린 엑스로 보고 왔습니다.\n" +
                        "우선 가장 유명한 DC 유니버스가 있고, 몬스터 버스, 공포영화를 기반으로 하는 컨저링 유니버스,\n" +
                        "해리포터 시리즈와 동물사전 시리즈를 묶은 위 자딩 유니버스, 반지의 제왕을 기반으로 하는 가운데\n" +
                        "땅 유니버스, 퍼시픽 림 시리즈 등 유니버스를 붙일 수 있는 영화들은 다 붙인 느낌입니다.");
        adapter.addItem(R.drawable.recent_review5,"장고:분노의 추적자","드라마","2012", R.drawable.movie_sample,"알비","2019.06.01 00:09",false,true  ,4,
                "미친 연기와 미친 연출, 영리한 이야기 단순한 흑백 갈등을 피하고\n" +
                        "통쾌한 복수를 이야기 하는 삼박자 척척 영화.\n" +
                        "음악은 천연덕스럽게 들러붙고 음향은 짜릿했다.\n" +
                        "이야기 전체를 이끌어 가는 크리스토프 왈츠는 진짜 어떤 수식어도 붙이기 어려운 보석중의 보석\n");

        adapter.addItem(R.drawable.recent_review6,"보희와 녹양","드라마","2018", R.drawable.movie_sample,"송씨네","2019.05.31 22:14",false,true  ,4,
                "\n" +
                        "소년과 소녀... 소꼽친구, 죽마고우, 불알친구를 넘어서 찬란한 청춘을 향해 전진하다.\n" +
                        "이런 친구 아마 없을꺼에요. 아빠를 만나는 이야기이자 좋은 친구, 좋은 어른을 만나는 과정이\n" +
                        "인상적입니다. 풋풋해서 좋았고 유쾌하지만 가볍지 않게 이야기한 영화가 아닐까 싶네요.\n" +
                        "'우리들', '초인'을 잇는 착한 영화라고 해도 틀린 말이 아닙니다. 올해의 아주 건강한 영화!\n" +
                        "성(性)에 대한 고정관념을 전복시키는 것은 물론 정체성을 이래하고 존중하는 모습에 대한\n" +
                        "묘사도 인상적입니다. 이런 섬세한 연출은 여성 감독인 안주영 감독의 힘이 컸다고 봅니다.\n" +
                        "\n");

        adapter.addItem(R.drawable.recent_review7,"\n" +
                        "렛 더 선샤인 인","드라마"," 2017", R.drawable.movie_sample,"삶이속일지라도","2019,05.31 14:16",false,true  ,3,
                "항상 사랑이 가득할 것 같은 배우 줄리엣 비노쉬다.\n" +
                        "이런 저런 사람들을 만나면서도 결코 자신의 빈 공간을 채워줄 누군가를 찾지 못한 상황...\n" +
                        "영화의 막바지에 제르라 드빠르도외가 나가서 타로 점을 보듯\n" +
                        "그녀와 얘기를 나누는 장면은 결말을 어떻게 해야 할 지 몰라 선택한 방식일까?\n" +
                        "뭔가 생뚱맞다.\n" +
                        "결론 역시 어쩌면 뻔한 얘기. 너 자신에 충실하라!\n" +
                        "그러면 어느날인가 Un Beau soleil interieur가 너에게 충만할 것이다.\n");




        return adapter;
    }
    public static ReviewAdapter selectBestReviewItem(Context context, ListView listView) {
        ReviewAdapter adapter = new ReviewAdapter() ;
        listView.setAdapter(adapter);
        //데이터베이스에서 값을 가져온후 DTO 형태로 가져오면 삽입할것.

        adapter.addItem(R.drawable.best_review1,"기생충", "드라마", "2019",R.drawable.movie_sample,"양기자","2019.06.01 16:24", false,true,5,
                "새벽에 독립영화관으로 <지리멸렬>을 봤다. \n" +
                        "거기에 나오는 골목을 바라보는 시선이나 \n" +
                        "바퀴벌레와 같은 인물, 그리고 노상방뇨 등 \n" +
                        "여러 컷들이나 아이템이 이 영화에 고스란히 녹여 있었다.\n" +
                        "어찌본다면 본인의 필모그래피를 함축적으로 보여주고 싶었던 것이 아닐까.");
        adapter.addItem(R.drawable.best_review2,"레버넌트:죽음에서 돌아온 자","어드벤처","2015", R.drawable.movie_sample,"고정규","2019.06.01 15:16",false,false  ,4,
                "레버넌트를 보고 있노라면 선악의 구분을 나눈다는 것이 무의미하게 느껴진다.\n" +
                        "이 영화에서 주인공은 초반에 치명상을 입는다. 그리고 동료들은 \n" +
                        "산을 너머야 하는 상황 속 에서 그의 처우를 어떻게 할 것인지에 대해 토론을 벌인다.\n" +
                        "치명상을 입은 동료를 그저 놔두고 가는 것(기지로 돌아가서 구호품과 함께 다시 오겠다고 하지만, \n" +
                        "그의 상태로 보면 그것은 놔두고 가는것에 대한 면피용 발언이었을 수 있다.)이 그를 죽이고 가는 것 보다 \n" +
                        "더 인도적이라고 할 수 있을까? ");
        adapter.addItem(R.drawable.best_review3,"고질라: 킹 오브 몬스터","액션","2019", R.drawable.movie_sample,"DaDaSi","2019.05.31 16:55",true,false  ,2,
                "오늘 보고 온 영화는 [고질라, 킹 오브 몬스터]입니다.\n" +
                        "해석하면 고질라, 괴물의 왕 정도 되겠죠? 그것도 스크린 엑스로 보고 왔습니다.\n" +
                        "사실, 이 영화는 4DX로 보는 것이 가장 좋을 것 같으나 저는 영화를 볼 때 편안한 관람을\n" +
                        "추구하기 때문에 스크린 엑스로 보고 왔습니다.\n" +
                        "우선 가장 유명한 DC 유니버스가 있고, 몬스터 버스, 공포영화를 기반으로 하는 컨저링 유니버스,\n" +
                        "해리포터 시리즈와 동물사전 시리즈를 묶은 위 자딩 유니버스, 반지의 제왕을 기반으로 하는 가운데\n" +
                        "땅 유니버스, 퍼시픽 림 시리즈 등 유니버스를 붙일 수 있는 영화들은 다 붙인 느낌입니다.");
        adapter.addItem(R.drawable.best_review4,"부르고뉴, 와인에서 찾은 인생","드라마","2017", R.drawable.movie_sample,"새날","2019.05.31 13:54",false,true  ,3,
                "프랑스판 리틀 포레스트.\n" +
                        "시골에서의 갑갑한 생활이 싫어 세계 여행을 떠났던 장(피오 마르마이)은\n" +
                        "아버지가 위독하다는 소식을 전해 듣고 10년 만에 고향 부르고뉴로 돌아오게 된다. 부모님이 운영 하는\n" +
                        "와이너리(포도주를 만드는 양조장)를 물려받기 싫어 무작정 떠났던 고향이다.\n" +
                        "물론 그가 갑갑하게 여겼던 고향이 10년이 지났다고 하여 달라졌을 리는 없다.\n" +
                        "포도와 포도밭 그리고 와이너리와 함께하는 부르고뉴에서의 삶은 한결같았다.\n" +
                        "와인과 함께하는 세 남매의 성장담.\n" +
                        "영화는 세 남매에게 닥친 어려움을 차근차근 극복해내는 과정을 그린 성장담과 함께\n" +
                        "이들이 1년 동안 정성 들여 포도를 가구며 수확하고 와인을 제조하는 모든 과정을 스크린 위에 번갈아 비춘다.");
        adapter.addItem(R.drawable.best_review5,"증인","드라마","2018", R.drawable.movie_sample,"새날","2019.05.31 13:52",false,false  ,3,
                "패기 넘치던 민변 출신의 순호(정우성)는 자신의 오랜 신념을 뒤로 한 채\n" +
                        "성공을 꿈꾸며 대형 로펌에 합류, 현실과 적당히 타협을 모색 중인 변호사다.\n" +
                        "그런 그에게 어느 날 좋은기회가 찾아온다. 살인 용의자로 지목된 한 여성(엄혜란)의 무죄를\n" +
                        "입증하면 그에게 승진을 보상해주겠노라는 달콤한 조건이었다.\n" +
                        "해당 사건에는 목격자가 있었다. 지우(김향기)였다. 지우는 겉으로는 평범해 보였으나\n" +
                        "사실은 자폐 스펙트럼을 앓고 있는 소녀였다. 순호는 살인용의자의 무죄를 입증하기 위해 유일한\n" +
                        "목격자이자 자폐 소녀인 지우를 만나게 된다. 그는 지우를 이번 사건의 증인으로 세우기 위한\n" +
                        "전략을 짜고 환심을 사려고 노력한다. 물론 그 과정은 결코 순탄치 않다. 험난함의 연속이다.");
        adapter.addItem(R.drawable.best_review6,"배심원들","드라마","2018", R.drawable.movie_sample,"새날","2019.05.31 13:51",false,false  ,3,
                "모친을 살해, 존속살해 혐의로 구속된 피고인. 해당 사건은 증거와 증언이 충분하고 자백까지 받아낸 터라\n" +
                        "사실상 양형 결정만 남은 상태다. 2008년 이의 판결을 위해 \n" +
                        "국민이 참여하는 역사상 최고의 재판이 열렸다. 이른바 국민 참여 재판이다.\n" +
                        "이를 위해 사는곳도, 나이도, 직업도, 성별도 모두 다른 보통 사람 8명이 \n" +
                        "무작위로 선발된 대한민국 최초의 배심원 단이 꾸려진다. \n" +
                        "하지만 양형 결정만 남은 상태에서 재판부는 돌발 상황과 맞닥뜨려야 했다. 피고인이 혐의를\n" +
                        "전부 부인하고 나선 것이다. 이에 따라 8명의 배심원 들은 양형 결정이 아닌 피고인의 유무죄를\n" +
                        "다퉈야 하는 처지가 됐다.");
        adapter.addItem(R.drawable.best_review7,"데스트랩","액션","2017", R.drawable.movie_sample,"고정규","2019.05.31 13:49",false,true  ,3,
                        "서울 경찰청 강력계 소속 권민(주민하) 경위는 흉악한 탈옥수 허태원(김준섭)의 뒤를 추격하던 도중\n" +
                        "비무장지대 인근 지역에서 지뢰를 밟는다. 발을 떼는 순간 지뢰가 폭발하게 될 지도 모르는 \n" +
                        "일촉즉발의 위기상황. 이 위급한 순간에 휴대폰마저도 그녀의 손을 벗어나게 되고, 실탄이 장착된\n" +
                        "권총 한 자루 그리고 휴대폰과 블루투스로 연결된 핸즈프리 이어세시 그녀에게 주어진 유일한\n" +
                        "생존 도구로 다가온다.");



        return adapter;
    }
    public static ReviewAdapter selectMyRecentReviewItem(Context context, ListView listView) {
        ReviewAdapter adapter = new ReviewAdapter() ;
        listView.setAdapter(adapter);
        //데이터베이스에서 값을 가져온후 DTO 형태로 가져오면 삽입할것.
        adapter.addItem(R.drawable.ic_launcher_background,"라라랜드1","드라마","2016", R.drawable.ic_launcher_background,"DongDang","2018-12-31", true,false,4,"존나꿀잼") ;
        adapter.addItem(R.drawable.ic_launcher_background,"라라랜드2","드라마","2016", R.drawable.ic_launcher_background,"DongDang","2018-12-31",false,true,4,"존나꿀잼") ;
        return adapter;
    }
    public static ReviewAdapter selectMyBestReviewItem(Context context, ListView listView) {
        ReviewAdapter adapter = new ReviewAdapter() ;
        listView.setAdapter(adapter);
        //데이터베이스에서 값을 가져온후 DTO 형태로 가져오면 삽입할것.
        adapter.addItem(R.drawable.ic_launcher_background,"라라랜드3","드라마","2016", R.drawable.ic_launcher_background,"DongDang","2018-12-31", true,false,4,"존나꿀잼") ;
        adapter.addItem(R.drawable.ic_launcher_background,"라라랜드4","드라마","2016", R.drawable.ic_launcher_background,"DongDang","2018-12-31",false,true,4,"존나꿀잼") ;
        return adapter;
    }
    public static ReviewAdapter selectMyWritingReviewItem(Context context) {
        ReviewAdapter adapter = new ReviewAdapter() ;
        //데이터베이스에서 값을 가져온후 DTO 형태로 가져오면 삽입할것.
        adapter.addItem(R.drawable.ic_launcher_background,"라라랜드1","드라마","2016", R.drawable.ic_launcher_background,"DongDang","2018-12-31", true,false,4,"존나꿀잼") ;
        adapter.addItem(R.drawable.ic_launcher_background,"라라랜드2","드라마","2016", R.drawable.ic_launcher_background,"DongDang","2018-12-31",false,true,4,"존나꿀잼") ;
        return (adapter.getCount()==0)? null: adapter;
    }
    public static ReviewAdapter selectMyFavoriteReviewItem(Context context) {
        ReviewAdapter adapter = new ReviewAdapter() ;
        //데이터베이스에서 값을 가져온후 DTO 형태로 가져오면 삽입할것.
        adapter.addItem(R.drawable.ic_launcher_background,"라라랜드3","드라마","2016", R.drawable.ic_launcher_background,"DongDang","2018-12-31", true,false,4,"존나꿀잼") ;
        adapter.addItem(R.drawable.ic_launcher_background,"라라랜드4","드라마","2016", R.drawable.ic_launcher_background,"DongDang","2018-12-31",false,true,4,"존나꿀잼") ;
        return (adapter.getCount()==0)? null: adapter;
    }
}
