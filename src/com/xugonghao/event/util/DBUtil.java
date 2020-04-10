package com.xugonghao.event.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 * 数据库连接工具类
 */
public class DBUtil {

    // 构造方法
    public DBUtil(){}

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    // 定义 数据库驱动
    private static String driverClass;
    // 定义 数据库的连接
    private static String url;
    // 定义 数据库用户
    private static String user;
    // 定义 数据库用户的密码
    private static String password;

    /**
     * 注册驱动
     */
    // 静态代码块
    static {
        InputStream in =null;
        try {
            in = DBUtil.class.getResourceAsStream("dbcfg.properties");
            Properties props = new Properties();
            // 加载属性列表到Properties类对象
            props.load(in);
            // 通过props对象进行获取【dbcfg.properties】中的指定的键
            driverClass = props.getProperty("driverClass");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
        } catch (IOException e) {
            // 转换异常抛出
            throw new ExceptionInInitializerError("获取数据库配置文件信息失败");
        }
        try {
            // 类加载-->驱动
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            // 转换异常抛出
            throw new ExceptionInInitializerError("加载驱动失败");
        } finally {
            try {
                // 关闭输入流
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection (){
        try {
            Connection conn = DriverManager.getConnection(url,user,password);
            return conn;
        } catch (SQLException e) {
            // 转换异常抛出
            throw new RuntimeException("链接数据库的url或用户名密码错误,请检查您的配置文件");
        }
    }

    /**
     * 查询并得到结果集
     * @param sql sql查询语句
     * @return 结果集
     * @throws Exception
     */
    public ResultSet execQuery(String sql) throws Exception {
        ResultSet rstSet = null;
        try {
            if (null == conn)
                throw new Exception("没有连接到数据库!");
            Statement stmt = conn.createStatement();
            rstSet = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rstSet;
    }

    /**
     * 查询并得到结果集
     * @param psql sql查询预编译语句
     * @return 结果集
     * @throws Exception
     */
    public ResultSet execudePrepared(String psql) throws Exception {
        ResultSet rstSet = null;
        PreparedStatement pstmt = null ;
        try {
            if (null == conn)
                throw new Exception("没有连接到数据库!");
            rstSet = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rstSet;
    }

    public PreparedStatement execPrepared(String psql) throws Exception {
        PreparedStatement pstmt = null ;
        try {
            if (null == conn)
                throw new Exception("没有连接到数据库!");
            pstmt = conn.prepareStatement(psql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    /**
     *插入一条新纪录，并获取标识列的值
     * @param insertSql sql插入语句
     * @return  标识列的值
     * @throws Exception
     */
    public ResultSet getInsertObjectIDs(String insertSql) throws Exception{
        ResultSet rst = null;
        try {
            if(null==conn)
                throw new Exception("没有连接到数据库!");

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
            rst = stmt.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rst;
    }

    /**
     * 以参数SQL模式插入新纪录，并获取标识列的值
     * @param insertSql sql插入语句
     * @param params 参数SQL模式
     * @return 标识列的值
     * @throws Exception
     */
    public ResultSet getInsertObjectIDs(String insertSql, Object[] params) throws Exception {
        ResultSet rst = null;
        PreparedStatement pstmt = null ;
        try {
            if (null == conn)
                throw new Exception("没有连接到数据库!");
            pstmt = conn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);

            if(null != params){
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }
            pstmt.executeUpdate();
            rst = pstmt.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rst;
    }

    /**
     *插入、更新、删除
     * @param sql sql的插入、更新、删除语句
     * @return 插入、更新、删除过后的数量
     * @throws Exception
     */
    public int execCommand(String sql) throws Exception{
        int flag = 0;
        Statement stmt = null;
        try {
            if(null==conn)
                throw new Exception("没有连接到数据库!");

            stmt = conn.createStatement();
            flag = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            stmt.close();
        }
        return flag;
    }

    // 释放资源
    public void close(ResultSet rst) throws Exception {
        try {
            Statement stmt = rst.getStatement();
            rst.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 释放资源
    public void close(Statement stmt) throws Exception {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 释放资源
    public void close() throws SQLException, Exception{
        if(null!=conn){
            conn.close();
            conn=null;
        }
    }

    /**
     * 释放资源
     * @param conn 连接对象
     * @param stmt 数据库操作对象
     * @param rst 结果集
     */
    public static void close(Connection conn, Statement stmt, ResultSet rst){
        if (rst != null){
            try {
                rst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConn() {
        return conn;
    }
}