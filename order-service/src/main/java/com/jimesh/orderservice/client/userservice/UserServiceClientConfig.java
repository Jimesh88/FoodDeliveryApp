package com.jimesh.orderservice.client.userservice;

import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DefaultApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class UserServiceClientConfig {

    @Value("${user-service.base-url}")
    private String userServiceBaseUrl;

    @Bean
    public WebClient userServiceWebClient(WebClient.Builder builder) {
        return builder
                .baseUrl(userServiceBaseUrl)
                .build();
    }

    @Bean
    public ApiClient userServiceApiClient(WebClient userServiceWebClient) {
        ApiClient apiClient = new ApiClient(userServiceWebClient);
        apiClient.setBasePath(userServiceBaseUrl); // ✅ Use property instead of hardcoding
        return apiClient;
    }

    @Bean
    public DefaultApi defaultApi(ApiClient userServiceApiClient) {
        return new DefaultApi(userServiceApiClient);
    }
}
