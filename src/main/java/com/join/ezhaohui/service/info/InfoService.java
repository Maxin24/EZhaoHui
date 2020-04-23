package com.join.ezhaohui.service.info;

import com.join.ezhaohui.entity.Info;
import com.join.ezhaohui.entity.InfoExample;

import java.util.List;

/**
 * @Author:ljx
 * @Date:2020/4/4
 * @Description:
 */
public interface InfoService {
    public List<Info> multiSelectByPage(Info record,int pageNum,int pageSize);

    public List<Info> multiSelect(Info record);

    List<Info> multiFuzzySelect(Info record);

    long countByExample(InfoExample example);

    int deleteByExample(InfoExample example);

    int deleteByPrimaryKey(int id);

    int insert(Info record);

    int insertSelective(Info record);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(int id);

    int updateByExampleSelective(Info record, InfoExample example);

    int updateByExample(Info record,  InfoExample example);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}
