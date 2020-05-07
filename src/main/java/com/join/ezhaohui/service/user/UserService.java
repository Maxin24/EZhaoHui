package com.join.ezhaohui.service.user;

import com.join.ezhaohui.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author:ljx
 * @Date:2020/4/27
 * @Description:
 */
public interface UserService {
    User selectUserByUsername(String username);
    int addUser(User user);
    Object login(String username,String password);
    void logout();
}
