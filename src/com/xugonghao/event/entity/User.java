package com.xugonghao.event.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
    public static final long serialversionUID = 2L;
    private Integer id; // 用户id
    private String use_name; // 用户名
    private String use_pwd; // 用户密码
    private String use_email; // 用户邮箱
    private String use_phone; // 用户手机号
    private String use_type; // 用户类型
    private Float use_balance; // 用户余额

    // 无参构造
    public User() {
    }
    // 有参构造
    public User(String use_name, String use_pwd) {
        this.use_name = use_name;
        this.use_pwd = use_pwd;
    }
    public User(Integer id, String use_name, String use_pwd, String use_email, String use_phone, String use_type, Float use_balance) {
        this.id = id;
        this.use_name = use_name;
        this.use_pwd = use_pwd;
        this.use_email = use_email;
        this.use_phone = use_phone;
        this.use_type = use_type;
        this.use_balance = use_balance;
    }

    // setter and getter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUse_name() {
        return use_name;
    }

    public void setUse_name(String use_name) {
        this.use_name = use_name;
    }

    public String getUse_pwd() {
        return use_pwd;
    }

    public void setUse_pwd(String use_pwd) {
        this.use_pwd = use_pwd;
    }

    public String getUse_email() {
        return use_email;
    }

    public void setUse_email(String use_email) {
        this.use_email = use_email;
    }

    public String getUse_phone() {
        return use_phone;
    }

    public void setUse_phone(String use_phone) {
        this.use_phone = use_phone;
    }

    public String getUse_type() {
        return use_type;
    }

    public void setUse_type(String use_type) {
        this.use_type = use_type;
    }

    public Float getUse_balance() {
        return use_balance;
    }

    public void setUse_balance(Float use_balance) {
        this.use_balance = use_balance;
    }

    @Override
    public String toString() {
        return "用户" +
                "id:" + id +
                ", 用户名:" + use_name +
                ", 密码:" + use_pwd +
                ", 邮箱:" + use_email +
                ", 手机号码:" + use_phone +
                ", 类型:" + use_type +
                ", 余额:" + use_balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
