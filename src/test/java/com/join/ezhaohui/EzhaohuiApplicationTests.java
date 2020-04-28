package com.join.ezhaohui;

import com.join.ezhaohui.entity.Permission;
import com.join.ezhaohui.entity.Role;
import com.join.ezhaohui.entity.User;
import com.join.ezhaohui.mapper.RoleMapper;
import com.join.ezhaohui.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EzhaohuiApplicationTests {
    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void testUser(){
        System.out.println(userMapper.selectByPrimaryKey(1));
    }
}
