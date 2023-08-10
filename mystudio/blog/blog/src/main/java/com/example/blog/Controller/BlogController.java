package com.example.blog.Controller;

import com.example.blog.Entity.Blog;
import com.example.blog.Form.BlogForm;
import com.example.blog.Form.BlogLoginForm;
import com.example.blog.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class BlogController {
    @Autowired
    BlogService service;
    @ModelAttribute
    private BlogForm SET(){
        BlogForm form  = new BlogForm();
        return form;
    }
    @ModelAttribute
    private BlogLoginForm Set(){
        BlogLoginForm form = new BlogLoginForm();
        return form;
    }
    @GetMapping("/signUp")
    public String signUpPg(){
        return "signUp";
    }
    @GetMapping("signUp/login")
    public String loginPg(){
        return "login";
    }

    @PostMapping("/signUp/login")
    public String signUpInsertPg(@Validated BlogForm blogForm, Model model, BindingResult result, RedirectAttributes redirectAttributes){
        blogForm.setNewMember(true);
        Blog blog =new Blog();
        blog.setNum(blogForm.getNum());
        blog.setId(blogForm.getId());
        blog.setPsw(blogForm.getPsw());
        blog.setName(blogForm.getName());
        blog.setEmail(blogForm.getEmail());



        if(!result.hasErrors()){
            service.insertMember(blog);
            redirectAttributes.addFlashAttribute("complete","회원가입 완료되었습니다!");
            return "redirect:login";
        }else {
            redirectAttributes.addFlashAttribute("failed","오류 발생 다시 시도해주세요!");
            return "redirect:signUp";
        }

    }

}
