package com.csu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Springboot06DataApplicationTests {
    @Autowired     //注入yaml中的datasource
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
        //查看一下默认的数据源
        System.out.println(dataSource.getClass());    //class com.zaxxer.hikari.HikariDataSource(最快的)

        //获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        //xxxx Template : SpringBoot已经配置好的模板bean，拿来即用
        //jdbc
        //redis

        connection.close();
    }

}
