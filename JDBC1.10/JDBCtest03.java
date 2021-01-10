package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.Scanner;

/*
演示用户控制台输入desc降序和asc升序
 */
public class JDBCtest03 {
    public static void main(String[] args) {
        /*先演示用PreparedStatement

        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.println("请输入：");
        String keyWords = s.nextLine();

        //执行SQL
        //六步
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","so1esou1");
            String sql = "select ename from emp order by ename ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,keyWords);
            //执行sql
            rs = ps.executeQuery();
            //遍历结果集
            while(rs.next()){
                System.out.println(rs.getString("ename"));   //最终这里提示错误，desc两边多了单引号
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
        }*/


        //用Statement：
        Scanner s = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.println("请输入：");
        String keyWords = s.nextLine();

        //执行SQL
        //六步
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");


            stmt = conn.createStatement();
            String sql = "select ename from emp order by ename" + keyWords;
            rs = stmt.executeQuery(sql);
            //遍历结果集
            while(rs.next()){
                System.out.println(rs.getString("ename"));   //最终这里提示错误，desc两边多了单引号
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
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
