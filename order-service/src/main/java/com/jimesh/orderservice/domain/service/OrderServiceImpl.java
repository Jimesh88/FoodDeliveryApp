package com.jimesh.orderservice.domain.service;


import com.jimesh.orderservice.client.userservice.UserServiceClientConfig;
import com.jimesh.orderservice.domain.model.Order;
import com.jimesh.orderservice.infrastructure.OrderMapper;
import com.jimesh.orderservice.infrastructure.OrderRepository;
import com.jimesh.orderservice.model.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.openapitools.client.api.DefaultApi;
import org.openapitools.client.model.UserDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository repository;
    private final OrderMapper mapper;

    private final DefaultApi userApi;


    @Override
    public Order createOrder(Order order) {
        try {

            Mono<UserDto> userMono = userApi.getUser(order.getUserId());
            UserDto user = userMono.block(); // Use block() only if you're in non-reactive code

            System.out.println("Order placed for user: " + user.getName());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("User service call failed", e);
        }

        return mapper.toDomain(repository.save(mapper.toEntity(order)));
    }

    @Override
    public Order getOrderById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public Order updateOrder(UUID id, Order order) {
        OrderEntity entity = mapper.toEntity(order);
        entity.setId(id);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deleteOrder(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}

