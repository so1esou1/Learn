package com.csu.dao;

import com.csu.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    //用sql插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //更新博客
    int updateBlog(Map map);

    //choose查询
    List<Blog> queryBlogChoose(Map map);

    //查询第1-2-3号记录的博客，使用foreach
    List<Blog> queryBlogForeach(Map map);
}
