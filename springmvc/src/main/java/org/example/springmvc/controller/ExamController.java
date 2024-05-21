package org.example.springmvc.controller;

import org.example.springmvc.domain.Item;
import org.example.springmvc.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    //http://localhost/users   사용자 목록을 출력하세요.
    //사용자목록에서 사용자,  관리자여부
    // --  이 값을 메시지프로퍼티를 이용해서 출력하도록 작성
    //Controller나 메서드명은 원하는대로 작성하셔도 좋습니다.
}
