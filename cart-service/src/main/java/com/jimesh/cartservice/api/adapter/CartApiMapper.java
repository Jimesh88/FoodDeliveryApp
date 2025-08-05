package com.jimesh.cartservice.api.adapter;


import com.jimesh.cartservice.domain.model.Cart;
import com.jimesh.cartservice.dto.CartDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CartApiMapper {
    CartDto toDto(Cart cart);
    Cart toDomain(CartDto dto);
}
