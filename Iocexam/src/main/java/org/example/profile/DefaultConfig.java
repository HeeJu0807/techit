package org.example.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
// 해당 빈은 명시적으로 다른 프로파일이 활성화되지 않은 경우에만 등록됨
@Profile("default")
public class DefaultConfig {
    @Bean
    public DataService dataService() {
        return new DataService("Default environment");
    }
}
