package com.jimesh.deliveryservice.api.adapter;

import com.jimesh.deliveryservice.domain.model.Delivery;
import com.jimesh.deliveryservice.dto.DeliveryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryApiMapper {
    DeliveryDto toDto(Delivery delivery);
    Delivery toDomain(DeliveryDto dto);
}