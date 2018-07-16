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
    private String resource = "/SqlMapConfig.xml";
    private SqlSessionFactory factory;
    private SqlSession session;

    public SqlSession getSqlSession() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        session = factory.openSession();
        return session;
    }
}
