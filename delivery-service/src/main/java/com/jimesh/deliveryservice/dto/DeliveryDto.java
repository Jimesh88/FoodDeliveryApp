package com.jimesh.deliveryservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryDto {
    private UUID id;
    private UUID orderId;
    private UUID agentId;
    private String address;
    private String status;
    private LocalDateTime estimatedDeliveryTime;
}