package com.jimesh.deliveryservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private UUID orderId;

    @Column(nullable = false)
    private UUID agentId;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String status;

    private LocalDateTime estimatedDeliveryTime;
}
