package com.join.ezhaohui.service.PicService;


import com.join.ezhaohui.entity.pic.Pic;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PicService {
    List<Pic> getAll() throws Exception;
    boolean insertPic(Pic pic, MultipartFile picture) throws Exception;
    boolean deletePic(Integer id) throws Exception;
    boolean rankExist(Integer rank)throws Exception;
}
