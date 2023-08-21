package com.example.home;

import com.example.home.Entity.Home;
import com.example.home.Repository.HomeRepository;
import com.example.home.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeApplication.class, args).getBean(HomeApplication.class).execute();
	}
	@Autowired
	HomeService service;
	private  void  execute(){
//		setUp();
//		showList();
//		getOneById();
//		update();
//		delete();
	}
//	private void setUp(){
//		ZonedDateTime zonedDateTime = ZonedDateTime.now();
//		System.out.println("데이터추가중");
//		Home home1 = new Home(null,"id1","psw1","name1","email@1","내용1","제목1",Timestamp.valueOf(LocalDateTime.now()));
//		Home home2 = new Home(null,"id2","psw2","name2","email@2","내용2","제목2",Timestamp.valueOf(LocalDateTime.now()));
//		Home home3 = new Home(null,"id3","psw3","name3","email@3","내용3","제목3",Timestamp.valueOf(LocalDateTime.now()));
//		Home home4 = new Home(null,"id4","psw4","name4","email@4","내용4","제목4",Timestamp.valueOf(LocalDateTime.now()));
//		List<Home> homeList = new ArrayList<>();
//		Collections.addAll(homeList,home1,home2,home3,home4);
//		for(Home home :homeList){
//			service.insertMember(home);
//		}
//		System.out.println("데이터 등록 완료");
//
//
//
//
//	}
//	private void showList(){
//		System.out.println("데이터 리스트");
//		Iterable<Home> HomeList = service.selectAll();
//		for(Home home : HomeList){
//			System.out.println(HomeList);
//
//		}
//		System.out.println("모든 데이터 리스트");
//	}
//	private void getOneById(){
//		System.out.println("데이터 하나 가져오기");
//		Optional<Home> homeOpt = service.selectOneById(1);
//		if(homeOpt.isPresent()){
//			System.out.println(homeOpt.get());
//
//		}else {
//			System.out.println("데이터 존재 하지 않음");
//		}
//		System.out.println("데이터 취득 완료");
//	}
//	private void update(){
//		System.out.println("데이터 업데이트");
//		Home home = new Home(6,"yww3345","패스워드2123","이름임1","ywwsun453@naver.com","내용임23","제목임34",Timestamp.valueOf(LocalDateTime.now()));
//		service.updateMember(home);
//		System.out.println("업데이트"+home+"완료");
//	}
//	private void delete(){
//		System.out.println("데이터 삭제 준비");
//		service.deleteMember(3);
//		System.out.println("데이터"+3+"삭제 완료");
//	}
}
