package com.jimesh.deliveryservice.domain.service;

import com.jimesh.deliveryservice.domain.model.Delivery;
import com.jimesh.deliveryservice.infrastructure.DeliveryMapper;
import com.jimesh.deliveryservice.infrastructure.DeliveryRepository;
import com.jimesh.deliveryservice.model.DeliveryEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeliveryServiceImpl implements IDeliveryService {

    private final DeliveryRepository repository;
    private final DeliveryMapper mapper;

    public DeliveryServiceImpl(DeliveryRepository repository, DeliveryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Delivery create(Delivery delivery) {
        DeliveryEntity entity = mapper.toEntity(delivery);
        DeliveryEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Delivery getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
    }
}
