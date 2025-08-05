package com.jimesh.restaurantservice.infrastructure;

import com.jimesh.restaurantservice.model.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, UUID> {
}