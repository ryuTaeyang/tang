package com.example.blog.Service;

import com.example.blog.Entity.Blog;
import com.example.blog.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository repository;
    @Override
    public Iterable<Blog> selectAll() {

        return repository.findAll();
    }

    @Override
    public Optional<Blog> selectOneById(Integer number) {
         return repository.findById(number);
    }




    @Override
    public Boolean checkAcc(Integer number, String psw) {
       Boolean check = false;
       Optional<Blog> blogOpt = repository.findById(number);
       if(blogOpt.get().getPsw().equals(psw)){
           check = true;

       }
       return check;
    }

    @Override
    public Boolean checkAccLogin(String id, String psw) {
         Boolean check = false;
         Optional<Blog> blogOpt = repository.selectOneByBlogId(id,psw);
         if(blogOpt.get().getId().equals(id) && blogOpt.get().getPsw().equals(psw));
         check = true;
         return check;
    }

    @Override
    public Optional<Blog> selectOneByBlogId(String id, String psw) {
        return repository.selectOneByBlogId(id,psw);
    }


    @Override
    public void insertMember(Blog blog) {
        repository.save(blog);

    }

    @Override
    public void UpdateMember(Blog blog) {
        repository.save(blog);

    }

    @Override
    public void deleteMemberId(Integer number) {
        repository.deleteById(number);

    }
}
