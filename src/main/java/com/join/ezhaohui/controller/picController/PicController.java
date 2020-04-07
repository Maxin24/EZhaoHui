package com.join.ezhaohui.controller.picController;

import com.join.ezhaohui.entity.pic.Pic;
import com.join.ezhaohui.service.PicService.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
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
    public boolean insertPic(String url, MultipartFile picture, int rank) throws Exception{
        Pic pic = new Pic();
        pic.setUrl(url);
        pic.setRank(rank);
        if(picService.rankExist(rank)) {
            return false;
        }
        return picService.insertPic(pic,picture);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean deletePic(Integer id) throws Exception{
        return picService.deletePic(id);
    }

    @ResponseBody
    @RequestMapping("/rankExist")
    public boolean rankRepeat(Integer rank) throws Exception{
        return picService.rankExist(rank);
    }

    @ResponseBody
    @RequestMapping("/update")
    public boolean update(Integer id,String url,Integer rank)throws Exception{
        Pic pic = new Pic();
        pic.setId(id);
        pic.setUrl(url);
        pic.setRank(rank);
        return picService.update(pic);
    }

}
