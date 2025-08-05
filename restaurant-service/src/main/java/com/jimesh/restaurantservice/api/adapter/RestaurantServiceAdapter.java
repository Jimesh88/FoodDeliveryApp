package com.jimesh.restaurantservice.api.adapter;


import com.jimesh.restaurantservice.domain.model.Restaurant;
import com.jimesh.restaurantservice.domain.service.IRestaurantService;
import com.jimesh.restaurantservice.dto.RestaurantDto;
import com.jimesh.restaurantservice.api.adapter.RestaurantApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/restaurants")
public class RestaurantServiceAdapter {

    private final IRestaurantService restaurantService;
    private final RestaurantApiMapper restaurantApiMapper;

    @PostMapping
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantApiMapper.toDomain(restaurantDto);
        Restaurant saved = restaurantService.create(restaurant);
        return ResponseEntity.ok(restaurantApiMapper.toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable UUID id) {
        Restaurant restaurant = restaurantService.getById(id);
        return ResponseEntity.ok(restaurantApiMapper.toDto(restaurant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> updateRestaurant(@PathVariable UUID id, @RequestBody RestaurantDto restaurantDto) {
        Restaurant updatedRestaurant = restaurantApiMapper.toDomain(restaurantDto);
        updatedRestaurant.setId(id);
        Restaurant updated = restaurantService.update(id, updatedRestaurant);
        return ResponseEntity.ok(restaurantApiMapper.toDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable UUID id) {
        restaurantService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAll();
        List<RestaurantDto> dtoList = restaurants.stream()
                .map(restaurantApiMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
}
