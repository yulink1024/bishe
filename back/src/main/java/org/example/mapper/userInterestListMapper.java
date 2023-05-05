package org.example.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.userinterestlist;

import java.util.List;

@Mapper
public interface userInterestListMapper {

    @Insert("insert into userinterestlist(uid,userName,userInterest1,userInterest2,userInterest3,Interestsco) values (#{uid},#{userName},#{userInterest1},#{userInterest2},#{userInterest3},#{Interestsco})")
    int AddUIList(userinterestlist userinterestlistin);

    @Update("update userinterestlist set Interestsco=#{Interestsco} where id=#{id}")
    int updateInterestSco(userinterestlist userinterestlistin);

    @Select("select count(*) from userinterestlist where uid=#{uid} and userInterest1=#{userInterest1} and userInterest2=#{userInterest2} and userInterest3=#{userInterest3}")
    int SelectIsSaved(userinterestlist userinterestlistin);

    @Select("select * from userinterestlist where uid=#{uid} and userInterest1=#{userInterest1} and userInterest2=#{userInterest2} and userInterest3=#{userInterest3}")
    userinterestlist SelectSavedmes(userinterestlist userinterestlistin);

    @Select("select * from userinterestlist where uid=#{uid} order by Interestsco desc limit 3")
    List<userinterestlist> SelectTop3(long uid);
}
