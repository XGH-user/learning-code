package com.xugonghao.event.dao.idao;

import com.xugonghao.event.entity.Match;

import java.util.List;

public interface iMatchDao {
    public int insert(Match stu);
    public int update(Match stu);
    public int delete(int ID);
    public List<Match> select(String condt);
}
