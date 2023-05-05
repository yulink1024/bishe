package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("userinterestlist")
public class userinterestlist {
    @TableId(type= IdType.AUTO)
    private long id;
    private long uid;
    private String userName;
    private String userInterest1;//一级标签
    private String userInterest2;//二级标签
    private String userInterest3;//三级标签
    private double Interestsco;//标签组合得分

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserInterest1() {
        return userInterest1;
    }

    public void setUserInterest1(String userInterest1) {
        this.userInterest1 = userInterest1;
    }

    public String getUserInterest2() {
        return userInterest2;
    }

    public void setUserInterest2(String userInterest2) {
        this.userInterest2 = userInterest2;
    }

    public String getUserInterest3() {
        return userInterest3;
    }

    public void setUserInterest3(String userInterest3) {
        this.userInterest3 = userInterest3;
    }

    public double getInterestsco() {
        return Interestsco;
    }

    public void setInterestsco(double interestsco) {
        Interestsco = interestsco;
    }

    @Override
    public String toString() {
        return "userinterestlist{" +
                "id=" + id +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userInterest1='" + userInterest1 + '\'' +
                ", userInterest2='" + userInterest2 + '\'' +
                ", userInterest3='" + userInterest3 + '\'' +
                ", Interestsco=" + Interestsco +
                '}';
    }
}
