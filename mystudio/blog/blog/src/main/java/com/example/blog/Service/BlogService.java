package com.example.blog.Service;

import com.example.blog.Entity.Blog;

import java.util.Optional;

public interface BlogService {
    Iterable<Blog> selectALL();

    Optional<Blog> selectByOneId(Integer num);

    Boolean checkPsw(Integer num, String psw );

    void insertMember(Blog blog);
    void updateMember(Blog blog);
    void deleteMember(Integer num);

}
