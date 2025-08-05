package com.jimesh.orderservice.domain.service;

import com.jimesh.orderservice.domain.model.Order;

import java.util.List;
import java.util.UUID;

public interface IOrderService {
    Order createOrder(Order order);
    Order getOrderById(UUID id);
    Order updateOrder(UUID id, Order order);
    void deleteOrder(UUID id);
    List<Order> getAllOrders();
}