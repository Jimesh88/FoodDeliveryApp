package com.jimesh.deliveryservice.infrastructure;


import com.jimesh.deliveryservice.domain.model.Delivery;
import com.jimesh.deliveryservice.model.DeliveryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DeliveryMapper {
    DeliveryEntity toEntity(Delivery delivery);
    Delivery toDomain(DeliveryEntity entity);
}