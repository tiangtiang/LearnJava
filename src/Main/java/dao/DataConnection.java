package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tiang on 2018/7/16.
 */
public class DataConnection {
    private static String resource = "SqlMapConfig.xml";
    private static SqlSessionFactory factory;

    public static SqlSession getSqlSession() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        return factory.openSession();
    }
}
