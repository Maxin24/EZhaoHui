package com.join.ezhaohui.controller;

import com.join.ezhaohui.entity.Role;
import com.join.ezhaohui.entity.User;

import com.join.ezhaohui.service.user.UserService;
import com.join.ezhaohui.utils.resultHander.CommonErrorEnum;
import com.join.ezhaohui.utils.resultHander.ResponseBean;
import com.join.ezhaohui.utils.shiro.PasswordUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import org.apache.shiro.subject.Subject;

/**
 * @Author:ljx
 * @Date:2020/4/27
 * @Description:
 */
@CrossOrigin
@RestController
public class ShiroController {
    @Resource
    UserService userServiceImpl;

    @RequestMapping("/login")
    public Object login(@RequestParam String username,@RequestParam String password){
        return userServiceImpl.login(username,password);
    }

    @RequestMapping("/register")
    public Object register(@RequestParam String username,@RequestParam String password){
        User user1=userServiceImpl.selectUserByUsername(username);
        if(user1!=null){
            return new ResponseBean(false,null,CommonErrorEnum.CREATE_USER_FAILED);
        }

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        PasswordUtil.encryptPassword(user);

        if (userServiceImpl.addUser(user)==2){
            return new ResponseBean(true,null,CommonErrorEnum.REGISTER_SUCCESS);
        }else {
            return new ResponseBean(false,null,CommonErrorEnum.REGISTER_FAILED);
        }

    }


    @RequestMapping("/logout")
    public Object logout(){
        userServiceImpl.logout();
        return new ResponseBean(true,null,CommonErrorEnum.LOGOUT_SUCCESS);
    }

    @RequestMapping("/unauth")
    public Object unauthentic(){
        return new ResponseBean(false,null,CommonErrorEnum.POWER_REQUIRED);
    }

    @RequestMapping("/toLogin")
    public Object toLogin(){
        return new ResponseBean(false,null,CommonErrorEnum.LOGIN_REQUIRED);
    }
}
