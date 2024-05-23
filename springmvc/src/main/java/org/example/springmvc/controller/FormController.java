package org.example.springmvc.controller;

import jakarta.validation.Valid;
import org.example.springmvc.domain.User;
import org.example.springmvc.domain.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @GetMapping("/form")
    public String showForm(Model model) {
        // userForm 이라는 이름의 새로운 UserForm 객체를 모델에 추가
        model.addAttribute("userForm", new UserForm());
        return "form";
    }

//    @PostMapping("/submitForm")
    // RequestParam : http 요청 파라미터를 메서드 파라미터에 바인딩
//    public String submitForm(@RequestParam String username,
//                             @RequestParam String password){
//        System.out.println(username+ "::" +password);
//        return "result";
//    }

//    @PostMapping("/submitForm")
    // ModelAttribute User user : 폼 데이터를 User 객체에 바인딩
//    public String submitForm(@ModelAttribute User user){
//        System.out.println(user.getUsername() + "::" + user.getPassword());
//        return "result";
//    }

    @PostMapping("/submitForm")
    public String submitForm(
            @Valid @ModelAttribute("userForm") UserForm userForm,
            BindingResult result){
        if(result.hasErrors()){
            return "form";  // 유효성 검사에서 에러가 발견되었다면 form.html 뷰로 리턴
        }
        return "result";    // 성공했다면 result.html 이 응답
    }
}
