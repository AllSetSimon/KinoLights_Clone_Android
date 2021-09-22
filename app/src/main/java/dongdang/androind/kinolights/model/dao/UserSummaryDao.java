package dongdang.androind.kinolights.model.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import dongdang.androind.kinolights.model.bl.UserService;
import dongdang.androind.kinolights.model.vo.UserDTO;
import dongdang.androind.kinolights.model.vo.UserSummaryDTO;

public class UserSummaryDao {
    private UserSummaryDBHelper userSummaryDBHelper;
    private SQLiteDatabase userSummaryDB;

    public UserSummaryDao() {}

    public UserSummaryDao(Context context) {
        this.userSummaryDBHelper = new UserSummaryDBHelper(context);
    }

    public void setUserDaoContext(Context context) {
        userSummaryDBHelper = new UserSummaryDBHelper(context);
    }

    public boolean selectUserSumaryData(String id) {
/*        userSummaryDB = userSummaryDBHelper.getReadableDatabase();
        Cursor cursor = userSummaryDB.rawQuery("SELECT * FROM USER_SUMMARY WHERE _id = '" + id + "';",null);
        if(cursor.getCount()<=0) return false;
        cursor.moveToNext();
        UserSummaryDTO temp = UserService.getUserSummaryDTO();
        temp.setMovieValue(cursor.getInt(0));
        temp.setReviewValue(cursor.getInt(1));
        temp.setFollowing();
        temp.setFollower();
        00
        userSummaryDB.close();*/
        return true;
    }

    private class UserSummaryDBHelper extends SQLiteOpenHelper {
        public UserSummaryDBHelper(Context context) {
            super(context,"userSummaryDB",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE USER_SUMMARY (" +
                    "_id CHAR(20) PRIMARY KEY," +
                    "_movie," +
                    "_review INTEGER," +
                    "_following INTEGER,"+
                    "_follower INTEGER,"+
                    "_best_movie_uri INTEGER,"+
                    "_recent_movie_uri INTEGER,"+
                    "_red_radio INTEGER,"+
                    "_green_radio INTEGER"+
                    ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS USER_SUMMARY");
            onCreate(db);
        }
    }
}
