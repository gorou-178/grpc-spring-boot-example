package com.study.grpc;

import com.study.grpc.service.GreetingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UnitTestConfiguration {
    @Bean
    GreetingServiceImpl greetingService() {
        return new GreetingServiceImpl();
    }
}
