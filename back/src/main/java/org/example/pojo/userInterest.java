package org.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("userinterest")
public class userInterest {
    @TableId(type= IdType.AUTO)
    private long id;
    private long uid;
    private String userName;
    private String userInterest11;
    private String userInterest12;
    private String userInterest13;
    private double Interestsco1;
    private String userInterest21;
    private String userInterest22;
    private String userInterest23;
    private double Interestsco2;
    private String userInterest31;
    private String userInterest32;
    private String userInterest33;
    private double Interestsco3;

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

    public String getUserInterest11() {
        return userInterest11;
    }

    public void setUserInterest11(String userInterest11) {
        this.userInterest11 = userInterest11;
    }

    public String getUserInterest12() {
        return userInterest12;
    }

    public void setUserInterest12(String userInterest12) {
        this.userInterest12 = userInterest12;
    }

    public String getUserInterest13() {
        return userInterest13;
    }

    public void setUserInterest13(String userInterest13) {
        this.userInterest13 = userInterest13;
    }

    public double getInterestsco1() {
        return Interestsco1;
    }

    public void setInterestsco1(double interestsco1) {
        Interestsco1 = interestsco1;
    }

    public String getUserInterest21() {
        return userInterest21;
    }

    public void setUserInterest21(String userInterest21) {
        this.userInterest21 = userInterest21;
    }

    public String getUserInterest22() {
        return userInterest22;
    }

    public void setUserInterest22(String userInterest22) {
        this.userInterest22 = userInterest22;
    }

    public String getUserInterest23() {
        return userInterest23;
    }

    public void setUserInterest23(String userInterest23) {
        this.userInterest23 = userInterest23;
    }

    public double getInterestsco2() {
        return Interestsco2;
    }

    public void setInterestsco2(double interestsco2) {
        Interestsco2 = interestsco2;
    }

    public String getUserInterest31() {
        return userInterest31;
    }

    public void setUserInterest31(String userInterest31) {
        this.userInterest31 = userInterest31;
    }

    public String getUserInterest32() {
        return userInterest32;
    }

    public void setUserInterest32(String userInterest32) {
        this.userInterest32 = userInterest32;
    }

    public String getUserInterest33() {
        return userInterest33;
    }

    public void setUserInterest33(String userInterest33) {
        this.userInterest33 = userInterest33;
    }

    public double getInterestsco3() {
        return Interestsco3;
    }

    public void setInterestsco3(double interestsco3) {
        Interestsco3 = interestsco3;
    }

    @Override
    public String toString() {
        return "userInterest{" +
                "id=" + id +
                ", uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userInterest11='" + userInterest11 + '\'' +
                ", userInterest12='" + userInterest12 + '\'' +
                ", userInterest13='" + userInterest13 + '\'' +
                ", Interestsco1=" + Interestsco1 +
                ", userInterest21='" + userInterest21 + '\'' +
                ", userInterest22='" + userInterest22 + '\'' +
                ", userInterest23='" + userInterest23 + '\'' +
                ", Interestsco2=" + Interestsco2 +
                ", userInterest31='" + userInterest31 + '\'' +
                ", userInterest32='" + userInterest32 + '\'' +
                ", userInterest33='" + userInterest33 + '\'' +
                ", Interestsco3=" + Interestsco3 +
                '}';
    }
}
