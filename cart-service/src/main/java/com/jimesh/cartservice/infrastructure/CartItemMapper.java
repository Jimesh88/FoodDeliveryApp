package com.jimesh.cartservice.infrastructure;

import com.jimesh.cartservice.domain.model.CartItem;
import com.jimesh.cartservice.model.CartItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartItemMapper {
    CartItemEntity toEntity(CartItem item);
    CartItem toDomain(CartItemEntity entity);
}