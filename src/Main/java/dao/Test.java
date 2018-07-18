package dao;

import mapper.SchoolMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.Student;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by tiang on 2018/7/16.
 * 主类
 */
public class Test {
    public static void main(String[] args) throws IOException, ParseException {
//        创建spring上下文容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/SpringConfig.xml");
        SchoolMapper mapper = (SchoolMapper) context.getBean("school");
        Student student = mapper.selectStudent(12);
        System.out.println(student.getStudentName());
    }
}
