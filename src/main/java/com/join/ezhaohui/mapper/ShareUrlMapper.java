package com.join.ezhaohui.mapper;

import com.join.ezhaohui.entity.ShareUrl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ShareUrlMapper {
    int deleteByPrimaryKey(int id);

    int insert(ShareUrl record);

    int insertSelective(ShareUrl record);

    ShareUrl selectByPrimaryKey(int id);

    ShareUrl selectByUrl(String Url);

    int updateByPrimaryKeySelective(ShareUrl record);

    int updateByPrimaryKey(ShareUrl record);
}
