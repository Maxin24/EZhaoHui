package com.join.ezhaohui.service.user.impl;

import com.join.ezhaohui.entity.User;
import com.join.ezhaohui.mapper.UserMapper;
import com.join.ezhaohui.service.user.UserService;
import com.join.ezhaohui.utils.resultHander.CommonErrorEnum;
import com.join.ezhaohui.utils.resultHander.ResponseBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author:ljx
 * @Date:2020/4/27
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    public int addUser(User user) {
        int res1=userMapper.insert(user);
        int res2=userMapper.setRoleForNewUser(user.getId());
        return res1+res2;
    }

    @Override
    public ResponseBean login(String username, String password) {
        if(username.equals("") || username==null || password.equals("") || password==null){
            return new ResponseBean(false,null, CommonErrorEnum.NULL_PARAMS);
        }

        Subject currentUser=SecurityUtils.getSubject();
        if(currentUser.isAuthenticated()==true){
            return new ResponseBean(false,null,CommonErrorEnum.ALREADY_LOGINED);
        }

        UsernamePasswordToken token=new UsernamePasswordToken(username,password);

        try{
            currentUser.login(token);
            System.out.println(currentUser.getPrincipal());
            currentUser.getSession().setAttribute(currentUser.getPrincipal(),currentUser);
        }catch (IncorrectCredentialsException e){
            return new ResponseBean(false,e.getMessage(), CommonErrorEnum.INVALID_USER);
        }catch (UnknownAccountException e){
            return new ResponseBean(false,e.getMessage(), CommonErrorEnum.INVALID_USER);
        }catch (AuthenticationException e){
            return new ResponseBean(false,e.getMessage(), CommonErrorEnum.AUTHENTIC_FAIL);
        }

        return new ResponseBean(true,null, CommonErrorEnum.LOGIN_SUCCESS);
    }

    @Override
    public void logout() {
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
    }
}
