package com.join.ezhaohui.service.PicService.PicServiceImpl;

import com.join.ezhaohui.entity.pic.Pic;
import com.join.ezhaohui.mapper.picmapper.PicMapper;
import com.join.ezhaohui.service.PicService.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicServiceImpl implements PicService {

    private PicMapper picMapper;

    @Autowired
    public void setPicMapper(PicMapper picMapper){
        this.picMapper = picMapper;
    }

    @Override
    public Pic getAll() throws Exception{
        return picMapper.getAll();
    }

    @Override
    public boolean insertPic(Pic pic) throws Exception{
        return picMapper.insertPic(pic);
    }
}
