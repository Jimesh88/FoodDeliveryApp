package com.jimesh.restaurantservice.domain.service;

import com.jimesh.restaurantservice.domain.model.Restaurant;
import com.jimesh.restaurantservice.dto.RestaurantDto;

import java.util.List;
import java.util.UUID;

public interface IRestaurantService {
    Restaurant create(Restaurant restaurant);
    Restaurant getById(UUID id);
    List<Restaurant> getAll();
    Restaurant update(UUID id, Restaurant restaurant);
    void delete(UUID id);
}
