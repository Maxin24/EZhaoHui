package com.join.ezhaohui.controller;


import com.join.ezhaohui.entity.ShareUrl;
import com.join.ezhaohui.service.ShareUrlService;
import com.join.ezhaohui.utils.resultHander.CommonErrorEnum;
import com.join.ezhaohui.utils.resultHander.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@RestController
@RequestMapping("/home")
@CrossOrigin
public class ShareUrlController {

    @Autowired
    ShareUrlService shareUrlService;

    @GetMapping("/upload")
    public Object upload() {
        return "Here is upload page";
    }

    @GetMapping("/insertUrl")
    public Object insertUrl(@RequestParam String url, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) throws Exception {
        int flag;
        System.out.println("insertUrl");
        ShareUrl shareUrl = new ShareUrl(url);
        flag = shareUrlService.addShareUrl(shareUrl);
        if (flag == 1)
            return new ResponseBean(true, "022", CommonErrorEnum.FILEUPLOAD_SUCCESS);
        else if (flag == 3)
            return new ResponseBean(false, "022_3", CommonErrorEnum.FILEUPLOAD_FAIL_MUCH);
        else if (flag == 4)
            return new ResponseBean(false, "022_4", CommonErrorEnum.FILEUPLOAD_FAIL_URL);
        else if (flag == 5)
            return new ResponseBean(false, "022_5", CommonErrorEnum.FILEUPLOAD_FAIL_SAME);
        else
           return  new ResponseBean(false, "022_0", CommonErrorEnum.FILEUPLOAD_FAIL);
    }
}
