package com.join.ezhaohui.service.PicService;


import com.join.ezhaohui.entity.pic.Pic;

public interface PicService {
    public Pic getAll() throws Exception;
    public boolean insertPic(Pic pic) throws Exception;
}
