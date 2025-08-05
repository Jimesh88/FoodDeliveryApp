package com.jimesh.cartservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class CartDto {
    private UUID id;
    private UUID userId;
    private UUID restaurantId;
    private List<CartItemDto> items;
    private double totalPrice;
}
