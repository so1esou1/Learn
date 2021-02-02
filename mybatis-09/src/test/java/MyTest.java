import com.csu.dao.UserMapper;
import com.csu.pojo.User;
import com.csu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void test (){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        //mapper.updateUser(new User(2,"aaaa","bbbb"));

        sqlSession.clearCache();     //手动清理缓存

        System.out.println("====================================");

        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user == user2);

        sqlSession.close();
    }

}
