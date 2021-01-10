package com.bjpowernode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
JDBC事务机制
    JDBC中的事务是自动提交的。只要执行任意一条DML语句就自动提交一次
    显然不符合实际开发需求，通常是N条DML语句共同联合才能完成的，必须包装这些DML语句在同一个事务中同时成功或同同时失败

 以下程序验证JDBC是否是自动提交机制
 */
public class JDBCtest05 {
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
            String sql1 = "update dept set dname = ? where deptno = ?";
            ps = conn.prepareStatement(sql1);
            //第一次给占位符传值
            ps.setString(1,"x部门");
            ps.setInt(2,30);
            //4、执行sql
            int count = ps.executeUpdate();  //执行第一条update语句
            System.out.println(count);

            //重新给占位符传值
            ps.setString(1,"y部门");
            ps.setInt(2,20);
            count = ps.executeUpdate();   //执行第二条update语句，加断点查看执行情况。发现在第一条update语句执行时数据就改变了...
            System.out.println(count);
            //如果第二条执行失败就会出现问题，因此需要重定事务

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
