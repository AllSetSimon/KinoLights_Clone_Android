package dongdang.androind.kinolights.model.bl;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dongdang.androind.kinolights.R;
import dongdang.androind.kinolights.model.dao.EventDao;
import dongdang.androind.kinolights.model.vo.EventItemDTO;
import dongdang.androind.kinolights.util.EventAdapter;
import dongdang.androind.kinolights.util.EventOverdueAdapter;

public class EventService {
    private static EventDao eventProceedDao = new EventDao("proceed_event");
    private static EventDao eventOverdueDao = new EventDao("overdue_event");

    public static void insertEventProceedContent() {
        eventProceedDao.initEventContent();
        eventProceedDao.insertEventContent(
                "키노라이츠 단독 <틴 스피릿> GV 시사회",
                "망설이면 늦어!\n지금 바로 여기가 너의 무대!!",
                "영화<틴 스피릿> 시사회 초대 60명(1인 2석, 총 120석)\n" +
                        "응모 기간 :  5월 31일(금)~6월 3일(월)\n" +
                        "선정 발표 : 6월 4일(화)\n" +
                        "시사회 일시 : 6월 5일(수) 오후 7시 30분\n"+
                        "시사회 장소 :  롯데시네마 월드타워\n",
                         R.drawable.event1
                );
        eventProceedDao.insertEventContent(
                "<평일 오후 3시의 연인> 언론배급 시사회",
                "숨 막히도록 강력하고 아찔하다!\n"+
                        "2019년 가장 파격적인 격정멜로 <평일 오후 3시의 연인>",
                "영화<평일 오후 3시의 연인>언론배급 시사회 초대 15명(1인 2석, 총 30석)\n" +
                        "응모 기간 : 5월 31일(금)~6월 2일(일)\n" +
                        "선정 발표 : 6월 3일(월)\n"+
                        "시사회 일시 : 6월 5일(수) 오후 2시\n"+
                        "시사회 장소 : CGV 용산아이파크몰",
                        R.drawable.event2
                );
        eventProceedDao.insertEventContent(
                "<롱 샷> 키노라이츠 단과 시사회",
                "이런 로코는 없었다★\n"+
                        "베이비시터 였던 첫사랑이 대통령 후보?!\n"+
                        "샤를리즈 테론 X 세스 로건의\n"+
                        "대유잼 로코버스터<롱샷>\n"+
                        "키노라이츠 단관 시사회!",
                "영화<롱 샷> 시사회 초대 100명 (1인 2석, 총 200석)\n"+
                        "응모 기간 :  5월 30일(목)~6월 12일(수)\n"+
                        "선정 발표 : 6월 13일 (목)\n"+
                        "시사회 일시 : 6월 18일(화) 오후 8시\n"+
                        "시사회 장소 : CGV 용사아이파크몰\n",
                        R.drawable.event3
                );
        eventProceedDao.insertEventContent(
                "<마담 싸이코> 예매권",
                "지하철에서 주운 가방의 소름돋는 비밀!\n"+
                "이 구역 역대급 미친X가 나타났다!\n"+
                        "(인스타그램 진행)\n",
                        "인스타그램에서 진행중입니다~",
                        R.drawable.event4
                );
    }
    public static void insertEventOverdueContent() {
        eventOverdueDao.initEventContent();
        eventOverdueDao.insertEventContent(
                "<뷰티풀 보이스> 예매 경품 이벤트",
                "목청발랄 히어로의 목소리를 사수하라!\n"+
                        "탈우주급 대환장 코미디<뷰티풀 보이스>",
                "",
                        R.drawable.overdue_event1
        );
        eventOverdueDao.insertEventContent(
                "<업사이드> 시사회",
                "미쿡에서<아쿠아맨> 밀어내고 1등하더니\n"+
                        "입소문으로 대박까지 난 화제의 그 영화!"+
                        "<업사이드> 시사회 이벤트 OPEN!!",
                "",
                R.drawable.overdue_event2
        );
        eventOverdueDao.insertEventContent(
                "<노리개:그녀의 눈물> 진실 촉구 시사회",
                "J양의 죽음을 밝혀라!\n"+
                        "추악한 진실을 감춘 악마들을 벼랑 끝으로 몰아갈\n"+
                        "가장 쎈 마지막 한 방",
                "",
                R.drawable.overdue_event3
        );
        eventOverdueDao.insertEventContent(
                "<엑스맨:다크 피닉스> 내한 쇼케이스",
                "★프리퀄 시리즈 사상 첫 내한!★\n"+
                        "<엑스맨:다크 피닉스> 리멤버 엑스맨 내한 쇼 케이스!",
                "",
                R.drawable.overdue_event4
        );
        eventOverdueDao.insertEventContent(
                "<아이아이 가사: 다시 만난 그날> 시사회",
                "<어느 가족><그렇게 아버지가 된다>를 잇는 가족 힐링 드라마\n"+
                        "세상 모든 이들에 선사하는 여름날의 특별한 이야기\n"+
                        "<아이아이 가사: 다시 만난 그날> 최초 시사회 초대 이벤트",
                "",
                R.drawable.overdue_event5
        );
        eventOverdueDao.insertEventContent(
                "<노리개: 그녀의 눈물> 최초 시사회",
                "폭발적인 관객 요청으로 유래없는 재개봉 확정!\n"+
                        "2019년! 추악한 진실을 감춘 악마들을\n"+
                        "벼랑 끝으로 몰아갈 가장 쎈 마지막 한방!",
                "",
                R.drawable.overdue_event6
        );
    }
    public static EventAdapter selectEventProceedContentAll(Context context) {
        ArrayList<EventItemDTO> arrayList = eventProceedDao.selectEventContentAll();
        return new EventAdapter(context,arrayList);
    }
    public static EventOverdueAdapter selectEventOverDueContentAll(Context context) {
        ArrayList<EventItemDTO> arrayList = eventOverdueDao.selectEventContentAll();
        return new EventOverdueAdapter(context,arrayList);
    }
}
