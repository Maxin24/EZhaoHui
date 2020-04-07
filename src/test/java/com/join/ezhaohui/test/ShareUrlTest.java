package com.join.ezhaohui.test;

import com.join.ezhaohui.EzhaohuiApplication;
import com.join.ezhaohui.entity.ShareUrl;
import com.join.ezhaohui.service.shareurl.impl.ShareUrlServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EzhaohuiApplication.class)
public class ShareUrlTest {
    @Autowired
    ShareUrlServiceImpl shareUrlService;

    @Test
    public void test() throws Exception{
        System.out.println("hello tests");
    }

    @Test
    public void testAddUrl() throws Exception{
        Date time = new Date(System.currentTimeMillis());
        ShareUrl shareUrl = new ShareUrl("hello the fucking world");
        shareUrlService.addShareUrl(shareUrl);
    }

    @Test
    public void testSelectUrl() throws Exception{
        ShareUrl url = shareUrlService.searchShareUrlByUrl("hello the fucking world");
        System.out.println(url.toString());
    }

    @Test
    public void testfixUrl() throws Exception{
        shareUrlService.fixShareUrlById(2);
    }

    @Test
    public void testListAll() throws Exception{
        List<ShareUrl> list = shareUrlService.listShareUrl();
        for(ShareUrl url : list){
            System.out.println(url.toString());
        }
    }

    @Test
    public void testDelete() throws Exception{
        shareUrlService.deleteShareUrl(1);
    }

}
