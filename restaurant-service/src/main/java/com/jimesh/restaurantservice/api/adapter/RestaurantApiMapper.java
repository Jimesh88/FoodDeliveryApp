package com.jimesh.restaurantservice.api.adapter;

import com.jimesh.restaurantservice.domain.model.Restaurant;
import com.jimesh.restaurantservice.dto.RestaurantDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface RestaurantApiMapper {

    RestaurantDto toDto(Restaurant order);
    Restaurant toDomain(RestaurantDto dto);
}
