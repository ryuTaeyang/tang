package com.example.login.Controller;

import com.example.login.Form.LoginForm;
import com.example.login.Service.LoginService;
import com.example.login.entity.Login;
import org.apache.logging.log4j.message.Message;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.websocket.OnMessage;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@Controller

public class LoginController {
    @Autowired
    LoginService service;

    @ModelAttribute
    public LoginForm setForm(){
            LoginForm form =new LoginForm();
            return form;
    }


    @GetMapping("/home")
    private String home(LoginForm loginForm, Model model){
        loginForm.setNewUser(true);
        Iterable<Login> list = service.selectAll();
        model.addAttribute("list",list);

        return "home";
    }
    @GetMapping("/insert")
    private  String insert1(LoginForm loginForm){
        loginForm.setNewUser(true);
return "/insert";
    }
    @PostMapping("/insert/home")
    private String insert2(@Validated LoginForm loginForm, BindingResult result, Model model, RedirectAttributes redirectAttributes){

        Login login = new Login();
        login.setNo(loginForm.getNo());
        login.setId(loginForm.getId());
        login.setPws(loginForm.getPws());
        login.setName(loginForm.getName());
        login.setAuthor(loginForm.getAuthor());
        login.setEmail(loginForm.getEmail());
        login.setTime(Timestamp.valueOf(LocalDateTime.now()));

        if(!result.hasErrors()) {
            service.insertUser(login);
            redirectAttributes.addFlashAttribute("check", "사용자 데이터 등록 성공");
            return "redirect:/home";
        }else {
            redirectAttributes.addFlashAttribute("fail","실패");
            service.insertUser(login);

        }
        return "redirect:/home";
    }
    @GetMapping("/home/updateUserDt/{no}")
    private String Update_Delete(LoginForm loginForm, @PathVariable Integer no,Model model){
        Optional<Login> logOpt =service.selectOneById(no);

        Optional<LoginForm> formOpt = logOpt.map(t ->makeLoginForm(t));
       if(formOpt.isPresent()){
           loginForm = formOpt.get();
       }

    UpdateUserDt(loginForm,model);

        return "updateUserDt";

    }
    @PostMapping("/home/updateUserDt/{no}")
    public String update(@Validated LoginForm loginForm,BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes){
        Login login =makeLogin(loginForm);
        if(loginForm.getPws().equals("")){
//            System.out.println(loginForm.getPws().equals(""));
            model.addAttribute("hey","값을 넣어야합니다");
            return "updateUserDt";
        }
       if(!bindingResult.hasErrors()) {
           if (service.checkPws(loginForm.getNo(), loginForm.getPws())) {
               service.updateUser(login);
               redirectAttributes.addFlashAttribute("msg1", "변경완료");
               return "redirect:/home";
           } else {
               redirectAttributes.addFlashAttribute("msg2", "비밀번호확인");
               return "redirect:/home/updateUserDt/" + loginForm.getNo();
           }
       }else {
           UpdateUserDt(loginForm , model);
           service.updateUser(login);
           return "redirect:/home";

       }


    }
// @PostMapping("/delete/home/{no}")
// public  String delete( @RequestParam("no") String no , Model model,RedirectAttributes redirectAttributes){
//     service.deleteUserById(Integer.parseInt(no));
//     redirectAttributes.addFlashAttribute("decomplete","삭제 완료");
//     return "redirect:/home";
// }
@PostMapping("/home/delete/{no}")
public  String delete(@RequestParam("no")String no, @Validated LoginForm loginForm,BindingResult result,Model model,RedirectAttributes redirectAttributes) {
     Login  login = makeLogin(loginForm);
    if(loginForm.getPws().equals("")){
        model.addAttribute("hey","값을 넣어야합니다");
        return "/updateUserDt";
    }

    if (!result.hasErrors()) {

        System.out.println(loginForm);
        System.out.println(loginForm.getNo() + " : "+loginForm.getPws());
        System.out.println(service.checkPws(loginForm.getNo(), loginForm.getPws()));


         if(service.checkPws(loginForm.getNo(),loginForm.getPws())){
             System.out.println("test1");
             service.deleteUserById(Integer.valueOf(no));
             System.out.println("test2");
             redirectAttributes.addFlashAttribute("msg3","삭제완료");
             return "redirect:/home";
         }else {
             redirectAttributes.addFlashAttribute("msg4","비밀 번호 확인 바람");
             System.out.println("test3");
             return "redirect:/home/updateUserDt/"+loginForm.getNo();

         }
     }else {
         DeleteUserDt(loginForm,model);
         System.out.println("test4");
         service.updateUser(login);
         return "redirect:/home";
     }
    }




    private void UpdateUserDt(LoginForm form ,Model model){
        model.addAttribute("no", form.getNo());
        form.setNewUser(false);
        model.addAttribute("loginForm",form);
    }

    private void DeleteUserDt(LoginForm form,Model model){
        model.addAttribute("no",form.getNo());
        form.setNewUser(false);
        model.addAttribute("loginForm",form);
    }
//    ===================================

    private Login  makeLogin(LoginForm loginForm){
        Login login = new Login();
        login.setNo(loginForm.getNo());
        login.setTime(loginForm.getTime());
        login.setId(loginForm.getId());
        login.setPws(loginForm.getPws());
        login.setName(loginForm.getName());
        login.setAuthor(loginForm.getAuthor());
        login.setEmail(loginForm.getEmail());

        return login;
    }
//    =====================
    private LoginForm makeLoginForm (Login login){
        LoginForm loginForm = new LoginForm();
        loginForm.setNo(login.getNo());
        loginForm.setTime(login.getTime());
        loginForm.setId(login.getId());
        loginForm.setPws(login.getPws());
        loginForm.setName(login.getName());
        loginForm.setAuthor(login.getAuthor());
        loginForm.setEmail(login.getEmail());
        return loginForm;
    }
}

