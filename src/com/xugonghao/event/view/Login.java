package com.xugonghao.event.view;

import com.xugonghao.event.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        // 初始化一个用户界面
        Map<String,String> userLoginInfo = initUI();
        // 验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);
        // 最后输出结果
        System.out.println(loginSuccess ? "登陆成功" : "登陆失败");

    }

    /**
     * 用户登陆
     * @param userLoginInfo 用户登陆信息
     * @return false表示失败，true表示成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        boolean loginSuccess = false;
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        DBUtil db = new DBUtil();

        try {
            DBUtil.getConnection();
            String sql = "select user_name,user_pwd from t_user where loginName = ? and loginPwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,loginName);
            pstmt.setString(2,loginPwd);
            rs = db.execudePrepared(sql);
            if (rs.next()){
                loginSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 释放资源
        DBUtil.close(conn,pstmt,rs);
        return loginSuccess;
    }

    /**
     * 初始化用户界面
     * @return 用户输入的用户名和密码等登陆信息
     */
    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);

        System.out.println("用户名: ");
        String loginName = s.nextLine();

        System.out.println("密码: ");
        String loginPwd = s.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);
        return userLoginInfo;
    }
}
