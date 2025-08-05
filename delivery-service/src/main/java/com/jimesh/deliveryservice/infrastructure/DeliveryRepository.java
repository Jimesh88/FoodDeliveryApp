package com.jimesh.deliveryservice.infrastructure;

import com.jimesh.deliveryservice.model.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, UUID> {
}