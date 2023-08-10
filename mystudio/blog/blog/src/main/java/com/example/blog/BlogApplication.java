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
import java.util.*;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args).getBean(BlogApplication.class).execute();
	}
   @Autowired
	BlogService service;
	

	private void execute(){
//	   set();
//		oneById();
//		showlist();
//		update();
//		delete();
	}
	private void set(){
		
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("가입중..");
		Blog blog1 = new Blog(null,"sss","yww","123",Timestamp.valueOf(LocalDateTime.now()),"ywwsun45@naver.com");
		Blog blog2 = new Blog(null,"sss","yww","123",Timestamp.valueOf(LocalDateTime.now()),"ywwsun45@naver.com");
		Blog blog3 = new Blog(null,"sss","yww","123",Timestamp.valueOf(LocalDateTime.now()),"ywwsun45@naver.com");
		Blog blog4 = new Blog(null,"sss","yww","123",Timestamp.valueOf(LocalDateTime.now()),"ywwsun45@naver.com");
		Blog blog5 = new Blog(null,"sss","yww","123",Timestamp.valueOf(LocalDateTime.now()),"ywwsun45@naver.com");
		List<Blog> blogList = new ArrayList<>();
		Collections.addAll(blogList,blog1,blog2,blog3,blog4,blog5);
		for(Blog blog:blogList){
			service.insertMember(blog);
		}

		System.out.println("가입 완료");

	}
	private void showlist(){
		Iterable<Blog> blogList = service.selectALL();
		for(Blog blog:blogList){
			System.out.println(blog);
			System.out.println("모든 계쩡 리스트");
		}
	}
	private void oneById(){
		Optional<Blog> blogOpt = service.selectByOneId(1);
		if(blogOpt.isPresent()){
			System.out.println(blogOpt.get());
		}else {
			System.out.println("해당데이터 존재안함");
		}
		System.out.println("데이터 취득 완료");
	}
	private void update(){
		Blog blog = new Blog(1,"이름244442","yww22","123",Timestamp.valueOf(LocalDateTime.now()),"ywwsun45@naver.com");
		service.updateMember(blog);
		System.out.println("데이터 업데이트 완료");
	}
	private void delete(){
		System.out.println("삭제준비");
		service.deleteMember(2);
		System.out.println("삭제완료");
	}

}
