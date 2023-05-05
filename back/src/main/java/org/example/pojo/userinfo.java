package org.example.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("userinfo")
public class userinfo {
    @TableId(type= IdType.AUTO)
    private long id;//id
    private String userName;//用户名
    private String userNumber;//电话号码
    private String userAddress;//用户地址
    private String userPassword;//用户密码
    private boolean isonline;//是否在线
    private boolean isnew;//新用户
    private String gender;//性别
    private int age;//年龄

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isIsonline() {
        return isonline;
    }

    public void setIsonline(boolean isonline) {
        this.isonline = isonline;
    }

    public boolean isNew() {
        return isnew;
    }

    public void setNew(boolean aNew) {
        isnew = aNew;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "userinfo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", isonline=" + isonline +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
