package com.join.ezhaohui.mapper.picmapper;

import com.join.ezhaohui.entity.pic.Pic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PicMapper {
    List<Pic> getAll() throws Exception;
    boolean insertPic(Pic pic) throws Exception;
    boolean deletePic(@Param("id") Integer id) throws Exception;
    Pic rankExist(@Param("rank")Integer rank)throws Exception;
}
