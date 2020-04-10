package com.xugonghao.event.dao.idao;

import com.xugonghao.event.entity.Order;

import java.util.List;

public interface iOrderDao {
    public int insert(Order stu);
    public int update(Order stu);
    public int delete(int ID);
    public List <Order> select(String condt);
}
