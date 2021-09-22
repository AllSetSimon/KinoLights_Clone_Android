package dongdang.androind.kinolights.model.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Array;
import java.util.ArrayList;

import dongdang.androind.kinolights.model.bl.UserService;
import dongdang.androind.kinolights.model.vo.MovieSimpleInfoItemDTO;
import dongdang.androind.kinolights.model.vo.ProfileEditBestMovieItemDTO;
import dongdang.androind.kinolights.util.KinoDBHelper;
import dongdang.androind.kinolights.util.KinoDBHelperFactory;

public class MovieDao {
    private KinoDBHelper movieDBHelper;
    private SQLiteDatabase movieDB;
    public MovieDao() {
        movieDBHelper = KinoDBHelperFactory.getKinoDBHelper();
    }
    public void initMovieContent(){
        movieDB = movieDBHelper.getWritableDatabase();
        movieDB.execSQL("delete from movie;");
        movieDB.close();
    }
    public void insertMovieContent(String title, String genre, String premiere, String county, int image, double radioScore, double starScore) {
        movieDB = movieDBHelper.getWritableDatabase();
        movieDB.execSQL("INSERT INTO movie (_name, _genre, _premiere, _country,_image,_radio_score,_star_score) VALUES ('"
                + title + "' , '"
                + genre + "', '"
                + premiere + "', '"
                + county + "', "
                + image + ", "
                + radioScore + ", "
                + starScore +
                ");");
        movieDB.close();
    }
    public ArrayList<MovieSimpleInfoItemDTO> selectEventContentAll() {
        movieDB = movieDBHelper.getReadableDatabase();
        Cursor cursor = movieDB.rawQuery("SELECT * from movie;",null);
        ArrayList<MovieSimpleInfoItemDTO> arrayList = new ArrayList<>();
        while(cursor.moveToNext()) {
            MovieSimpleInfoItemDTO temp = new MovieSimpleInfoItemDTO();
            temp.setName(cursor.getString(0));
            temp.setGenre(cursor.getString(1));
            temp.setPremire(cursor.getString(2));
            temp.setCountry(cursor.getString(3));
            temp.setImage(cursor.getInt(4));
            temp.setRadioScore(cursor.getDouble(5));
            temp.setStarScore(cursor.getDouble(6));
            arrayList.add(temp);
        }
        movieDB.close();
        return arrayList;
    }

    public void initCurrentMovieContent(){
        movieDB = movieDBHelper.getWritableDatabase();
        movieDB.execSQL("delete from current_movie;");
        movieDB.close();
    }
    public void insertCurrentMovieContent(String title, String genre, String premiere, String county, int image, double radioScore, double starScore) {
        movieDB = movieDBHelper.getWritableDatabase();
        movieDB.execSQL("INSERT INTO current_movie (_name, _genre, _premiere, _country,_image,_radio_score,_star_score) VALUES ('"
                + title + "' , '"
                + genre + "', '"
                + premiere + "', '"
                + county + "', "
                + image + ", "
                + radioScore + ", "
                + starScore +
                ");");
        movieDB.close();
    }

    public ArrayList<MovieSimpleInfoItemDTO> selectCurrentMovie() {
        movieDB = movieDBHelper.getReadableDatabase();
        Cursor cursor = movieDB.rawQuery("SELECT * from current_movie;",null);
        ArrayList<MovieSimpleInfoItemDTO> arrayList = new ArrayList<>();
        while(cursor.moveToNext()) {
            MovieSimpleInfoItemDTO temp = new MovieSimpleInfoItemDTO();
            temp.setName(cursor.getString(0));
            temp.setGenre(cursor.getString(1));
            temp.setPremire(cursor.getString(2));
            temp.setCountry(cursor.getString(3));
            temp.setImage(cursor.getInt(4));
            temp.setRadioScore(cursor.getDouble(5));
            temp.setStarScore(cursor.getDouble(6));
            arrayList.add(temp);
        }
        movieDB.close();
        return arrayList;
    }

    public void initDueForMovieContent(){
        movieDB = movieDBHelper.getWritableDatabase();
        movieDB.execSQL("delete from due_for_movie;");
        movieDB.close();
    }
    public void insertDueForMovieContent(String title, String genre, String premiere, String county, int image, double radioScore, double starScore) {
        movieDB = movieDBHelper.getWritableDatabase();
        movieDB.execSQL("INSERT INTO due_for_movie (_name, _genre, _premiere, _country,_image,_radio_score,_star_score) VALUES ('"
                + title + "' , '"
                + genre + "', '"
                + premiere + "', '"
                + county + "', "
                + image + ", "
                + radioScore + ", "
                + starScore +
                ");");
        movieDB.close();
    }
    public ArrayList<MovieSimpleInfoItemDTO> selectDueForMovie() {
        movieDB = movieDBHelper.getReadableDatabase();
        Cursor cursor = movieDB.rawQuery("SELECT * from due_for_movie;",null);
        ArrayList<MovieSimpleInfoItemDTO> arrayList = new ArrayList<>();
        while(cursor.moveToNext()) {
            MovieSimpleInfoItemDTO temp = new MovieSimpleInfoItemDTO();
            temp.setName(cursor.getString(0));
            temp.setGenre(cursor.getString(1));
            temp.setPremire(cursor.getString(2));
            temp.setCountry(cursor.getString(3));
            temp.setImage(cursor.getInt(4));
            temp.setRadioScore(cursor.getDouble(5));
            temp.setStarScore(cursor.getDouble(6));
            arrayList.add(temp);
        }
        movieDB.close();
        return arrayList;
    }
    public ArrayList<MovieSimpleInfoItemDTO> selectSearchMovie(String title) {
        movieDB = movieDBHelper.getReadableDatabase();
        Cursor cursor = movieDB.rawQuery("SELECT * from movie where _name like '%"+title+"%';",null);
        ArrayList<MovieSimpleInfoItemDTO> arrayList = new ArrayList<>();
        while(cursor.moveToNext()) {
            MovieSimpleInfoItemDTO temp = new MovieSimpleInfoItemDTO();
            temp.setName(cursor.getString(0));
            temp.setGenre(cursor.getString(1));
            temp.setPremire(cursor.getString(2));
            temp.setCountry(cursor.getString(3));
            temp.setImage(cursor.getInt(4));
            temp.setRadioScore(cursor.getDouble(5));
            temp.setStarScore(cursor.getDouble(6));
            arrayList.add(temp);
        }
        movieDB.close();
        return arrayList;
    }

    public ArrayList<ProfileEditBestMovieItemDTO> selectSearchBestMovie(String title) {
        movieDB = movieDBHelper.getReadableDatabase();
        Cursor cursor = movieDB.rawQuery("SELECT * from movie where _name like '%"+title+"%';",null);
        ArrayList<ProfileEditBestMovieItemDTO> arrayList = new ArrayList<>();
        while(cursor.moveToNext()) {
            ProfileEditBestMovieItemDTO temp = new ProfileEditBestMovieItemDTO();
            temp.setName(cursor.getString(0));
            temp.setYear(cursor.getString(2));
            temp.setImage(cursor.getInt(4));
            arrayList.add(temp);
        }
        movieDB.close();
        return arrayList;
    }

    public ArrayList<MovieSimpleInfoItemDTO> selectBestMovie() {
        movieDB = movieDBHelper.getReadableDatabase();
        Cursor cursor = movieDB.rawQuery("SELECT * FROM movie WHERE _name IN (SELECT _title FROM best_movie WHERE _id='"+ UserService.getUserInfo().getId() +"');",null);
        ArrayList<MovieSimpleInfoItemDTO> arrayList = new ArrayList<>();
        while(cursor.moveToNext()) {
            MovieSimpleInfoItemDTO temp = new MovieSimpleInfoItemDTO();
            temp.setName(cursor.getString(0));
            temp.setGenre(cursor.getString(1));
            temp.setPremire(cursor.getString(2));
            temp.setCountry(cursor.getString(3));
            temp.setImage(cursor.getInt(4));
            temp.setRadioScore(cursor.getDouble(5));
            temp.setStarScore(cursor.getDouble(6));
            arrayList.add(temp);
        }
        movieDB.close();
        return arrayList;
    }
    public void deletBestMovie(String id) {
        movieDB = movieDBHelper.getWritableDatabase();
        movieDB.execSQL("DELETE FROM best_movie WHERE _id='"+id+"';");
        movieDB.close();
    }
    public void insertBestMovie(String id, String title) {
        movieDB = movieDBHelper.getWritableDatabase();
        movieDB.execSQL("INSERT INTO best_movie (_id,_title) VALUES ('" + id + "' , '" + title+ "');");
        movieDB.close();
    }
}
