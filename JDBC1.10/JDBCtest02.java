package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
怎么解决sql注入的问题呢？
    ***只要用户提供的信息不参与SQL语句的编译过程，问题就解决了
    即使用户提供的信息中含有SQL语句的关键字，但是不会参与编译，不起作用
    要想用户信息不参与编译，必须使用java.sql.PreparedStatement
    preparedStatement接口继承了java.sql.Statement
    preparedStatement是属于预编译的数据库操作对象
    preparedStatement的原理是预先对sql语句框架进行编译，然后再给SQL语句传"值"。

对比Statement和PreparedStatement？
    1、Statement存在sql注入问题，PreparedStatement解决了这个问题
    2、PreparedStatement比Statement执行效率更高.Statement编译一次执行一次，PreparedStatement有sql语句的框子，
    编译在传值之前，只用传值就执行，编译一次执行N多次
    3、PreparedStatement会在编译阶段做类型的安全检查，更安全。Statement不能检查输入是否正确

*****综上所述，以后几乎都是用PreparedStatement。除非某些系统需要用户进行sql注入的，可以使用Statement

什么情况下必须使用Statement？
    业务要求必须支持SQL注入的时候（给老板留后门hhhh）
    比如：网购时，用户需要对商品进行升序降序排列，相当于给数据库输入desc、asc，这时候就需要影响原sql语句
 */
public class JDBCtest02 {
    public static void main(String[] args) {

        Map<String,String> userLoginInfo = initUI();

        boolean loginSuccess = login(userLoginInfo);

        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }



    private static boolean login(Map<String, String> userLoginInfo) {

        boolean loginSuccess = false;

        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");

        Connection conn = null;
        PreparedStatement ps = null;    //这里使用PreparedStatement（预编译的数据库操作对象）
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","so1esou1");
            //获取预编译的数据库对象（在这里大改）
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";    //sql语句的框架
            //把用户名和密码改成占位符? 以后要填充值
            //程序执行到此处会发送sql语句的框子给DBMS，然后DBMS进行sql语句的预先编译
            ps = conn.prepareStatement(sql);
            //接下来给占位符?传值(第一个?下标是1，第一个?下标是2，JDBC中所有下标从1开始)
            ps.setString(1,loginName);   //1代表第一个问号的下标.这里传的是String，说明传过去的话会自动加上单引号''
            ps.setString(2,loginPwd);


            //4、执行sql
            rs = ps.executeQuery();     //sql不用往这里传了，不用再编译

            if(rs.next()){
                //登录成功
                loginSuccess = true;
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
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return loginSuccess;
    }



    private static Map<String, String> initUI() {
        Scanner s = new Scanner(System.in);
        System.out.print("用户名:");
        String loginName = s.nextLine();

        System.out.print("密码:");
        String loginPwd = s.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName",loginName);
        userLoginInfo.put("loginPwd",loginPwd);

        return userLoginInfo;
    }

}
