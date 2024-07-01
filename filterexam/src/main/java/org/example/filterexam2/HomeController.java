package org.example.filterexam2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
//  @Autowired
    private final UserService userService;

    // public HomeController(){ log.info("HomeController 생성자 실행"); }

    @GetMapping("/")
    public String home(){
        log.info("home() 실행");
        return "home";
    }

    @GetMapping("/hi")
    public String hi(){
        User user = UserContext.getUser();
        log.info("hi()" + user);
        return "hi";
    }

    @GetMapping("/hello")
    public String hello(){
        userService.list();
        log.info("hello() 실행");
        return "hello";
    }
}