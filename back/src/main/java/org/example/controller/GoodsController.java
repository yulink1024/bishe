package org.example.controller;

import org.example.mapper.GoodsMapper;
import org.example.mapper.userInterestMapper;
import org.example.pojo.goodsInfo;
import org.example.pojo.userInterest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"*","null"})
public class GoodsController {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private userInterestMapper userInterestmapper;

    @GetMapping("/getGoodsinfor")
    public List<goodsInfo> GetAllGoods(){
        List<goodsInfo> goodsInfos=goodsMapper.SelectALL();
        return goodsInfos;
    }

    @GetMapping("/getTop")
    public List<goodsInfo> GetTop(){
        List<goodsInfo> goodsInfos=goodsMapper.SelectByhotpoint();
        return goodsInfos;
    }

    @PostMapping("/GetDetail")
    public goodsInfo GetDetail(@RequestBody goodsInfo goodsInfor){
        goodsInfo goodsInform=goodsMapper.SelectById(goodsInfor.getId());
        return goodsInform;
    }

    @PostMapping("/GetSuggest")
    public List<goodsInfo> GetSuggest(@RequestBody userInterest userInteresti){
        userInterest userInterestin=userInterestmapper.SelectByUid(userInteresti.getUid());//根据传入的uid获取用户标签
        List<goodsInfo> goodsInfos=new ArrayList<>();
        if(userInterestin.getUserInterest12()!=null && userInterestin.getUserInterest22()!=null && userInterestin.getUserInterest32()!=null) {
            goodsInfo goodsInfom = goodsMapper.SelectByFirstInterestFir(userInterestin);//第一标签1
            goodsInfos.add(goodsInfom);
            List<goodsInfo> res = goodsMapper.SelectByFirstInterestSec(userInterestin);//第一标签2
            goodsInfos.addAll(res);
            goodsInfom = goodsMapper.SelectByFirstInterestThi(userInterestin);//第一标签3
            goodsInfos.add(goodsInfom);
            goodsInfom = goodsMapper.SelectBySecondInterestFir(userInterestin);//第二标签1
            goodsInfos.add(goodsInfom);
            goodsInfom = goodsMapper.SelectBySecondInterestSec(userInterestin);//第二标签2
            goodsInfos.add(goodsInfom);
            goodsInfom = goodsMapper.SelectBySecondInterestThi(userInterestin);//第二标签3
            goodsInfos.add(goodsInfom);
            goodsInfom = goodsMapper.SelectByThirdInterestFir(userInterestin);//第三标签1
            goodsInfos.add(goodsInfom);
            goodsInfom = goodsMapper.SelectByThirdInterestSec(userInterestin);//第三标签2
            goodsInfos.add(goodsInfom);
            goodsInfom = goodsMapper.SelectRandom();//随机一条
            goodsInfos.add(goodsInfom);
            return goodsInfos;
        }else{
            List<goodsInfo> res1 =goodsMapper.SelectByFirGetThree(userInterestin);
            goodsInfos.addAll(res1);
            List<goodsInfo> res2 =goodsMapper.SelectBySecGetThree(userInterestin);
            goodsInfos.addAll(res2);
            List<goodsInfo> res3 =goodsMapper.SelectByThirGetThree(userInterestin);
            goodsInfos.addAll(res3);
            goodsInfo res=goodsMapper.SelectRandom();
            goodsInfos.add(res);
            return goodsInfos;
        }
    }

    @GetMapping("/GetRandomSuggest")
    public List<goodsInfo> GetRandomSuggest(){
        List<goodsInfo> goodsInfos=goodsMapper.SelectRandom10();
        return goodsInfos;
    }
}
