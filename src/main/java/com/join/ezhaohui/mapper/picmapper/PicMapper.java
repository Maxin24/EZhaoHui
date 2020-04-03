package com.join.ezhaohui.mapper.picmapper;

import com.join.ezhaohui.entity.pic.Pic;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PicMapper {
    public Pic getAll() throws Exception;
    public boolean insertPic(Pic pic) throws Exception;
}
