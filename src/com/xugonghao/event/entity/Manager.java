package com.xugonghao.event.entity;

import java.io.Serializable;
import java.util.Objects;

public class Manager implements Serializable {
    public static final long serialversionUID = 1L;
    private Integer id; // 管理员id
    private String manager_name; // 管理员姓名
    private String manager_pwd; // 管理员密码
    private String manager_email; // 管理员邮箱
    private String manager_phone; // 管理员手机号

    // 无参构造
    public Manager() {
    }
    // 有参构造
    public Manager(String manager_name, String manager_pwd) {
        this.manager_name = manager_name;
        this.manager_pwd = manager_pwd;
    }

    public Manager(Integer id, String manager_name, String manager_pwd, String manager_email, String manager_phone) {
        this.id = id;
        this.manager_name = manager_name;
        this.manager_pwd = manager_pwd;
        this.manager_email = manager_email;
        this.manager_phone = manager_phone;
    }

    // setter and getter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_pwd() {
        return manager_pwd;
    }

    public void setManager_pwd(String manager_pwd) {
        this.manager_pwd = manager_pwd;
    }

    public String getManager_email() {
        return manager_email;
    }

    public void setManager_email(String manager_email) {
        this.manager_email = manager_email;
    }

    public String getManager_phone() {
        return manager_phone;
    }

    public void setManager_phone(String manager_phone) {
        this.manager_phone = manager_phone;
    }

    @Override
    public String toString() {
        return "管理员" +
                "id:" + id +
                ", 姓名:" + manager_name +
                ", 密码:" + manager_pwd +
                ", 邮箱:" + manager_email +
                ", 手机号:" + manager_phone ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(id, manager.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
