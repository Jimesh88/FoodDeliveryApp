package com.jimesh.cartservice.domain.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    private UUID itemId;
    private String itemName;
    private int quantity;
    private double price;
}