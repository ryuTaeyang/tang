package com.example.blog.Service;

import com.example.blog.Entity.Blog;

import java.util.Optional;

public interface BlogService {
    Iterable<Blog> selectAll();

    Optional<Blog> selectOneById(Integer number);

    Boolean checkAcc( Integer number,String psw);
    Boolean checkAccLogin (String id, String psw);

    Optional<Blog> selectOneByBlogId(String id, String psw);

    void insertMember(Blog blog);

    void UpdateMember(Blog blog);

    void deleteMemberId(Integer number);
}
