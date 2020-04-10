package com.xugonghao.event.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Match implements Serializable {
    public static final long serialversionUID = 3L;
    private Integer id; // 赛事id
    private String match_name; // 赛事名字
    private String match_addr; // 赛事地点
    private Date match_date; // 赛事日期
    private Float match_price; // 价格
    private Integer match_ticketnum; // 票数
    private Float match_score; // 评分
    private String match_comment; // 评价

    // 无参构造
    public Match() {
    }
    // 有参构造
    public Match(Integer id, String match_name, String match_addr, Date match_date, Float match_price, Integer match_ticketnum, Float match_score, String match_comment) {
        this.id = id;
        this.match_name = match_name;
        this.match_addr = match_addr;
        this.match_date = match_date;
        this.match_price = match_price;
        this.match_ticketnum = match_ticketnum;
        this.match_score = match_score;
        this.match_comment = match_comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatch_name() {
        return match_name;
    }

    public void setMatch_name(String match_name) {
        this.match_name = match_name;
    }

    public String getMatch_addr() {
        return match_addr;
    }

    public void setMatch_addr(String match_addr) {
        this.match_addr = match_addr;
    }

    public Date getMatch_date() {
        return match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }

    public Integer getMatch_ticketnum() {
        return match_ticketnum;
    }

    public void setMatch_ticketnum(Integer match_ticketnum) {
        this.match_ticketnum = match_ticketnum;
    }

    public String getMatch_comment() {
        return match_comment;
    }

    public void setMatch_comment(String match_comment) {
        this.match_comment = match_comment;
    }

    public Float getMatch_price() {
        return match_price;
    }

    public void setMatch_price(Float match_price) {
        this.match_price = match_price;
    }

    public Float getMatch_score() {
        return match_score;
    }

    public void setMatch_score(Float match_score) {
        this.match_score = match_score;
    }

    @Override
    public String toString() {
        return "赛事" +
                "id:" + id +
                ", 赛事名:" + match_name +
                ", 地点:" + match_addr +
                ", 日期:" + match_date +
                ", 价格:" + match_price +
                ", 票数:" + match_ticketnum +
                ", 评分:" + match_score +
                ", 评价:" + match_comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(id, match.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
