package com.jimesh.cartservice.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class CartEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID userId;
    private UUID restaurantId;
    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id") // optional, but helpful
    private List<CartItemEntity> items;
}