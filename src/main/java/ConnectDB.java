import java.sql.*;

/**
 * Created by tiang on 2018/7/16.
 */
public class ConnectDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test?user=root&password=lianglab&useSSL=true&serverTimezone=UTC";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(DB_URL);
            String sql = "select * from salary";
            statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while(set.next()){
                System.out.println(set.getInt("user_id")+":"+set.getInt("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
