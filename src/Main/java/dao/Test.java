package dao;

import org.apache.ibatis.session.SqlSession;
import po.Student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by tiang on 2018/7/16.
 */
public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        SqlSession session =DataConnection.getSqlSession();
        Student student = new Student();
        student.setStudentId(13);
        student.setStudentName("杨晓芸");
        student.setGender("女");
        String day = "1997-03-10";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        student.setBirthday(format.parse(day));
        student.setClassId(1);
        SchoolMapper mapper = session.getMapper(SchoolMapper.class);
        mapper.insertStudent(student);
        session.commit();
        session.close();
    }
}
