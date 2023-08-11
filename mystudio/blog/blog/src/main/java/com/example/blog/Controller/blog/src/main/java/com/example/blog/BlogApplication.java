package com.example.blog;

import com.example.blog.Entity.Blog;
import com.example.blog.Repository.BlogRepository;
import com.example.blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args).getBean(BlogApplication.class).execute();
	}
 private  void  execute(){
//		setUp();
//        getOneByid();
//     updateMember();
//     deleteMember();
 }
 @Autowired
    BlogService service;
 private void setUp(){
        ZonedDateTime zonedDateTime =ZonedDateTime.now();
     System.out.println("==회원가입중...==");
     Blog blog1 = new Blog(null,"ywwsun45","123","유태양","ywwsun45", Timestamp.valueOf(LocalDateTime.now()));
     Blog blog2 = new Blog(null,"ywwsun12","123","유태양","ywwsun45", Timestamp.valueOf(LocalDateTime.now()));
     Blog blog3 = new Blog(null,"ywwsun34","123","유태양","ywwsun45", Timestamp.valueOf(LocalDateTime.now()));
     List<Blog> blogList = new ArrayList<>();
     Collections.addAll(blogList,blog1,blog2,blog3);
     for (Blog blog :blogList){
         service.insertMember(blog);
     }
     System.out.println("계정 등록 완료");
     
 }
 private void getOneByid(){

     Optional<Blog> blogOpt = service.selectOneById(1);
     if(blogOpt.isPresent()){
         System.out.println(blogOpt.get());
     }else {
         System.out.println("계정이 존재하지 않습니다");
     }
     System.out.println("계정 확인 완료");
 }
 private void updateMember(){
     System.out.println("계정변경");
     Blog blog = new Blog(1,"kim","123","양","ywwsun444@naver.com",Timestamp.valueOf(LocalDateTime.now()));
     service.UpdateMember(blog);
     System.out.println("계정변경"+blog+"완료");

 }
 private  void  deleteMember(){
     System.out.println("계정 삭제");
     service.deleteMemberId(2);
     System.out.println("계정"+2+"을 삭제하였습니다");
 }
 
}
