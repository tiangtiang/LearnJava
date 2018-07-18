package po;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;

/**
 * Created by tiang on 2018/7/18.
 * Student的对象工厂
 * 在生成Student对象之后调用calculateAge方法
 */
public class StudentFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        T obj = super.create(type, constructorArgTypes, constructorArgs);
        if(Student.class.isAssignableFrom(type)){
//            要调用calculate方法需要保证birthday有值
//            在这种情况下，必须使用Student的构造函数初始化参数
//            这个时候构造函数必须精确匹配，不能使用int，double这种，需要用包装类Integer，Double
//            日期是java.sql.Date，不是java.util.Date
            ((Student) obj).calculateAge();
        }
        return obj;
    }
}
