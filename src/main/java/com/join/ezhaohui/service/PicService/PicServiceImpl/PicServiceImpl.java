package com.join.ezhaohui.service.PicService.PicServiceImpl;

import com.join.ezhaohui.entity.pic.Pic;
import com.join.ezhaohui.mapper.picmapper.PicMapper;
import com.join.ezhaohui.service.PicService.PicService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Service
public class PicServiceImpl implements PicService {

    private PicMapper picMapper;

    @Autowired
    public void setPicMapper(PicMapper picMapper){
        this.picMapper = picMapper;
    }

    /**
     * 展示所有的轮播图
     * @return
     * @throws Exception
     */
    @Override
    public List<Pic> getAll() throws Exception{
        return picMapper.getAll();
    }

    /**
     * 插入新轮播图
     * @param pic
     * @param picture
     * @return
     * @throws Exception
     */
    @Override
    public boolean insertPic(Pic pic, MultipartFile picture) throws Exception{
        String path = "d:/";
        String filename = picture.getOriginalFilename();
        System.out.println(filename);
        if(filename == null){
            System.out.println("空字符串");
            return false;
        }
        String teal = filename.substring(filename.lastIndexOf("."));
        String finalfilename = path + pic.getId()+teal;
        File file = new File(finalfilename);
        System.out.println(finalfilename);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }

        try{
            picture.transferTo(file);
            pic.setPic_url(finalfilename);
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
            return false;
        }
        System.out.println(pic.getPic_url());
        return picMapper.insertPic(pic);
    }

    /**
     * 按id删除轮播图
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deletePic(Integer id) throws Exception{
        return picMapper.deletePic(id);
    }

    /**
     * 检查现在要修改的是不是已有的轮播图，是否确认修改
     * @param rank
     * @return
     * @throws Exception
     */
    @Override
    public boolean rankExist(Integer rank)throws Exception{
        return picMapper.rankExist(rank) != null;
    }

    @Override
    public boolean update(Pic pic)throws Exception{
        return picMapper.update(pic);
    }

}
