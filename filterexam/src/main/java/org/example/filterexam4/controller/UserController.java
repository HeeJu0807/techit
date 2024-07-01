package org.example.filterexam4.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.filterexam4.entity.User;
import org.example.filterexam4.filter.UserContext;
import org.example.filterexam4.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/loginform")
    public String loginform() {
        return "loginform";
    }

    @PostMapping("/login")
    public String loginform(@ModelAttribute("user") User user, HttpServletResponse response) {
        //사용자가 보낸 username과 password 가 서버가 원하는 정보랑 일치하는지 확인하고
        //사용자 정보를 유지하게 하면 된다
        User byUser = userService.findByUsername(user.getUsername());

        if(byUser != null && user.getPassword().equals(byUser.getPassword())) {
            Cookie cookie = new Cookie("auth", user.getUsername());
            cookie.setPath("/");
            cookie.setHttpOnly(true);   // 자바스크립트로는 쿠키에 접근 x

            //생성된 쿠키가 클라이언트에게 보내져야 함
            response.addCookie(cookie);
            // 같은 이름으로 쿠키가 다시 들어오면 쿠키는 덮어씀
            // 이걸 이용해서 로그아웃 구현 가능
            return "redirect:/welcome";
        } else {
            return "redirect:/loginform";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        // 쿠키를 삭제하면 로그아웃이 됨
        // 브라우저의 쿠키는 서버에서 삭제할 수 없음
        // 그래서 똑같은 이름의 쿠키를 만들어 보냄
        Cookie cookie = new Cookie("auth", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);

        response.addCookie(cookie);
        return "redirect:/loginform";
    }

    @GetMapping("/welcome")
    public String welcome() {
        User user = UserContext.getUser();
        if(user != null) {
            return "welcome";
        }else {
            return "redirect:/loginform";
        }
    }

    @GetMapping("/info")
    public String info(HttpServletRequest request) {
//        User user = UserContext.getUser();
//        if(user != null)
            return "info";
//        else
//          return "redirect:/loginform";
    }
}
