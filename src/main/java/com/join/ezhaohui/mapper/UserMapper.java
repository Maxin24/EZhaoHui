package com.join.ezhaohui.mapper;

import com.join.ezhaohui.entity.User;
import com.join.ezhaohui.entity.UserExample;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * UserMapper继承基类
 */
@Repository
public interface UserMapper extends MyBatisBaseDao<User, Integer, UserExample> {
    public User selectUserByUsername(String Username);

    @Insert("insert into t_user_role values(#{0},2)")
    public int setRoleForNewUser(int uid);
}