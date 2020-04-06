package com.join.ezhaohui.controller;

import com.join.ezhaohui.entity.Info;
import com.join.ezhaohui.service.info.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author:ljx
 * @Date:2020/4/4
 * @Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/info")
public class InfoController {
    @Resource
    InfoService infoServiceImpl;
    
    //测试成功
    @RequestMapping("/multiSelect")
    public List<Info> multiSelect(Info info){
        return infoServiceImpl.multiSelect(info);
    }
    //测试成功
    @RequestMapping("/insert")
    public int insert(Info info){
        return infoServiceImpl.insert(info);
    }
    //测试成功
    @RequestMapping("/updateByPrimaryKeySelective")
    public int updateByPrimaryKeySelective(Info info){
        return infoServiceImpl.updateByPrimaryKeySelective(info);
    }
    //测试成功
    @RequestMapping("/deleteByPrimaryKey")
    public int deleteByPrimaryKey(int id){
        return infoServiceImpl.deleteByPrimaryKey(id);
    }
}
