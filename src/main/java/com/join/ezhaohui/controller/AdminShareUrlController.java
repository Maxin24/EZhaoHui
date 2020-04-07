package com.join.ezhaohui.controller;

import com.join.ezhaohui.entity.ShareUrl;
import com.join.ezhaohui.service.shareurl.impl.ShareUrlServiceImpl;
import com.join.ezhaohui.utils.resultHander.CommonErrorEnum;
import com.join.ezhaohui.utils.resultHander.ResponseBean;
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

    @GetMapping("/showUrl")
    public Object listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<ShareUrl> all = shareUrlService.listShareUrl();
        return new ResponseBean(true,all,CommonErrorEnum.SUCCESS_OPTION);
    }

    @GetMapping("/updateState")
    public Object update(HttpServletResponse response, HttpServletRequest request, @RequestParam List<Integer> ids) throws Exception {
        for(int id : ids) {
            System.out.println(id);
            shareUrlService.fixShareUrlById(id);
        }
        return new ResponseBean(true,"", CommonErrorEnum.SUCCESS_OPTION);
    }

    @GetMapping("/deleteUrl")
    public Object delete(HttpServletRequest request,HttpServletResponse response,@RequestParam List<Integer> ids) throws Exception {
        for(int id : ids) {
            System.out.println(id);
            shareUrlService.fixShareUrlById(id);
        }
        return new ResponseBean(true,"", CommonErrorEnum.SUCCESS_OPTION);
    }


}
