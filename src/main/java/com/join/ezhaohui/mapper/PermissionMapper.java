package com.join.ezhaohui.mapper;

import com.join.ezhaohui.entity.Permission;
import com.join.ezhaohui.entity.PermissionExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * PermissionMapper继承基类
 */
@Repository
public interface PermissionMapper extends MyBatisBaseDao<Permission, Integer, PermissionExample> {
    public List<Permission> selectByRoleId(int rid);
}