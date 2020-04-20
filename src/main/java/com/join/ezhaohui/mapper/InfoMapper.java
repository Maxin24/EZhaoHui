package com.join.ezhaohui.mapper;

import com.join.ezhaohui.entity.Info;
import com.join.ezhaohui.entity.InfoExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * InfoMapper继承基类
 */

@Mapper
public interface InfoMapper extends MyBatisBaseDao<Info, Integer, InfoExample> {
    public List<Info> multiSelect(Info record);

    public List<Info> multiFuzzySelect(Info record);
}