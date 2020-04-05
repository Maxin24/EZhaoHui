package com.join.ezhaohui.service;

import com.join.ezhaohui.entity.ShareUrl;

public interface  ShareUrlService {

    public int addShareUrl(ShareUrl shareUrl) throws Exception;

    public int deleteShareUrl(int id) throws Exception;

    public ShareUrl searchShareUrlById(int id)throws Exception;

    public ShareUrl searchShareUrlByUrl(String url)throws Exception;

    public int fixShareUrlById(int id)throws Exception;
}
