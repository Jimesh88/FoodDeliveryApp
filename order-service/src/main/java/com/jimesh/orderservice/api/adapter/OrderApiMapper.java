package com.jimesh.orderservice.api.adapter;

import com.jimesh.orderservice.dto.OrderDto;
import com.jimesh.orderservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderApiMapper {
    OrderDto toDto(Order order);
    Order toDomain(OrderDto dto);
}