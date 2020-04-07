package com.join.ezhaohui.service.PicService;


import com.join.ezhaohui.entity.Pic;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface PicService {
    List<Pic> getAll() throws Exception;
    String insertPic(Pic pic, MultipartFile picture, HttpServletRequest request) throws Exception;
    boolean deletePic(Integer id) throws Exception;
    boolean rankExist(Integer rank)throws Exception;
    boolean update(Pic pic)throws Exception;
}
