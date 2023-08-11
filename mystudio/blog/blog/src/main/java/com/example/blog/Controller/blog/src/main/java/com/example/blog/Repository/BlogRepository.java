package com.example.blog.Repository;

import com.example.blog.Entity.Blog;
import com.example.blog.Entity.BlogLogin;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BlogRepository extends CrudRepository<Blog ,Integer> {
    @Query("select *  from blog where id = :id and psw = :psw")
    Optional<Blog> selectOneByBlogId(@Param("id")String id , @Param("psw")String psw);

}
