package com.join.ezhaohui.controller.picController;

import com.join.ezhaohui.entity.pic.Pic;
import com.join.ezhaohui.service.PicService.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pic")
public class PicController {
    @Autowired
    private PicService picService;

    @RequestMapping("/getAll")
    public Pic getAll() throws Exception{
        return picService.getAll();
    }

    @RequestMapping("/insertPic")
    public boolean insertPic(String desc,String url,String pic_url) throws Exception{
        Pic pic = new Pic();
        pic.setDesc(desc);
        pic.setPic_url(pic_url);
        pic.setUrl(url);
        return picService.insertPic(pic);
    }
}
