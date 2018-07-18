package dao;

import mapper.SchoolMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import po.Student;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by tiang on 2018/7/16.
 * 测试入口类
 */
public class Test {
    public static void main(String[] args) throws IOException, ParseException {
//        创建spring上下文容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/SpringConfig.xml");
//        自动扫描出来的mapper代理类名字为原类名首字母小写
        SchoolMapper mapper = (SchoolMapper) context.getBean("schoolMapper");
        Student student = mapper.selectStudent(13);
        System.out.println(student.getStudentName());
    }
}
