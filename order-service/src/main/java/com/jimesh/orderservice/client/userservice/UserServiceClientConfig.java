package com.jimesh.orderservice.client.userservice;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.DefaultApi;

@Configuration
public class UserServiceClientConfig {

    @Bean
    public ApiClient userApiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath("http://localhost:8086"); //  URL of your user-service
        return apiClient;
    }

    @Bean
    public DefaultApi userApi(ApiClient userApiClient) {
        return new DefaultApi(userApiClient);
    }
}
