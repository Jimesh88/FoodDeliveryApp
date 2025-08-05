package com.jimesh.cartservice.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class CartItemEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private UUID itemId;
    private String itemName;
    private int quantity;
    private double price;
}