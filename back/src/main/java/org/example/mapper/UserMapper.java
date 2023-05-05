package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.pojo.RegisterUser;
import org.example.pojo.userinfo;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into userinfo(id,userName,userNumber,userPassword) values(#{id},#{userName},#{userNumber},#{userPassword})")
    int add(RegisterUser registerUser);//用户注册

    @Select("select * from userinfo")//查询所有用户信息
    List<userinfo> GetAll();

    @Select("select * from userinfo where userNumber=#{userNumber}")//用户登陆
    userinfo SelectByNum(String userNumber);

    @Delete("delete from userinfo where id=#{id}")//用户注销
    int deleteByID(long id);

    @Update("update userinfo set userName=#{userName}, userAddress=#{userAddress}, userPassword=#{userPassword}, gender=#{gender},age=#{age} where id=#{id}")
    int upDate(userinfo userinfoo);//完善用户信息

    @Update("update userinfo set isNew=#{isnew} where id=#{id}")
    int updateIsNew(userinfo userinfoo);

}
