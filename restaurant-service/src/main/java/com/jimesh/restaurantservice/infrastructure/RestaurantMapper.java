package com.jimesh.restaurantservice.infrastructure;

import com.jimesh.restaurantservice.domain.model.Restaurant;
import com.jimesh.restaurantservice.model.RestaurantEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RestaurantMapper {
    RestaurantEntity toEntity(Restaurant order);
    Restaurant toDomain(RestaurantEntity entity);
}
