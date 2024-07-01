package org.example.filterexam2;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void list(){
        User user = UserContext.getUser();
        // user 유무에 따라 비즈니스가 처리될 수 있음
        System.out.println(user);
    }
}
