package self;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tiang on 2018/7/16.
 */
public class ConnectDB {
    public static void main(String[] args) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("driverString", "com.mysql.cj.jdbc.Driver");
        properties.put("connectionString", "jdbc:mysql://localhost:3306/test?user=root&password=lianglab&useSSL=true&serverTimezone=UTC");
        properties.put("maxSize", 2);
        try {
            MyConnectionPool pool = MyConnectionPool.create(properties);
            Connection conn1 = pool.getConnection(),
                    conn2 = pool.getConnection(), conn3 = pool.getConnection();
            if (conn1 != conn2) {
                System.out.println("ok");
            }
            if (conn3 == null)
                System.out.println("ok");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
