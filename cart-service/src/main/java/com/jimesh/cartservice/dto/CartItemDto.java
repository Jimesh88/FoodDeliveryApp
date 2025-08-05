package com.jimesh.cartservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CartItemDto {
    private UUID itemId;
    private String itemName;
    private int quantity;
    private double price;
}