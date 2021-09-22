package dongdang.androind.kinolights.model.dao;


import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.Toast;

import dongdang.androind.kinolights.model.bl.UserService;
import dongdang.androind.kinolights.model.vo.UserDTO;
import dongdang.androind.kinolights.util.KinoDBHelper;
import dongdang.androind.kinolights.util.KinoDBHelperFactory;

public class UserDao {
    private KinoDBHelper kinoDBHelper;
    private SQLiteDatabase userDB;


    public UserDao() {
        kinoDBHelper = KinoDBHelperFactory.getKinoDBHelper();
    }

    public boolean requestForJoin(String id, String pwd, String name) {
        userDB = kinoDBHelper.getWritableDatabase();
        Cursor cursor = userDB.rawQuery("SELECT * FROM USERS WHERE _id='"+id+"';",null);
        cursor.moveToNext();
        if(cursor.getCount()>0) return false;

        userDB.execSQL("INSERT INTO USERS VALUES ( '"
                + id + "' , '"
                + pwd + "', '"
                + name+ "', "
                + "''" + ", "
                + "''" + ", "
                + UserService.USER_NO_SEX +
                ");");
        userDB.close();
        return true;
    }
    public boolean requestForLogin(String id, String pwd){
        userDB = kinoDBHelper.getReadableDatabase();
        Cursor cursor = userDB.rawQuery("SELECT * from USERS WHERE _id='"+id+"' AND _pwd='"+pwd+"';",null);
        cursor.moveToNext();
        if(cursor.getCount()<=0) return false;
        UserDTO temp = UserService.getUserInfo();
        temp.setId(cursor.getString(0));
        temp.setPwd(cursor.getString(1));
        temp.setName(cursor.getString(2));
        temp.setProfileImageUri(cursor.getString(3));
        temp.setIntroduce(cursor.getString(4));
        temp.setSex(cursor.getInt(5));
        userDB.close();
        return true;
    }
    public boolean updateUserInfo() {
        UserDTO userDTO = UserService.getUserInfo();
        userDB = kinoDBHelper.getWritableDatabase();
        userDB.execSQL("UPDATE USERS SET "+"_name='"+userDTO.getName()+"',_pwd='" + userDTO.getPwd() + "', _image='" + userDTO.getProfileImageUri() + "' ,_sex="+ userDTO.getSex() + ", _introduce='"+ userDTO.getIntroduce()+"' " +
                "where _id='"+ userDTO.getId() +"'" +
                ";");
        userDB.close();
        return true;
    }
    
}
