package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.userInterest;
import org.example.pojo.userinterestlist;

@Mapper
public interface userInterestMapper {

    @Insert("insert into userinterest(uid,userName,userInterest11,Interestsco1,userInterest21,Interestsco2,userInterest31,Interestsco3) values(#{uid},#{userName},#{userInterest11},#{Interestsco1},#{userInterest21},#{Interestsco2},#{userInterest31},#{Interestsco3})")
    int add(userInterest userinter);

    @Select("select * from userinterest where uid=#{uid}")
    userInterest SelectByUid(long uid);

    @Update("update userinterest set userInterest11=#{userInterest1},userInterest12=#{userInterest2},userInterest13=#{userInterest3},Interestsco1=#{Interestsco} where uid=#{uid}")
    void UpdateFirst(userinterestlist userinterestlistin);

    @Update("update userinterest set userInterest21=#{userInterest1},userInterest22=#{userInterest2},userInterest23=#{userInterest3},Interestsco2=#{Interestsco} where uid=#{uid}")
    void UpdateSecond(userinterestlist userinterestlistin);

    @Update("update userinterest set userInterest31=#{userInterest1},userInterest32=#{userInterest2},userInterest33=#{userInterest3},Interestsco3=#{Interestsco} where uid=#{uid}")
    void UpdateThird(userinterestlist userinterestlistin);
}
