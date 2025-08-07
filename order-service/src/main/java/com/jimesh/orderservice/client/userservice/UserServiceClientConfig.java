package com.jimesh.orderservice.client.userservice;


import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DefaultApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UserServiceClientConfig {

    @Bean
    public WebClient userServiceWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl("http://localhost:8086")
                .build();
    }

    @Bean
    public ApiClient userServiceApiClient(WebClient userServiceWebClient) {
        ApiClient apiClient = new ApiClient(userServiceWebClient);
        apiClient.setBasePath("http://localhost:8086"); // Set base URL here
        return apiClient;
    }

    @Bean
    public DefaultApi defaultApi(ApiClient userServiceApiClient) {
        return new DefaultApi(userServiceApiClient);
    }
}
