package dongdang.androind.kinolights.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import dongdang.androind.kinolights.model.bl.UserService;
import dongdang.androind.kinolights.model.vo.EventItemDTO;
import dongdang.androind.kinolights.model.vo.UserDTO;
import dongdang.androind.kinolights.util.KinoDBHelper;
import dongdang.androind.kinolights.util.KinoDBHelperFactory;

public class EventDao {
    private KinoDBHelper eventDBHelper;
    private SQLiteDatabase eventDB;
    private String tableName;
    public EventDao(String tableName) {
        this.tableName = tableName;
        eventDBHelper = KinoDBHelperFactory.getKinoDBHelper();
    }
    public void initEventContent(){
        eventDB = eventDBHelper.getWritableDatabase();
        eventDB.execSQL("delete from "+tableName);
        eventDB.close();
    }
    public boolean insertEventContent(String title, String summary, String content, int image) {
        eventDB = eventDBHelper.getWritableDatabase();
        eventDB.execSQL("INSERT INTO "+tableName+"(_title,_summary,_content,_image) VALUES ( '"
                + title + "' , '"
                + summary + "', '"
                + content + "', "
                + image + ");");
        eventDB.close();


        return true;
    }

    public ArrayList<EventItemDTO> selectEventContentAll() {
        eventDB = eventDBHelper.getReadableDatabase();
        Cursor cursor = eventDB.rawQuery("SELECT * from "+tableName+";",null);
        ArrayList<EventItemDTO> arrayList = new ArrayList<>();
        while(cursor.moveToNext()) {
            EventItemDTO temp = new EventItemDTO();
            temp.setId(cursor.getInt(0));
            temp.setEvtTitle(cursor.getString(1));
            temp.setEvtSummary(cursor.getString(2));
            temp.setEvtContent(cursor.getString(3));
            temp.setImage(cursor.getInt(4));
            arrayList.add(temp);
        }
        eventDB.close();
        return arrayList;
    }

    public EventItemDTO selectEventContet(int id) {
     /*
            현재 필요없음.
      */
     return null;
    }
}
