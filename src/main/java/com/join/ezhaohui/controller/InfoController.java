package com.join.ezhaohui.controller;

import com.join.ezhaohui.entity.Info;
import com.join.ezhaohui.service.info.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:ljx
 * @Date:2020/4/4
 * @Description:
 */
@Controller
@CrossOrigin
@RequestMapping("/info")
public class InfoController {
    @Autowired
    InfoService infoService;

    //测试成功
    @RequestMapping("/multiSelect")
    public List<Info> multiSelect(Info info){
        return infoService.multiSelect(info);
    }
    //测试成功
    @RequestMapping("/insert")
    public int insert(Info info){
        return infoService.insert(info);
    }
    //测试成功
    @RequestMapping("/updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(Info info){
        return infoService.updateByPrimaryKeySelective(info);
    }
    //测试成功
    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(int id){
        return infoService.deleteByPrimaryKey(id);
    }
}
