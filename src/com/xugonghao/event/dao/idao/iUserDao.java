package com.xugonghao.event.dao.idao;

import com.xugonghao.event.entity.User;

import java.util.List;

public interface iUserDao {
    public int insert(User stu);
    public int update(User stu);
    public int delete(int ID);
    public List<User> select(String condt);
}
