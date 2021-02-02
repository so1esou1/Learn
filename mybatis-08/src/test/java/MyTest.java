import com.csu.dao.BlogMapper;
import com.csu.pojo.Blog;
import com.csu.utils.IDutils;
import com.csu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    //测试插入
   /*@Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("java简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("spring简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务简单");
        mapper.addBlog(blog);

        session.close();
    }*/

    /*@Test
    public void queryBlogIF(){
        SqlSession sqlSessions = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSessions.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        List<Blog> blogs = mapper.queryBlogIF(map);
        for(Blog blog : blogs){
            System.out.println(blog);
        }

        sqlSessions.close();
    }*/

    /*@Test
    //测试choose语句
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("views",9999);

        List<Blog> blogs = mapper.queryBlogChoose(map);
        for(Blog blog : blogs){
            System.out.println(blog);
        }

        sqlSession.close();

    }*/

    @Test
    //测试更新博客
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title","java简单2");
        map.put("author","狂神说2");
        map.put("id","1");

        mapper.updateBlog(map);
        sqlSession.close();

    }


    @Test
    //查询第1-2-3号记录的博客，使用foreach
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);

        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        for(Blog blog : blogs){
            System.out.println(blog);
        }

        sqlSession.close();
    }

}
