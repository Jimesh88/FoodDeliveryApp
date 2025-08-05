package com.jimesh.deliveryservice.api.adapter;



import com.jimesh.deliveryservice.domain.model.Delivery;
import com.jimesh.deliveryservice.domain.service.IDeliveryService;
import com.jimesh.deliveryservice.dto.DeliveryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DeliveryServiceAdapter {

    private final IDeliveryService service;
    private final DeliveryApiMapper mapper;

    public DeliveryDto create(DeliveryDto dto) {
        Delivery delivery = mapper.toDomain(dto);
        Delivery saved = service.create(delivery);
        return mapper.toDto(saved);
    }

    public DeliveryDto getById(UUID id) {
        Delivery delivery = service.getById(id);
        return mapper.toDto(delivery);
    }
}
