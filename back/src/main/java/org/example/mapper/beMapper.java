package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.groupby;

import java.util.List;


@Mapper
public interface beMapper {

    @Select("select uid,count(*) as count from userbehavior where xingwei=#{xingwei} GROUP BY uid")
    List<groupby> GetNum(String xingwei);

    @Select("select uid,count(*) as count from userbehavior where xingwei!=#{xingwei1} GROUP BY uid")
    List<groupby> GetNumbe(String xingwei);

    @Select("select count(*) from userbehavior where xingwei=#{xingwei}")
    double GetNumber(String xingwei);
}
