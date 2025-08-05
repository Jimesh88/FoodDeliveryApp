package com.jimesh.orderservice.infrastructure;


import com.jimesh.orderservice.domain.model.Order;
import com.jimesh.orderservice.model.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    OrderEntity toEntity(Order order);
    Order toDomain(OrderEntity entity);
}
