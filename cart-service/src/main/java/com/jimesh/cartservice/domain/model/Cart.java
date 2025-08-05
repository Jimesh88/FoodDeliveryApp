package com.jimesh.cartservice.domain.model;

import lombok.*;

import java.util.UUID;



import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    private UUID id;
    private UUID userId;
    private UUID restaurantId;
    private List<CartItem> items;
    private double totalPrice;
}