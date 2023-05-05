package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.goodsInfo;
import org.example.pojo.userInterest;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("select * from goodsinfo")
    List<goodsInfo> SelectALL();

    @Select("select * from goodsinfo order by hotpoint desc limit 5")
    List<goodsInfo> SelectByhotpoint();

    @Select("select * from goodsinfo where id=#{id}")
    goodsInfo SelectById(long id);

    @Select("select * from goodsinfo where goodstips1=#{userInterest11} and goodstips2=#{userInterest12} and goodstips3=#{userInterest13} order by rand() limit 1")
    goodsInfo SelectByFirstInterestFir(userInterest userInterestin);//第一标签三个标签全部符合（一条）

    @Select("select * from goodsinfo where goodstips1=#{userInterest11} and goodstips2=#{userInterest12} order by rand() limit 2")
    List<goodsInfo> SelectByFirstInterestSec(userInterest userInterestin);//第一标签前两标签符合（两条）

    @Select("select * from goodsinfo where goodstips1=#{userInterest11} order by rand() limit 1")
    goodsInfo SelectByFirstInterestThi(userInterest userInterestin);//第一标签第一个标签符合（一条）

    @Select("select * from goodsinfo where goodstips1=#{userInterest21} and goodstips2=#{userInterest22} and goodstips3=#{userInterest23} order by rand() limit 1")
    goodsInfo SelectBySecondInterestFir(userInterest userInterestin);//第二标签三个标签全部符合（一条）

    @Select("select * from goodsinfo where goodstips1=#{userInterest21} and goodstips2=#{userInterest22} order by rand() limit 1")
    goodsInfo SelectBySecondInterestSec(userInterest userInterestin);//第二标签前两个标签全部符合（一条）

    @Select("select * from goodsinfo where goodstips1=#{userInterest21} order by rand() limit 1")
    goodsInfo SelectBySecondInterestThi(userInterest userInterestin);//第二标签第一条标签符合（一条）

    @Select("select * from goodsinfo where goodstips1=#{userInterest31} and goodstips2=#{userInterest32} and goodstips3=#{userInterest33} order by rand() limit 1")
    goodsInfo SelectByThirdInterestFir(userInterest userInterestin);//第三标签三个标签全部符合（一条）

    @Select("select * from goodsinfo where goodstips1=#{userInterest31} and goodstips2=#{userInterest32} order by rand() limit 1")
    goodsInfo SelectByThirdInterestSec(userInterest userInterestin);//第三标签前两个标签符合(一条)

    @Select("select * from goodsinfo where goodstips1=#{userInterest11} order by rand() limit 3")
    List<goodsInfo> SelectByFirGetThree(userInterest userInterestin);//第一标签三条

    @Select("select * from goodsinfo where goodstips1=#{userInterest21} order by rand() limit 3")
    List<goodsInfo> SelectBySecGetThree(userInterest userInterestin);//第二标签三条

    @Select("select * from goodsinfo where goodstips1=#{userInterest31} order by rand() limit 3")
    List<goodsInfo> SelectByThirGetThree(userInterest userInterestin);//第三标签三条

    @Select("select * from goodsinfo order by rand() limit 1")
    goodsInfo SelectRandom();//随机一条

    @Select("select * from goodsinfo order by rand() limit 10")
    List<goodsInfo> SelectRandom10();//随机十条
}
