package com.join.ezhaohui.controller;

import com.join.ezhaohui.entity.Pic;
import com.join.ezhaohui.service.PicService.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/pic")
public class PicController {

    @Autowired
    private PicService picService;

    @ResponseBody
    @RequestMapping("/getAll")
    public List<Pic> getAll() throws Exception{
        return picService.getAll();
    }

    @ResponseBody
    @RequestMapping("/insertPic")
    public Object insertPic(String url, MultipartFile picture, int rank, HttpServletRequest request) throws Exception{
        Pic pic = new Pic();
        pic.setUrl(url);
        pic.setRank(rank);
        if(picService.rankExist(rank)) {
            return new String("已经存在对应rank轮播图");
        }
        return new String(picService.insertPic(pic,picture,request));
    }

    @ResponseBody
    @RequestMapping("/delete")
    public Object deletePic(Integer id) throws Exception{
        if (id == null){
            return new String("空值！");
        }
        return new String(String.valueOf(picService.deletePic(id)));
    }

    @ResponseBody
    @RequestMapping("/rankExist")
    public boolean rankRepeat(Integer rank) throws Exception{
        return picService.rankExist(rank);
    }

    @ResponseBody
    @RequestMapping("/update")
    public boolean update(Integer id,String url,Integer rank,HttpServletRequest request)throws Exception{
        Pic pic = new Pic();
        pic.setId(id);
        pic.setUrl(url);
        pic.setRank(rank);
        return picService.update(pic,request);
    }

}
