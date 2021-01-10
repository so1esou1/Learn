package com.bjpowernode.jdbc;

import java.sql.*;

/*
使用PreparedStatement完成增删改insert delete update
 */
public class JDBCtest04 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;不是查询，不需要这个
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","so1esou1");

            //3、获取预编译的操作对象
            String sql = "insert into dept(detpno,dname,loc) values(?,?,?)";
            //String sql = "update dept set dname = ?,loc = ? where deptno = ?";  修改
            //String sql = "delete from dept where deptno = ?";  删除
            ps = conn.prepareStatement(sql);
            ps.setInt(1,60);
            ps.setString(2,"销售部");
            ps.setString(3,"上海");
            //4、执行sql
            int count = ps.executeUpdate();
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6、释放资源
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
