package com.example.blog.Service;

import com.example.blog.Entity.Blog;
import com.example.blog.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@Transactional
public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository repository;
    @Override
    public Iterable<Blog> selectALL() {
        return repository.findAll();

    }

    @Override
    public Optional<Blog> selectByOneId(Integer num) {
        return repository.findById(num);
    }

    @Override
    public Boolean checkPsw(Integer num, String psw ) {
       Boolean answer = false;
       Optional<Blog>blogOpt = repository.findById(num);
       if( blogOpt.get().getPsw().equals(psw)){
           answer = true;
       }


        return answer;
    }

    @Override
    public void insertMember(Blog blog) {
        repository.save(blog);


    }

    @Override
    public void updateMember(Blog blog) {
        repository.save(blog);

    }

    @Override
    public void deleteMember(Integer num) {
        repository.deleteById(num);

    }
}
