package com.jimesh.orderservice.dto;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderDto {
    private UUID id;
    private Integer userId;
    private  UUID restaurantId;
    private List<UUID> itemIds;
    private double totalPrice;
    private String status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
