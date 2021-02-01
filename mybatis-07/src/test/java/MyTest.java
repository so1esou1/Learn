import com.csu.dao.StudentMapper;
import com.csu.dao.TeacherMapper;
import com.csu.pojo.Student;
import com.csu.pojo.Teacher;
import com.csu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    /*@Test
    //测试一对多
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        for(Teacher teacher : sqlSession.getMapper(TeacherMapper.class).getTeacher()){
            System.out.println(teacher);
        }

        sqlSession.close();
    }*/

    @Test
    //测试获取指定老师下的所有学生信息,按方式二结果嵌套查询
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);

        sqlSession.close();
    }
}
