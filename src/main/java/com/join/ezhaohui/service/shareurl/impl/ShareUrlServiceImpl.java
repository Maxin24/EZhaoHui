package com.join.ezhaohui.service.shareurl.impl;


import com.join.ezhaohui.entity.ShareUrl;
import com.join.ezhaohui.mapper.ShareUrlMapper;
import com.join.ezhaohui.service.shareurl.ShareUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;


@Service
public class ShareUrlServiceImpl implements ShareUrlService {

    @Autowired
    ShareUrlMapper shareUrlMapper;

    /**
     * 添加 url 至 t_share_url
     * @param shareUrl
     * @return
     * @throws Exception
     */
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

    /**
     * 根据url id 删除
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int deleteShareUrl(int id) throws Exception {
        return shareUrlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ShareUrl searchShareUrlById(int id) throws Exception {
        return shareUrlMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据url 搜索t_share_url
     * @param url
     * @return
     * @throws Exception
     */
    @Override
    public ShareUrl searchShareUrlByUrl(String url) throws Exception {
        return shareUrlMapper.selectByUrl(url);
    }

    /**
     * 审阅完毕后处理 t_share_url state 设置为 1【已阅】
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public int fixShareUrlById(int id) throws Exception {
        ShareUrl url = new ShareUrl(id,1);
        return shareUrlMapper.updateByPrimaryKey(url);
    }

    @Override
    public List<ShareUrl> listShareUrl()throws Exception{
        return shareUrlMapper.selectAll();
    }
}
