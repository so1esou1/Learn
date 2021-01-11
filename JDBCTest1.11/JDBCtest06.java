package com.bjpowernode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
银行转账查看JDBC的手动提交

sql脚本：
    drop table if exists t_act;
    create table t_act{
        actno int,
        balance double(7,2)   //7表示有效数字个数，2表示小数位个数
    };
    insert into t_act(actno,balance) values(111,20000);
    insert into t_act(actno,balance) values(222,0);
    commit;
    select * from t_act;

重点三行代码：
    conn.setAutoCommit(false);
    conn.commit();
    conn.rollback();
 */
public class JDBCtest06 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        //ResultSet rs = null;不是查询，不需要这个
        try {
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root","so1esou1");

            //以下方法可以将自动提交机制关闭,末尾再调用方法手动提交
            conn.setAutoCommit(false);  //关闭自动提交，开启事务

            //3、获取预编译的操作对象
            String sql = "update t_act set balance = ? where actno = ?";
            ps = conn.prepareStatement(sql);

            //给?号传值
            ps.setDouble(1,10000);
            ps.setInt(2,111);
            int count = ps.executeUpdate();

            String s = null;
            s.toString();      //这样会出现空指针异常，导致上面代码执行了，下面代码没有执行！！！需要改变自动提交才能同时成功或失败
            //再给?传值
            ps.setDouble(1,10000);
            ps.setInt(2,222);
            count += ps.executeUpdate();

            System.out.println(count == 2 ? "转账成功" : "转账失败");

            //程序能够执行到这里说明以上程序没有异常，事务结束，手动提交数据
            //提交事务
            conn.commit();

        } catch (Exception e) {
            //这里是回滚事务
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
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
