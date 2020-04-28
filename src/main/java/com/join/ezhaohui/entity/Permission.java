package com.join.ezhaohui.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * t_permission
 * @author 
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 权限id
     */
    private Integer id;

    /**
     * 权限名
     */
    private String name;



    private List<Role> roles;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, roles);
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}