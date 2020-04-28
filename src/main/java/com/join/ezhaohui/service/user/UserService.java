package com.join.ezhaohui.service.user;

import com.join.ezhaohui.entity.User;
import org.springframework.stereotype.Service;

/**
 * @Author:ljx
 * @Date:2020/4/27
 * @Description:
 */
public interface UserService {
    public User selectUserByUsername(String username);
    public int addUser(User user);
    public Object login(String username,String password);
    public void logout();
}
