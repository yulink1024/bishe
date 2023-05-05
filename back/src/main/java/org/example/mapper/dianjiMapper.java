package org.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.example.pojo.dianji;

@Mapper
public interface dianjiMapper {

    @Insert("insert into dianji (uid,gid,clicknum) values (#{uid},#{gid},#{clicknum})")
    int Add(dianji dianjiin);

    @Update("update dianji set clicknum=#{clicknum} where uid=#{uid} and gid=#{gid}")
    int updateNum(dianji dianjiin);

    @Select("select * from dianji where uid=#{uid} and gid=#{gid}")
    dianji getDianji(dianji dianjiin);

    @Select("select count(*) from dianji where uid=#{uid} and gid=#{gid}")
    int Issaved(dianji dianjiin);


}
