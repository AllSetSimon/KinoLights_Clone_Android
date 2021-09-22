package dongdang.androind.kinolights.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class KinoDBHelper extends SQLiteOpenHelper {

    public KinoDBHelper(Context context) {
        super(context,"kinoDB",null,2);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE USERS (_id CHAR(20) PRIMARY KEY,_pwd CHAR(20),_name INTEGER,_image CHAR(50), _introduce CHAR(100),_sex INTEGER);");
        db.execSQL("CREATE TABLE IF NOT EXISTS proceed_event(" +
                "_num integer primary key autoincrement," +
                "_title char(30)," +
                "_summary char(100)," +
                "_content char(200)," +
                "_image integer" +
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS movie(" +
                "_name char(30) PRIMARY KEY," +
                "_genre char(10)," +
                "_premiere char(10)," +
                "_country char(10),"+
                "_image integer," +
                "_radio_score double," +
                "_star_score double"+
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS overdue_event(" +
                "_num integer primary key autoincrement," +
                "_title char(30)," +
                "_summary char(100)," +
                "_content char(200)," +
                "_image integer" +
                ");");


        db.execSQL("CREATE TABLE IF NOT EXISTS movie_score(" +
                "_id CHAR(20)," +
                "_title CHAR(20) primary key," +
                "_my_radio_score CHAR(20)," +
                "_my_star_score real" +
                ");"
        );

        db.execSQL("CREATE TABLE IF NOT EXISTS current_movie(" +
                "_name char(30) PRIMARY KEY," +
                "_genre char(10)," +
                "_premiere char(10)," +
                "_country char(10),"+
                "_image integer," +
                "_radio_score double," +
                "_star_score double"+
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS due_for_movie(" +
                "_name char(30) PRIMARY KEY," +
                "_genre char(10)," +
                "_premiere char(10)," +
                "_country char(10),"+
                "_image integer," +
                "_radio_score double," +
                "_star_score double"+
                ");");

        db.execSQL("CREATE TABLE IF NOT EXISTS recently_view_movie(" +
                "_num integer primary key autoincrement," +
                "_id char(30)," +
                "_title char(30)" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS best_movie(" +
                "_num integer primary key autoincrement," +
                "_id char(30)," +
                "_title char(30)" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS wish_list(" +
                "_num integer primary key autoincrement," +
                "_id char(30)," +
                "_title char(30)" +
                ")");

        db.execSQL("CREATE TABLE IF NOT EXISTS view_movie(" +
                "_num integer primary key autoincrement," +
                "_id char(30)," +
                "_title char(30)" +
                ")");
        db.execSQL("CREATE TABLE IF NOT EXISTS review(" +
                "_num integer primary key autoincrement," +
                "_movie_title char(30)," +
                "_user_name char(30)," +
                "_year char(30)," +
                "_content char(200)"+
                ")"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS USERS;");
        db.execSQL("DROP TABLE IF EXISTS proceed_event;");
        db.execSQL("DROP TABLE IF EXISTS overdue_event;");
        db.execSQL("DROP TABLE IF EXISTS movie;");
        db.execSQL("DROP TABLE IF EXISTS movie_score;");
        db.execSQL("DROP TABLE IF EXISTS recently_view_movie;");
        db.execSQL("DROP TABLE IF EXISTS best_movie;");
        db.execSQL("DROP TABLE IF EXISTS wish_list;");
        db.execSQL("DROP TABLE IF EXISTS view_movie;");
        onCreate(db);
    }
}
