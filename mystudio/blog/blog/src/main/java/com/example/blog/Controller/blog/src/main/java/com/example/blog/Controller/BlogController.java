package com.example.blog.Controller;

import com.example.blog.Entity.Blog;
import com.example.blog.Entity.BlogLogin;
import com.example.blog.Form.BlogContentForm;
import com.example.blog.Form.BlogForm;
import com.example.blog.Form.BlogLoginForm;
import com.example.blog.Repository.BlogRepository;
import com.example.blog.Service.BlogService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    BlogService service;


    @ModelAttribute
    public BlogForm setBlogForm(){
        BlogForm form = new BlogForm();
        return form;
    }
    @ModelAttribute
    public BlogLoginForm setLoginForm(){
        BlogLoginForm form = new BlogLoginForm();
        return  form;
    }
    @ModelAttribute
    public BlogContentForm setContentForm(){
        BlogContentForm form = new BlogContentForm();
        return form;
    }

    @GetMapping("/login")
    public String loginPg(BlogLoginForm blogLoginForm,Model model){
        return "login";
    }

    @PostMapping("/login")
    public String loginInsertPg(@Validated BlogLoginForm blogLoginForm, Model model, RedirectAttributes redirectAttributes
    , BindingResult result){


        return "login";
    }
    @GetMapping("/login/check")
    public String checkPg(){
        return "check";
    }
    @PostMapping("/login/check")
    public String check(Model model){
        model.addAttribute("complete","가입완료했습니다!");
        model.addAttribute("complete2","로그인해주세요!");
        return "check";
    }
    @GetMapping("/login/register")
    public String insertPg(){
        return "insert";
    }
    @PostMapping("login/register")
    public String RegisterInsertPg(@Validated BlogForm blogForm,Model model,RedirectAttributes redirectAttributes,BindingResult bindingResult ){
        blogForm.setNewMember(true);
        Blog blog = new Blog();
        blog.setNumber(blogForm.getNumber());
        blog.setId(blogForm.getId());
        blog.setPsw(blogForm.getPsw());
        blog.setName(blogForm.getName());
        blog.setEmail(blogForm.getEmail());


        if(!bindingResult.hasErrors()){
            service.insertMember(blog);
            redirectAttributes.addFlashAttribute("complete","가입완료했습니다!");
            redirectAttributes.addFlashAttribute("complete2","로그인해주세요!");
            return "redirect:/login/check";
        }else {
            redirectAttributes.addFlashAttribute("failed","오류발생 다시시도해주세요.");
            return "redirect:/login/register";
        }
    }
    @GetMapping("login/home")
    public String loginDo(BlogLoginForm blogLoginForm,Model model){

        return "blog";
    }
    @PostMapping("login/home")
    public String joinHome(@Validated BlogLoginForm blogLoginForm, RedirectAttributes redirectAttributes,
     BindingResult bindingResult, HttpServletRequest httpServletRequest, Model model){
        Blog blog = new Blog();
        blog.setNumber(blogLoginForm.getNumber());
        blog.setId(blogLoginForm.getId());
        blog.setPsw(blogLoginForm.getPsw());

        System.out.println(blogLoginForm);
        Optional<Blog> blogLogin = service.selectOneByBlogId(blogLoginForm.getId(),blogLoginForm.getPsw());
        System.out.println(blogLogin);


       if(!blogLogin.isEmpty()){
           System.out.println(blogLogin);
           System.out.println("값이맞음");


           HttpSession session = httpServletRequest.getSession();
           session.setAttribute("user",blogLoginForm);
           redirectAttributes.addFlashAttribute("loginComplete","환영합니다!");
           return "redirect:/login/home";
       }else {
           model.addAttribute("msg","계정입력을해주세요!");
           System.out.println("값이틀림");
           redirectAttributes.addFlashAttribute("loginFailed","로그인 실패 했습니다.");
           return "redirect:/login/home/fail";


       }
    }
    @GetMapping("/login/home/fail")
    public String logout(Model model,RedirectAttributes redirectAttributes
    ,HttpServletRequest httpServletRequest){

//        HttpSession session = httpServletRequest.getSession();
//        session.invalidate();


        return "fail";
    }


}


