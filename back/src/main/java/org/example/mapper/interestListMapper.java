package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.interestList;

import java.util.List;

@Mapper
public interface interestListMapper {
    @Select("select * from interestlist order by rand() limit 6")
    List<interestList> SelectRanSix();
}
