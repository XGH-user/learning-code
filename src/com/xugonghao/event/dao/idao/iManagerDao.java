package com.xugonghao.event.dao.idao;

import com.xugonghao.event.entity.Manager;

import java.util.List;

public interface iManagerDao {
    public int insert(Manager stu);
    public int update(Manager stu);
    public int delete(int ID);
    public List<Manager> select(String condt);
}
