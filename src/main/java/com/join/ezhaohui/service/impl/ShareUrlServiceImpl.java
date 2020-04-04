package com.join.ezhaohui.service.impl;


import com.join.ezhaohui.entity.ShareUrl;
import com.join.ezhaohui.mapper.ShareUrlMapper;
import com.join.ezhaohui.service.ShareUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;


@Service
public class ShareUrlServiceImpl implements ShareUrlService {

    @Autowired
    ShareUrlMapper shareUrlMapper;

    @Override
    public int addShareUrl(ShareUrl shareUrl) throws Exception {

        /**
         *  相同url 不上传
         */
        if(shareUrlMapper.selectByUrl(shareUrl.getUrl())!=null){
            return 5;
        }

        /**
         * 上传时间
         */
        Date time = new Date(System.currentTimeMillis());
        shareUrl.setUploadTime(time);
        try{
            URL url = new URL(shareUrl.getUrl());
            InputStream stream = url.openStream();
        }catch (Exception e){
            System.out.println("wrong url");
            return 4;
        }
       return  shareUrlMapper.insert(shareUrl);
    }

    @Override
    public int deleteShareUrl(int id) throws Exception {
        return shareUrlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ShareUrl searchShareUrlById(int id) throws Exception {
        return shareUrlMapper.selectByPrimaryKey(id);
    }

    @Override
    public ShareUrl searchShareUrlByUrl(String url) throws Exception {
        return shareUrlMapper.selectByUrl(url);
    }
}
