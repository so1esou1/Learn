import com.csu.dao.StudentMapper;
import com.csu.dao.TeacherMapper;
import com.csu.pojo.Student;
import com.csu.pojo.Teacher;
import com.csu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {


    /*public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }*/

    @Test
    //测试查询所有的学生信息，以及对应的老师的信息，按照查询嵌套处理
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList){
            System.out.println(student);
        }

        sqlSession.close();
    }

    @Test
    //测试，按照结果嵌套处理
    public void testStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student : studentList){
            System.out.println(student);
        }

        sqlSession.close();
    }
}
