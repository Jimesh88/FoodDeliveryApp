package com.jimesh.orderservice.infrastructure;

import com.jimesh.orderservice.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderEntity, UUID> {
}