package com.join.ezhaohui.mapper;

import com.join.ezhaohui.entity.Role;
import com.join.ezhaohui.entity.RoleExample;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * RoleMapper继承基类
 */
@Repository
public interface RoleMapper extends MyBatisBaseDao<Role, Integer, RoleExample> {
    public List<Role> selectByUserId(int uid);
}