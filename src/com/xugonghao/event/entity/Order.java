package com.xugonghao.event.entity;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    public static final long serialversionUID = 4L;
    private Integer id; // 预约编号
    private Integer Uid; // 用户编号
    private Integer Mid; // 赛事编号
    private Integer order_num; // 订单数量
    private Float order_price; // 订单金额

    // 无参构造
    public Order() {
    }
    // 有参构造
    public Order(Integer id, Integer uid, Integer mid, Integer order_num, Float order_price) {
        this.id = id;
        Uid = uid;
        Mid = mid;
        this.order_num = order_num;
        this.order_price = order_price;
    }

    // setter and getter
    public static long getSerialversionUID() {
        return serialversionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_num() {
        return order_num;
    }

    public void setOrder_num(Integer order_num) {
        this.order_num = order_num;
    }

    public Integer getUid() {
        return Uid;
    }

    public void setUid(Integer uid) {
        Uid = uid;
    }

    public Integer getMid() {
        return Mid;
    }

    public void setMid(Integer mid) {
        Mid = mid;
    }

    public Float getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Float order_price) {
        this.order_price = order_price;
    }

    @Override
    public String toString() {
        return "订单" +
                "预约id:" + id +
                ", 订单数量:" + order_num +
                ", 订单价格:" + order_price ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
