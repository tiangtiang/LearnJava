package po;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by tiang on 2018/7/17.
 * 学生实体对象
 */
public class Student {
    private int studentId;
    private String studentName;
    private String gender;
    private Date birthday;
    private int classId;
    private int age;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getAge() {
        return age;
    }

    public Student(Integer studentId, String studentName, String gender, java.sql.Date birthday, Integer classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.birthday = birthday;
        this.classId = classId;
    }

    public void calculateAge(){
        LocalDate now = LocalDate.now();
        LocalDate birth = ((java.sql.Date)birthday).toLocalDate();
        Period p = Period.between(birth, now);
        this.age = p.getYears();
    }
}
