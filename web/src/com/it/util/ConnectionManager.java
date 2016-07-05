package com.it.util;

import com.it.exception.DataAccessException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 获取数据库链接
 */
public class ConnectionManager {

    private static BasicDataSource dataSource = new BasicDataSource();


    static {


        dataSource.setDriverClassName(Config.get(("jdbc.driver")));
        dataSource.setUrl(Config.get(("jdbc.url")));
        dataSource.setUsername(Config.get(("jdbc.username")));
        dataSource.setPassword(Config.get(("jdbc.password")));
        dataSource.setInitialSize(Integer.parseInt(Config.get("jdbc.initsize", "5")));
        dataSource.setMaxTotal(Integer.parseInt(Config.get("jdbc.maxsize", "50")));
        dataSource.setMaxWaitMillis(Integer.parseInt(Config.get("jdbc.maxwait", "5000")));
        dataSource.setMaxIdle(Integer.parseInt(Config.get("jdbc.maxidle", "10")));
        dataSource.setMinIdle(Integer.parseInt(Config.get("jdbc.minidle", "5")));

    }

    /**
     * @return 连接池对象
     */

    public static BasicDataSource getDataSource() {

        return dataSource;
    }

    public static Connection getConnection() throws DataAccessException {
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            throw new DataAccessException("数据库加载异常", e);
        }

    }

    /**
     * 关闭连接池
     *
     * @param
     */
    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
