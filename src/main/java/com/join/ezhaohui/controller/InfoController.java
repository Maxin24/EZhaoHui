package com.join.ezhaohui.controller;

import com.join.ezhaohui.entity.Info;
import com.join.ezhaohui.service.info.InfoService;
import com.join.ezhaohui.utils.resultHander.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
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


    @RequestMapping("/multiSelect")
    public Object multiSelect(Info info){
        return infoServiceImpl.multiSelect(info);
    }

    @RequestMapping("/multiSelectByPage")
    public Object multiSelectByPage(Info info,int pageNum,int pageSize){
        return infoServiceImpl.multiSelectByPage(info,pageNum,pageSize);
    }

    @RequestMapping("/insert")
    public Object insert(Info info){
        //默认设置一个遥远的过期时间
        if(info.getExpirationTime()==null){
            info.setExpirationTime(new Timestamp((long)2000000000*1000));
        }
        return infoServiceImpl.insert(info);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    public Object updateByPrimaryKeySelective(Info info){
        return infoServiceImpl.updateByPrimaryKeySelective(info);
    }

    @RequestMapping("/deleteByPrimaryKey")
    public Object deleteByPrimaryKey(int id){
        return infoServiceImpl.deleteByPrimaryKey(id);
    }
}
