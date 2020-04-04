package com.join.ezhaohui.service.info.impl;

import com.join.ezhaohui.entity.Info;
import com.join.ezhaohui.entity.InfoExample;
import com.join.ezhaohui.mapper.InfoMapper;
import com.join.ezhaohui.service.info.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:ljx
 * @Date:2020/4/4
 * @Description:
 */
@Service
public class InfoServiceImpl implements InfoService {
    @Autowired
    InfoMapper infoMapper;
    @Override
    public List<Info> multiSelect(Info record) {
        return infoMapper.multiSelect(record);
    }

    @Override
    public long countByExample(InfoExample example) {
        return 0;
    }

    @Override
    public int deleteByExample(InfoExample example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return infoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Info record) {
        return infoMapper.insert(record);
    }

    @Override
    public int insertSelective(Info record) {
        return infoMapper.insertSelective(record);
    }

    @Override
    public List<Info> selectByExample(InfoExample example) {
        return null;
    }

    @Override
    public Info selectByPrimaryKey(int id) {
        return selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Info record, InfoExample example) {
        return 0;
    }

    @Override
    public int updateByExample(Info record, InfoExample example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(Info record) {
        return infoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Info record) {
        return infoMapper.updateByPrimaryKeySelective(record);
    }
}
