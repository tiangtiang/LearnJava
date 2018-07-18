package dao;

import mapper.SchoolMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import po.Student;

/**
 * Created by tiang on 2018/7/18.
 * 实现mapper接口，继承SqlSessionDaoSupport类，该类包含了mybatis的SqlSessionFactory单例对象
 */
public class SchoolMapperImpl extends SqlSessionDaoSupport implements SchoolMapper {
    public int insertStudent(Student student) {
        SqlSession session = this.getSqlSession();
        return session.insert("test.insertStudent", student);
    }

    public Student selectStudent(int id) {
        SqlSession session = this.getSqlSession();
        Student stu = session.selectOne("test.selectStudent", 12);
        return stu;
    }
}
