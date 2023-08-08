package com.example.demo1.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("member")
public class MemberController {
    @GetMapping("test")
    public String test(){
        return "test";
    }


    @PostMapping("login_do")
    public String login(@RequestParam String id, @RequestParam String pws , Model model , RedirectAttributes redirectAttributes,
    HttpServletRequest httpServletRequest){
        String userId =  "test";
        String userPws = "1234";
//        System.out.println(id+" : " +pws);
        if(userId.equals(id) && userPws.equals(pws)){
            HttpSession session = httpServletRequest.getSession();
            session.setAttribute("user",id);
        }else {
            redirectAttributes.addFlashAttribute("fail","로그인실패");
            model.addAttribute("fail","로그인실패");
        }
  return "index";
    }
    @GetMapping("logout")
    public String logout(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        session.invalidate();
        return "index";

    }


}