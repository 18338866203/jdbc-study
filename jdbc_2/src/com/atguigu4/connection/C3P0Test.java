package com.atguigu4.connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author wyj
 * @Description
 * @create 2020-10-07 11:37
 */
public class C3P0Test {
    //方式一：
    @Test
    public void testGetConnection() throws Exception {
        //获取c3p0数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setUser("root");
        cpds.setPassword("root");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test");

        //通过设置相关参数，对数据库连接池进行管理
        //设置初始时数据库连接池的连接数
        cpds.setInitialPoolSize(10);

        Connection conn = cpds.getConnection();
        System.out.println(conn);
        //销毁c3p0数据库连接池
//        DataSources.destroy(cpds);
    }
    //方式二：使用配置文件
    @Test
    public void testGetConnection2() throws Exception {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }

}
