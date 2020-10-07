package com.atguigu4.connection;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author wyj
 * @Description
 * @create 2020-10-07 14:09
 */
public class DBCPTest {
    @Test
    public void testGetConnection() throws SQLException {
        //创建了DBCP的数据库连接池
        BasicDataSource source = new BasicDataSource();
        //设置基本信息
        source.setUrl("jdbc:mysql://localhost:3306/test");
        source.setDriverClassName("com.mysql.jdbc.Driver");
        source.setUsername("root");
        source.setPassword("root");

        //设置其他设计数据库连接池管理的相关属性
        source.setInitialSize(10);
        source.setMaxActive(10);

        Connection conn = source.getConnection();
        System.out.println(conn);
    }

    //方式二：使用配置文件
    @Test
    public void testGetConnection1() throws Exception {
        Properties properties = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("dbcp.properties");
        properties.load(is);
        DataSource source = BasicDataSourceFactory.createDataSource(properties);
        Connection conn = source.getConnection();
        System.out.println(conn);
    }
}
