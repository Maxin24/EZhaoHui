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
    /**
     * 过于频繁封禁时间 30s
     */
    long restTime = 30;

    @Autowired
    ShareUrlService shareUrlService;

    @GetMapping("/upload")
    public Object upload() {
        return "Here is upload page";
    }

    @GetMapping("/insertUrl")
    public Object insertUrl(@RequestParam String url, HttpServletResponse response, HttpServletRequest request) throws Exception {

        int time = 0;
        Object object = request.getSession().getAttribute("time");
        if(object!=null){
            time = (int)object;
            System.out.println(time);
        }
        System.out.println(time);
        request.getSession().setAttribute("time",time+1);

        if(time > 10){
            Date timeStap = new Date();
            Object lastTime = request.getSession().getAttribute("frozeTime");
            if(lastTime == null)
                request.getSession().setAttribute("frozeTime",timeStap.getTime());

            if((timeStap.getTime() - (long)lastTime)/1000 >= restTime ){
                request.getSession().setAttribute("time",0);
            }
            else
                return new ResponseBean(false, String.valueOf(((timeStap.getTime() - (long)lastTime)/1000)), CommonErrorEnum.FILEUPLOAD_FAIL_MUCH);

        }


        ShareUrl shareUrl = new ShareUrl(url);
        int flag = shareUrlService.addShareUrl(shareUrl);
        if (flag == 1)
            return new ResponseBean(true, "022", CommonErrorEnum.FILEUPLOAD_SUCCESS);
        else if (flag == 4)
            return new ResponseBean(false, "022_4", CommonErrorEnum.FILEUPLOAD_FAIL_URL);
        else if (flag == 5)
            return new ResponseBean(false, "022_5", CommonErrorEnum.FILEUPLOAD_FAIL_SAME);
        else
           return  new ResponseBean(false, "022_0", CommonErrorEnum.FILEUPLOAD_FAIL);
    }
}
