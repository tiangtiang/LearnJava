package pool;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by tiang on 2018/7/16.
 * 数据库连接池类，使用单例模式
 */
public class PoolConnection {
    private static DruidDataSource dataSource = null;
    private static PoolConnection pool = null;
    static {
        Properties config = new Properties();
        try {
            // 加载配置文件
            config.load(PoolConnection.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 创建一个数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PoolConnection(){}

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 创建一个连接池
     * @return
     */
    public static synchronized PoolConnection createPool(){
        if(pool == null)
            pool = new PoolConnection();
        return pool;
    }
}
