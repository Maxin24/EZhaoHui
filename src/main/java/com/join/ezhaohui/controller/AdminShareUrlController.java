package com.join.ezhaohui.controller;

import com.join.ezhaohui.entity.Info;
import com.join.ezhaohui.entity.ShareUrl;
import com.join.ezhaohui.service.info.impl.InfoServiceImpl;
import com.join.ezhaohui.service.shareurl.impl.ShareUrlServiceImpl;
import com.join.ezhaohui.utils.resultHander.CommonErrorEnum;
import com.join.ezhaohui.utils.resultHander.ResponseBean;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminShareUrlController {
    @Autowired
    ShareUrlServiceImpl shareUrlService;

    @Autowired
    InfoServiceImpl infoService;

    @RequestMapping("/showUrl")
    public Object listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<ShareUrl> all = shareUrlService.listShareUrl();
        return new ResponseBean(true,all,CommonErrorEnum.SUCCESS_OPTION);
    }

    @RequestMapping("/updateState")
    public Object update(HttpServletResponse response, HttpServletRequest request, @RequestParam List<Integer> ids) throws Exception {
        for(int id : ids) {
            System.out.println(id);
            shareUrlService.fixShareUrlById(id);
        }
        return new ResponseBean(true,"", CommonErrorEnum.SUCCESS_OPTION);
    }

    @RequestMapping("/deleteUrl")
    public Object delete(HttpServletRequest request,HttpServletResponse response,@RequestParam List<Integer> ids) throws Exception {
        for(int id : ids) {
            System.out.println(id);
            shareUrlService.deleteShareUrl(id);
        }
        return new ResponseBean(true,"", CommonErrorEnum.SUCCESS_OPTION);
    }

    @RequestMapping("/fuzzyUrl")
    public Object selectFuzzy(HttpServletRequest request,HttpServletResponse response,@RequestParam String msg,@RequestParam String position,@RequestParam String type){
        Info data = new Info();
        data.setUrl(msg);
        data.setPosition(position);
        data.setType(type);
        List<Info> datas = infoService.multiFuzzySelect(data);
        return new ResponseBean(true,datas,CommonErrorEnum.SUCCESS_OPTION);
    }
}
