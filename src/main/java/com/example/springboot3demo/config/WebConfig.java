package com.example.springboot3demo.config;

import com.example.springboot3demo.service.UserClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {

    @Bean
    public WebClient userServiceWebClient() {
        return WebClient
                .builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }

    @Bean
    public UserClientService userClientService() {
         HttpServiceProxyFactory serviceProxyFactory = HttpServiceProxyFactory
                 .builder(WebClientAdapter.forClient(userServiceWebClient())).build();
         return serviceProxyFactory.createClient(UserClientService.class);
    }
}
