package com.bjpowernode.jdbc;

import com.bjpowernode.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
负责修改被悲观锁锁定的记录
 */
public class JDBCtest09 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            conn.setAutoCommit(false);

            String sql = "uodate emp set sal = sal * 1.1 where job = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"MANAGER");
            int count = ps.executeUpdate();    //返回执行的条数
            System.out.println(count);

            conn.commit();
        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);   //第三个资源没有写null,即判断为rs=null
        }
    }
}
