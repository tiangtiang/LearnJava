package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by tiang on 2018/7/16.
 * 测试数据库连接池是否能够使用
 */
public class ConnectDB {
    public static void main(String[] args) {
        PoolConnection pool = PoolConnection.createPool();
        Connection conn = pool.getConnection();
        String sql = "select * from salary";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                System.out.println(result.getInt("user_id")+":"+result.getInt("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
