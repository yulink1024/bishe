package org.example.mapper;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.gouwuche;

import java.util.List;

@Mapper
public interface gouwucheMapper {

    @Select("select * from gouwuche where uid=#{uid}")
    List<gouwuche> GetByUid( long uid);

    @Insert("insert into gouwuche(uid,goodid,imgurl,goodsName,goodsNum,totalPrice,goodstips1,goodstips2,goodstips3) values(#{uid},#{goodid},#{imgurl},#{goodsName},#{goodsNum},#{totalPrice},#{goodstips1},#{goodstips2},#{goodstips3})")
    int Add(gouwuche gouwuchein);

    @Delete("delete from gouwuche where id=#{id}")
    int DeleteByid(long id);
}
