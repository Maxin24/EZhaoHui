package com.join.ezhaohui.service.PicService.PicServiceImpl;

import com.join.ezhaohui.entity.Pic;
import com.join.ezhaohui.mapper.PicMapper;
import com.join.ezhaohui.service.PicService.PicService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    public String insertPic(Pic pic, MultipartFile picture, HttpServletRequest request) throws Exception{

        String path = request.getServletContext().getRealPath("/static/");
        //path.replace("/",File.separator);
        String filename;
        try{
        filename = picture.getOriginalFilename();
        }catch (NullPointerException e){
            return "空文件";
        }
        /**
         * 文件上传类型判断
         */
        String finalfilename;
        String finalfilename1;
        String teal;
        assert filename != null;
        try{
            teal = filename.substring(filename.lastIndexOf("."));
        }catch (StringIndexOutOfBoundsException e){
            return "empty file";
        }
        if(teal.equals(".png") | teal.equals(".jpg") | teal.equals(".bmp") | teal.equals(".tif")){
            Integer hello = picMapper.getIdPre();
            finalfilename = path + hello +teal;
            String path1 = new String("http://jdall.nenu.edu.cn:8080/static/");
            finalfilename1 = path1 + hello + teal;
            pic.setDesc(teal);
        }else {
            return "图片格式错误";
        }
        File file = new File(finalfilename);
        System.out.println(finalfilename1);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdir();
        }
        try{
            picture.transferTo(file);
            pic.setPic_url(finalfilename1);
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
            return "上传出错";
        }
        System.out.println(pic.getPic_url());
        if(picMapper.insertPic(pic)){
            return "true";
        }else
            return "false";
    }

    /**
     * 按id删除轮播图
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public boolean deletePic(Integer id) throws Exception{
        Integer rank = picMapper.selectById(id).getRank();
        List<Pic> list = picMapper.getAll();
        if((!picMapper.getByDelete(rank)) && (list.size() != 1)){
            return false;
        }
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
    public boolean update(Pic pic,HttpServletRequest request)throws Exception{
        if (pic.getRank() != picMapper.selectById(pic.getId()).getRank()){
            picMapper.getByUpdate(pic.getRank(),picMapper.selectById(pic.getId()).getRank());
            return picMapper.update(pic);
            }
        else {
            return picMapper.update(pic);
        }
    }

    private boolean changeUrl(Integer new1,Integer old,String teal,HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/static/");
        String newFinalPath = path + new1 + teal;
        String oldFinalPath = path + old + teal;
        File file1 = new File(newFinalPath);
        File file2 = new File(oldFinalPath);
        if(!file2.renameTo(file1)){
            return false;
        }
        return true;
    }


}
