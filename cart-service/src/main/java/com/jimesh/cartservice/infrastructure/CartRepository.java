package com.jimesh.cartservice.infrastructure;

import com.jimesh.cartservice.model.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<CartEntity, UUID> {
}