package com.xugonghao.event.dao.dao;

import com.xugonghao.event.dao.idao.iManagerDao;
import com.xugonghao.event.entity.Manager;
import com.xugonghao.event.util.DBUtil;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class ManagerDao implements iManagerDao {

    public int insert(Manager stu) {
        try {
            String sql = "insert into manager( id,manager_name,manager_pwd,manager_email,manager_phone )"
                    + " valus('"
                    + stu.getManager_name()
                    + "','"
                    + stu.getManager_pwd()
                    + "','"
                    + stu.getManager_email()
                    + "','"
                    + stu.getManager_phone()
                    + "')";
            DBUtil db = new DBUtil();
            DBUtil.getConnection();
            ResultSet rst = db.getInsertObjectIDs(sql);
            if(rst != null && rst.first()){
                stu.setId(rst.getInt(1));
            }

            db.close();
            db.close(rst);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(Manager stu) {
        int rtn = 0;
        try {
            String sql = "updata manager set " + " manager_name = '"
                    + stu.getManager_name() + "'," + " manager_pwd = '"
                    + stu.getManager_pwd() + "'," + " manager_email = '"
                    + stu.getManager_email() + "'," + " manager_phone = '"
                    + stu.getManager_phone() + "' ";
            sql += " where id = " + stu.getId();
            DBUtil db = new DBUtil();
            DBUtil.getConnection();
            rtn = db.execCommand(sql);
            db.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return rtn;
    }

    public int delete(int ID) {
        int rtn = 0;
        try {
            String sql = "delete from t_manager ";
            sql += " where id = " + ID;
            DBUtil db = new DBUtil();
            DBUtil.getConnection();
            rtn = db.execCommand(sql);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rtn;
    }

    public List<Manager> select(String condt) {
        List<Manager> stuList = null;
        stuList = new LinkedList<Manager>();
        try {
            String sql = "select id, manager_name, manager_pwd, manager_email, manager_phone from t_manager ";
            condt.trim();
            if(!condt.isEmpty())
                sql += " where " +condt;
            DBUtil db = new DBUtil();
            DBUtil.getConnection();
            ResultSet rst = db.execQuery(sql);
            if(rst != null){
                while (rst.next()){
                    Manager manager = new Manager();
                    manager.setId(rst.getInt("id"));
                    manager.setManager_name(rst.getString("manager_name"));
                    manager.setManager_pwd(rst.getString("manager_pwd"));
                    manager.setManager_email(rst.getString("manager_email"));
                    manager.setManager_phone(rst.getString("manager_phone"));
                    stuList.add(manager);
                }
            }
            db.close(rst);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stuList;
    }
}
