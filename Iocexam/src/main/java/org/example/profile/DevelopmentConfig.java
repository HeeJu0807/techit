package org.example.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
// DevelopmentConfig 클래스에 정의된 빈들은 dev 프로파일이 활성화된 경우에만 사용됨
@Profile("dev")
public class DevelopmentConfig {
    @Bean
    public DataService dataService(){
        return new DataService(" Development environment");
    }
}