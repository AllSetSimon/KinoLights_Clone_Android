package dongdang.androind.kinolights.model.bl;


import android.widget.Toast;

import dongdang.androind.kinolights.model.dao.UserDao;
import dongdang.androind.kinolights.model.vo.UserDTO;

public class UserService {
    public static final int USER_MAN=1;
    public static final int USER_WOMAN=2;
    public static final int USER_NO_SEX=0;

    private static UserDTO userInfo=new UserDTO();
    private static UserDao userDao=new UserDao();

    public static boolean requestForLogin(String id, String pwd) {
        return userDao.requestForLogin(id,pwd);
    }
    public static boolean requestForJoin(String id, String pwd,String name){
         return userDao.requestForJoin(id,pwd,name);
    }
    public static boolean updateUserInfo(){
        return userDao.updateUserInfo();
    }
    public static void requestForLogout() {
        userInfo = new UserDTO();
    }
    public static boolean loginCheck() {
       if(userInfo.getId()!=null) return true;
       return false;
    }
    public static UserDTO getUserInfo() {
        return userInfo;
    }

    public static void setUserInfo(UserDTO userInfo) {
        UserService.userInfo = userInfo;
    }
}
