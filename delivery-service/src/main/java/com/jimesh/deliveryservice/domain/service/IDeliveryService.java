package com.jimesh.deliveryservice.domain.service;

import com.jimesh.deliveryservice.domain.model.Delivery;

import java.util.UUID;

public interface IDeliveryService {
    Delivery create(Delivery delivery);
    Delivery getById(UUID id);
}