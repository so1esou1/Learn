package com.bjpowernode.jdbc;
/*
实现一个功能：
    1、需求是模拟用户登录功能的实现
    2、业务描述：程序运行时，提供一个输入的入口，可以让用户输入用户名和密码
                用户输入用户名和密码后，提交信息，java程序收集到用户信息，
                java程序连接数据库验证用户名和密码是否合法
                合法：显示登录成功
                不合法：显示登录失败
    3、数据的准备：
        在实际开发中，表的设计会使用专业的建模工具，安装一个建模工具powerdesigner(这个工具建表后自动生成建表语句，超方便)
    （脚本太大打不开，只能在dos窗口登录，使用source命令）（参见user_login.sql脚本）
    4、当前程序存在问题：
      用户名：fdsa
      密码：fdsa' or '1'='1
      登录成功
      这种现象被称为SQL注入（安全隐患），黑客经常使用（说明我们这个程序的写法有一个漏洞，现在已解决）
    5、导致SQL注入的根本原因是什么？
        用户输入的信息中含有sql语句的关键字，并且这些关键字参与了sql语句的编译过程，导致原sql语句的含义被扭曲了，进而达到sql注入
 */
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JDBCtest01 {
    public static void main(String[] args) {
        //先初始化一个界面
        Map<String,String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginSuccess = login(userLoginInfo);   //登录成功或失败两种结果所有用布尔型
        //最后输出结果
        System.out.println(loginSuccess ? "登录成功" : "登录失败");
    }





    /**
     * 用户登录
     * @param userLoginInfo 用户登录信息
     * @return false失败，true成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {
        //打标记
        boolean loginSuccess = false;
        //单独定义变量
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");

        //JDBC代码的编写
        //六步
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","so1esou1");
            //3、获取数据库操作对象
            stmt = conn.createStatement();
            //4、执行sql语句
            String sql = "select * from t_user where loginName = '"+loginName+"' and loginPwd = '"+loginPwd+"'";
            //以上正好完成了sql语句的拼接，以下代码的含义是发送SQL语句给DBMS，DBMS进行sql编译
            rs = stmt.executeQuery(sql);
            //5、处理结果集
            if(rs.next()){
                //登录成功
                loginSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6、释放资源
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



    /**
     * 初始化用户界面，返回用户输入的用户名和密码等登录信息
     * @return
     */
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
