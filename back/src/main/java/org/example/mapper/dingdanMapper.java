package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.dingdan;

import java.util.List;

@Mapper
public interface dingdanMapper {

    @Insert("insert into dingdan(uid,gid,imgurl,goodsName,goodsNum,totalPrice,userAddress) values(#{uid},#{gid},#{imgurl},#{goodsName},#{goodsNum},#{totalPrice},#{userAddress})")
    int Add(dingdan dingdanin);

    @Select("select * from dingdan where uid=#{uid}")
    List<dingdan> SelectByuid(long uid);
}
