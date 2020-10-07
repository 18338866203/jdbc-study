package com.atguigu1.transation;

import com.atguigu1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author wyj
 * @Description
 * @create 2020-10-06 20:55
 */
public class ConnectionTest {

    @Test
    public void getConnection() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }
}
