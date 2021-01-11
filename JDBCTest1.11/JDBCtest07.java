package com.bjpowernode.jdbc;

import com.bjpowernode.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

/*
  要求：测试DBUtil封装是否好用+模糊查询怎么写
 */
public class JDBCtest07 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接
            conn = DBUtil.getConnection();
            //获取预编译的数据库操作对象
            /*错误写法：
            String sql = "select ename from emp where ename like '_?%'";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"A");  //编译时报错，说明不能写成'_?%'*/
            String sql = "select ename from emp where ename like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"_A%");   //把_A%传到?问号上
            ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("ename"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,ps,rs);
        }
    }
}
