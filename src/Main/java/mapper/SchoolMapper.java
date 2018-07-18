package mapper;

import po.Student;

/**
 * Created by tiang on 2018/7/17.
 * SchoolMapper.xml对应的代理类
 */
public interface SchoolMapper {
    /**
     * 插入学生数据的代理方法
     * @param student
     * @return
     */
    int insertStudent(Student student);
    Student selectStudent(int id);
}
