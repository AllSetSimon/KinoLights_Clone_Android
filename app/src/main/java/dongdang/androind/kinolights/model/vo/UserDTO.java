package dongdang.androind.kinolights.model.vo;


import dongdang.androind.kinolights.model.bl.UserService;

public class UserDTO {
    private String id;
    private String pwd;
    private String name;
    private String profileImageUri;
    private String introduce;
    private int sex;

    public UserDTO() {
    }

    public UserDTO(String id, String pwd, String name) {
        this(id,pwd,name,null,null, UserService.USER_NO_SEX);
    }

    public UserDTO(String id, String pwd, String name, String profileImageUri, String introduce, int sex) {
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.profileImageUri = profileImageUri;
        this.introduce = introduce;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileImageUri() {
        return profileImageUri;
    }

    public void setProfileImageUri(String profileImageUri) {
        this.profileImageUri = profileImageUri;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}

