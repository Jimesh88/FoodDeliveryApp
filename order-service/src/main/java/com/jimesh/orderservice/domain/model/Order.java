package com.jimesh.orderservice.domain.model;

import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private UUID id;
    private UUID userId;
    private List<UUID> itemIds;
    private UUID restaurantId;
    private double totalPrice;
    private String status;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}