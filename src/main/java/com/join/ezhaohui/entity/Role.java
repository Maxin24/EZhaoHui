package com.join.ezhaohui.entity;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * t_role
 * @author 
 */

public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;


    private List<Permission> permissions;


    private List<User> users;


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

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id.equals(role.id) &&
                name.equals(role.name) &&
                Objects.equals(permissions, role.permissions) &&
                Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, permissions, users);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }
}