package com.jimesh.cartservice.infrastructure;


import com.jimesh.cartservice.domain.model.Cart;
import com.jimesh.cartservice.model.CartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = CartItemMapper.class)
public interface CartMapper {
    CartEntity toEntity(Cart cart);
    Cart toDomain(CartEntity entity);
}
