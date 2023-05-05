package org.example.controller;

import org.example.mapper.userInterestListMapper;
import org.example.mapper.userInterestMapper;
import org.example.pojo.userInterest;
import org.example.pojo.userinfo;
import org.example.pojo.userinterestlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*","null"})
public class UserInterestController {

    @Autowired
    private userInterestMapper userinterestmapper;

    @Autowired
    userInterestListMapper userInterestListmapper;
    @PostMapping("/setUserInterest")
    public boolean SetUserInterest(@RequestBody userInterest userinterest){
        userinterest.setInterestsco1(5.00);
        userinterest.setInterestsco2(5.00);
        userinterest.setInterestsco3(5.00);
        int res=userinterestmapper.add(userinterest);
        //将第一标签加入用户标签列表
        userinterestlist userinterestlistin1=new userinterestlist();
        userinterestlistin1.setUid(userinterest.getUid());
        userinterestlistin1.setUserInterest1(userinterest.getUserInterest11());
        userinterestlistin1.setInterestsco(userinterest.getInterestsco1());
        int res2=userInterestListmapper.AddUIList(userinterestlistin1);
        //将第二标签加入用户标签列表
        userinterestlist userinterestlistin2=new userinterestlist();
        userinterestlistin2.setUid(userinterest.getUid());
        userinterestlistin2.setUserInterest1(userinterest.getUserInterest21());
        userinterestlistin2.setInterestsco(userinterest.getInterestsco2());
        int res3=userInterestListmapper.AddUIList(userinterestlistin2);
        //将第二标签加入用户标签列表
        userinterestlist userinterestlistin3=new userinterestlist();
        userinterestlistin3.setUid(userinterest.getUid());
        userinterestlistin3.setUserInterest1(userinterest.getUserInterest31());
        userinterestlistin3.setInterestsco(userinterest.getInterestsco3());
        int res4=userInterestListmapper.AddUIList(userinterestlistin3);
        if(res>0){
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/GetByUid")
    public userInterest GetUserInterest(@RequestBody userInterest userInterestin){
        userInterest userinterest=userinterestmapper.SelectByUid(userInterestin.getUid());
        return userinterest;
    }
}
