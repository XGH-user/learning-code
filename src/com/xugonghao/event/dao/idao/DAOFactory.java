package com.xugonghao.event.dao.idao;

import com.xugonghao.event.dao.dao.ManagerDao;
import com.xugonghao.event.entity.User;

public class DAOFactory {
    public static iManagerDao createManagerDao() { return new ManagerDao() };
    public static iUserDao createUserDao(){ return new UserDao() };
}
