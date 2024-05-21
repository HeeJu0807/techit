package org.example.message2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration

// 설정 클래스들을 하나의 클래스에서 통합하여 사용
@Import(ServiceConfig.class)
public class MainConfig {
    // 추가 설정이 있다면 여기에

    MainConfig(){
        System.out.println("MainConfig 생성");
    }
}
