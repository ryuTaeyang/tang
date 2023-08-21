package com.example.home.Controller;

import com.example.home.Entity.Home;
import com.example.home.Form.HomeForm;
import com.example.home.Form.LoginForm;
import com.example.home.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeService service;

//    form-backing bean의 초기화
    @ModelAttribute
    public HomeForm setUpForm(){
        HomeForm form = new HomeForm();
        return form;
    }
    @GetMapping
    public String blogPg(){
        return "blog";
    }
//    홈페이지
    @GetMapping("/login/register")
    public String registerPg(HomeForm homeForm,Model model){

        return "register";
    }
    @PostMapping("/login/register")
    public String register_Do(@Validated HomeForm homeForm,BindingResult result,Model model,RedirectAttributes redirectAttributes){
        Home home = new Home();
        home.setNum(homeForm.getNum());
        home.setId(homeForm.getId());
        home.setPsw(homeForm.getPsw());
        home.setUser_name(homeForm.getUser_name());
        home.setEmail(homeForm.getEmail());
//        home.setContent(home.getContent());
//        home.setTitle(home.getTitle());

        if(!result.hasErrors()){
            service.insertMember(home);
            redirectAttributes.addFlashAttribute("msg","가입이 완료 되었습니다!");
            return "redirect:/home/login";
        }else {
            redirectAttributes.addFlashAttribute("fail","가입 오류");
            return "redirect:/home/login";

        }

    }
//    가입
    
    @GetMapping("/login")
    public String loginPg(){
        return "login";
    }
    @PostMapping("/login")
    public String login_Do(@Validated LoginForm loginForm, Model model, RedirectAttributes redirectAttributes
    , BindingResult result, HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.setAttribute("user",loginForm);
        session.setAttribute("user",loginForm);
        Optional<Home> home = service.selectOneById(loginForm.getNum());
        Boolean homeOpt = service.check(loginForm.getNum(),loginForm.getPsw());

        if(!home.isPresent()){
            redirectAttributes.addFlashAttribute()
        }

    }
//    로그인
    
//    @PostMapping("/login")
//    public String login_do(@Validated HomeForm homeForm, Model model, BindingResult bindingResult
//    , RedirectAttributes redirectAttributes){
//
//        return "home";
//    }
}
