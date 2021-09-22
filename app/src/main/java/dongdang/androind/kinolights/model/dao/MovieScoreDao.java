package dongdang.androind.kinolights.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import dongdang.androind.kinolights.model.vo.ArchiveMovieInfoDTO;
import dongdang.androind.kinolights.util.KinoDBHelper;
import dongdang.androind.kinolights.util.KinoDBHelperFactory;

public class MovieScoreDao {
    KinoDBHelper movieScoreDBHelper;
    SQLiteDatabase movieScoreDB;
    public MovieScoreDao () {
        movieScoreDBHelper = KinoDBHelperFactory.getKinoDBHelper();
    }
    public void initEventContent(){
        movieScoreDB = movieScoreDBHelper.getWritableDatabase();
        movieScoreDB.execSQL("delete from movie_score");
        movieScoreDB.close();
    }
    public void insertMovieContent(String id, String title,String radioScore, double starScore) {
        movieScoreDB = movieScoreDBHelper.getWritableDatabase();
        movieScoreDB.execSQL("INSERT INTO movie_score(_id,_title,_radio_score,_star_score) VALUES ("
                + id + "' , '"
                + title + "', '"
                + radioScore + "', "
                + starScore +
                ");");
        movieScoreDB.close();
    }
    public ArrayList<ArchiveMovieInfoDTO> selectMovieScoreContentAll(String id) {
        movieScoreDB = movieScoreDBHelper.getReadableDatabase();
        Cursor cursor = movieScoreDB.rawQuery("SELECT * from movie_score where _id='"+id+"';",null);

        ArrayList<ArchiveMovieInfoDTO> arrayList = new ArrayList<>();
        while(cursor.moveToNext()) {
            ArchiveMovieInfoDTO temp = new ArchiveMovieInfoDTO();
            temp.setName(cursor.getString(1));
            if(cursor.getString(2).equals("true")) {
                temp.setMyRadioGreenFlag(true);
                temp.setMyRadioRedFlag(false);
            }else {
                temp.setMyRadioGreenFlag(false);
                temp.setMyRadioRedFlag(true);
            }
            temp.setStarScore(cursor.getDouble(3));
            arrayList.add(temp);
        }
        movieScoreDB.close();
        return arrayList;
    }
}
