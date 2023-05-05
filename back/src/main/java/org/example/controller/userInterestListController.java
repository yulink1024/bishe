package org.example.controller;

import org.example.mapper.userInterestListMapper;
import org.example.mapper.userInterestMapper;
import org.example.pojo.userinterestlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class userInterestListController {
    @Autowired
    userInterestListMapper userInterestListmapper;

    @Autowired
    userInterestMapper userInterestmapper;

    @PostMapping("/addclick")
    public boolean addClick(@RequestBody userinterestlist userinterestlistin){
        userinterestlistin.setInterestsco(1.00);
        if(userInterestListmapper.SelectIsSaved(userinterestlistin)>0){//查询是否已存在
            userinterestlist userinterestlistinfo=userInterestListmapper.SelectSavedmes(userinterestlistin);//获取已经存在的数据
            userinterestlistinfo.setInterestsco(userinterestlistinfo.getInterestsco()+1);//将已经存在的数据的分数+1（点击得分）
            int res1=userInterestListmapper.updateInterestSco(userinterestlistinfo);//将更改后的数据更新至数据库
            if(res1>0){
                List<userinterestlist> userinterestlists=userInterestListmapper.SelectTop3(userinterestlistin.getUid());//查询更新后的前三
                userInterestmapper.UpdateFirst(userinterestlists.get(0));
                userInterestmapper.UpdateSecond(userinterestlists.get(1));
                userInterestmapper.UpdateThird(userinterestlists.get(2));
                return true;
            }else {
                return false;
            }
        }
        else{
            int res2=userInterestListmapper.AddUIList(userinterestlistin);//查询不存在时插入数据
            if(res2>0){
                return true;
            }else {
                return false;
            }
        }
    }

    @PostMapping("/addGouwu")
    public boolean addGouwu(@RequestBody userinterestlist userinterestlistin){
        userinterestlist userinterestlistinfo=userInterestListmapper.SelectSavedmes(userinterestlistin);//获取已经存在的数据
        userinterestlistinfo.setInterestsco(userinterestlistinfo.getInterestsco()+8);//将已经存在的数据的分数+8（添加购物车得分）
        int res1=userInterestListmapper.updateInterestSco(userinterestlistinfo);//将更改后的数据更新至数据库
        if(res1>0){
            List<userinterestlist> userinterestlists=userInterestListmapper.SelectTop3(userinterestlistin.getUid());//查询更新后的前三
            userInterestmapper.UpdateFirst(userinterestlists.get(0));
            userInterestmapper.UpdateSecond(userinterestlists.get(1));
            userInterestmapper.UpdateThird(userinterestlists.get(2));
            return true;
        }else {
            return false;
        }
    }

    @PostMapping("/addGoumai")
    public boolean addGoumai(@RequestBody userinterestlist userinterestlistin){
        userinterestlist userinterestlistinfo=userInterestListmapper.SelectSavedmes(userinterestlistin);//获取已经存在的数据
        userinterestlistinfo.setInterestsco((userinterestlistinfo.getInterestsco()+22)/3);//将已经存在的数据的分数+22（购买得分）
        int res1=userInterestListmapper.updateInterestSco(userinterestlistinfo);//将更改后的数据更新至数据库
        if(res1>0){
            List<userinterestlist> userinterestlists=userInterestListmapper.SelectTop3(userinterestlistin.getUid());//查询更新后的前三
            userInterestmapper.UpdateFirst(userinterestlists.get(0));
            userInterestmapper.UpdateSecond(userinterestlists.get(1));
            userInterestmapper.UpdateThird(userinterestlists.get(2));
            return true;
        }else {
            return false;
        }
    }
}
