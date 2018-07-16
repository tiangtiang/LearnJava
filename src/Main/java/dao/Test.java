package dao;

import org.apache.ibatis.session.SqlSession;
import po.Contract;

import java.io.IOException;
import java.util.Date;

/**
 * Created by tiang on 2018/7/16.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession session = new DataConnection().getSqlSession();
        Contract contract = new Contract();
        contract.setOrgID(3);
        contract.setExpireAt(new Date());
        session.insert("test.insertInto", contract);
        session.commit();
        System.out.println(contract.getId());
        session.close();
    }
}
