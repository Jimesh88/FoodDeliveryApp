package com.jimesh.deliveryservice.domain.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Delivery {
    private UUID id;
    private UUID orderId;
    private UUID agentId;
    private String address;
    private String status; // PENDING, DISPATCHED, DELIVERED
    private LocalDateTime estimatedDeliveryTime;
}
