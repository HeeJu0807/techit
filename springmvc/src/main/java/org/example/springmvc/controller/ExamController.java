package org.example.springmvc.controller;


import org.example.springmvc.domain.Item;
import org.example.springmvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ExamController {
    @GetMapping("/welcome")
    public String welcome(Model model) {
        model.addAttribute("welcomeMsg", "Welcome to Spring MVC");

        List<Item> items = Arrays.asList(
            new Item("pen", 3000),
            new Item("notebook", 50000),
            new Item("cup", 2500)
        );

        model.addAttribute("itemList", items);

        return "welcome";
    }

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Apple", 1.20),
            new Product(2, "Banana", 0.75),
            new Product(3, "Cherry", 2.05)
    ));
    // Product를 적절히 정의하고,

    //url = /products  이렇게 요청하면 응답되도록 메서드를 정의하세요
    //products 를 이용해서 상품 목록이 출력되도록 템플릿을 작성해주세요 (footer 도 잘 나오도록)
    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("products", products);

        return "productList";
    }

    @GetMapping("/example")
    public String showExam(Model model){
        model.addAttribute("username", "carami");
        model.addAttribute("isAdmin",true);
        model.addAttribute("languages", new String[]{"English", "Spanish","German"});

        return "exam";
    }

    @GetMapping("/datetime")
    public String showDateTime(Model model) {
        // 날짜 및 시간 데이터

        // 현재 날짜
        LocalDate date = LocalDate.now();
        // 현재 날짜와 시간
        LocalDateTime dateTime = LocalDateTime.now();
        // 현재 시간
        LocalTime time = LocalTime.now();
        // 서울 시간대로 현재 ZonedDateTime 을 구함
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));

        // 모델에 데이터 추가
        model.addAttribute("currentDate", date);
        model.addAttribute("currentDateTime", dateTime);
        model.addAttribute("currentTime", time);
        model.addAttribute("currentZonedDateTime", zonedDateTime);

        return "datetime"; // Thymeleaf 템플릿 이름
    }

    @GetMapping("/list")
    public String showList(Model model) {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",
                "Item 6", "Item 7", "Item 8", "Item 9", "Item 10");
        model.addAttribute("items", items);
        return "list";
    }

    // {name} 부분은 url의 변수로 사용
    @GetMapping("/guest/{name}")
    public String guest(@PathVariable String name){
        System.out.println(name);
        return "redirect:/datetime";
    }

}
