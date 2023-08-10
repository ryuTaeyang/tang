package com.example.blog.Repository;

import com.example.blog.Entity.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog,Integer> {
}
