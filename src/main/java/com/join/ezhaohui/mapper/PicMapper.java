package com.join.ezhaohui.mapper;

import com.join.ezhaohui.entity.Pic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface PicMapper {
    List<Pic> getAll() throws Exception;
    boolean insertPic(Pic pic) throws Exception;
    boolean deletePic(@Param("id") Integer id) throws Exception;
    Pic rankExist(@Param("rank")Integer rank)throws Exception;
    boolean update(Pic pic)throws Exception;
    Pic selectById(@Param("id")Integer id) throws Exception;
    boolean getByDelete(@Param("rank")Integer rank)throws Exception;
    boolean getByUpdate(@Param("rank")Integer rank,@Param("rank1")Integer rank1)throws Exception;
    Integer getIdPre()throws Exception;
}
