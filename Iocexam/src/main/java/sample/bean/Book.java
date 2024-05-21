package sample.bean;

import org.springframework.stereotype.Component;

//@Component : 해당 클래스를 자동으로 스프링 빈으로 등록
@Component
public class Book {
    private String title;
    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
