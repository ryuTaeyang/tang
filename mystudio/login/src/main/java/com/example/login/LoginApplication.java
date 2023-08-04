package com.example.login;

import com.example.login.Repository.LoginRepository;
import com.example.login.Service.LoginService;
import com.example.login.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@SpringBootApplication
public class LoginApplication {

	public LoginApplication() throws ParseException {
	}

	public static void main(String[] args) {
		SpringApplication.run(LoginApplication.class, args).getBean(LoginApplication.class).execute();
	}

	private void execute() {

//		set();
//		showList();
//		getOneDt();
//		DtUpdate();
//		DtDelete();

	}

	@Autowired
	LoginService service;
	private void set() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("데이터를 등록 합니다.");
		Login login1 = new Login(null,"ywwsun23","류씨입니다","123","작성자",Timestamp.valueOf(LocalDateTime.now()),"ywwsun45@naver.com"	);
//		Login login2 = new Login(null,"ywwbora","zi존","123","지존",Timestamp.valueOf(LocalDateTime.now())""	);
		Login login3 = new Login(null,"rio","리오","123","첫째",Timestamp.valueOf(LocalDateTime.now()) ,"rio@google.com"	);
		Login login4 = new Login(null,"ggomi","꼬맹이","123","둘째",Timestamp.valueOf(LocalDateTime.now()),"ggomi@naver.com"	);
		Login login5 = new Login(null,"sunny","써니","123","막내",Timestamp.valueOf(LocalDateTime.now()) ,"sunny123@onnet.com"	);
		List<Login> LoginList = new ArrayList<>();
		Collections.addAll(LoginList,login1,login3,login4,login5);
		for(Login login:LoginList){
			service.insertUser(login);
		}
		System.out.println("데이터 등록 완료했습니다");

	}
    private  void showList(){
		System.out.println("데이터 리스트를 확인중");
		Iterable<Login> logins = service.selectAll();
//		System.out.println(repository.showAll());

		for(Login login : logins){
			System.out.println(login);
		}
		System.out.println("데이터 리스트"+logins+"확인 완료");
	}
	private void getOneDt(){
		System.out.println("데이터 1건 취득 준비");
		Optional<Login> loginOpt =service.selectOneById(22);
		if(loginOpt.isPresent()){
			System.out.println(loginOpt.get());
		}else {
			System.out.println("해당 데이터 존재 하지 않습니다");
		}
		System.out.println("데이터 1건 취득 완료");
	}
	private void DtUpdate(){
		System.out.println("데이터 변경 준비중");
		Login login3 = new Login(null,"rio","리오","123","첫째",Timestamp.valueOf(LocalDateTime.now()) ,"rio@google.com"	);
		service.updateUser(login3);
		System.out.println("데이터 변경"+login3+"되었습니다");

	}
   private void DtDelete(){
	   System.out.println("데이터 삭제 준비중");
	  service.deleteUserById(68);
	   System.out.println(68 +"의 데이터가 삭제되었습니다");
   }


}
