package com.join.ezhaohui.mapper;

import com.join.ezhaohui.entity.Pic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PicMapper {
    List<Pic> getAll() throws Exception;
    boolean insertPic(Pic pic) throws Exception;
    boolean deletePic(@Param("id") Integer id) throws Exception;
    Pic rankExist(@Param("rank")Integer rank)throws Exception;
    boolean update(Pic pic)throws Exception;
}
