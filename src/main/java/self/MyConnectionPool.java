package self;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by tiang on 2018/7/16.
 * 自己实现一个数据库连接池
 */
public class MyConnectionPool{
    // 保存数据库连接
    private static CopyOnWriteArrayList<MyConnection> pool;

    private static int minSize;
    private static int maxSize;
    private static String driverString;
    private static String connectionString;
    // 单例对象
    private static MyConnectionPool connectionPool;

    private MyConnectionPool(){}

    /**
     * 创建一个连接池对象
     * @param properties
     * @return
     * @throws Exception
     */
    public static MyConnectionPool create(Map<String, Object> properties) throws Exception {
        if(connectionPool == null){
            if(!properties.containsKey("driverString")||!properties.containsKey("connectionString"))
                throw new Exception("lack properties");
            driverString = (String)properties.get("driverString");
            Class.forName(driverString).newInstance();
            connectionString = (String)properties.get("connectionString");
            minSize = properties.containsKey("minSize")?(Integer) properties.get("minSize"):2;
            maxSize = properties.containsKey("maxSize")?(Integer) properties.get("maxSize"):5;
            init();
            connectionPool = new MyConnectionPool();
        }
        return connectionPool;
    }

    /**
     * 初始化连接池
     * @throws SQLException
     */
    private static void init() throws SQLException {
        ArrayList<MyConnection> temp = new ArrayList<>();
        for(int i=0;i<minSize;i++){
            temp.add(createConnection());
        }
        pool = new CopyOnWriteArrayList<>(temp);
    }

    /**
     * 创建一个新的连接
     * @return
     * @throws SQLException
     */
    private static MyConnection createConnection() throws SQLException {
        return new MyConnection(DriverManager.getConnection(connectionString));
    }

    /**
     * 获取一个数据库连接，如果连接池已满就返回空
     * @return
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
        // 查找尚未使用的
        for(int i=0;i<pool.size();i++){
            MyConnection conn = pool.get(i);
            if(!conn.isUsing()){
                if(!conn.isValid())
                    conn = createConnection();
                conn.setUsing(true);
                return conn.getConn();
            }
        }
        if(pool.size()<maxSize){
            MyConnection conn = createConnection();
            conn.setUsing(true);
            return conn.getConn();
        }else return null;
    }

    /**
     * 归还数据库连接
     * @param conn
     */
    public void closeConnection(Connection conn){
        for(int i=0;i<pool.size();i++) {
            if(conn == pool.get(i).getConn()){
                pool.get(i).setUsing(false);
            }
        }
    }

    /**
     * 自定义的连接类
     */
    private static class MyConnection{
        private Connection conn;
        private boolean using = false;

        public MyConnection(Connection c){
            conn = c;
        }

        public boolean isUsing() {
            return using;
        }

        public void setUsing(boolean using) {
            this.using = using;
        }

        public Connection getConn() {
            return conn;
        }

        public boolean isValid(){
            try {
                return conn.isValid(0);
            } catch (SQLException e) {
                return false;
            }
        }
    }
}
