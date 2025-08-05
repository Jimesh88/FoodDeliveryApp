package com.jimesh.restaurantservice.api;

import com.jimesh.restaurantservice.api.adapter.RestaurantServiceAdapter;
import com.jimesh.restaurantservice.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantServiceController {

    private final RestaurantServiceAdapter adapter;

    @PostMapping
    public ResponseEntity<RestaurantDto> create(@RequestBody RestaurantDto restaurantDto) {
        return adapter.createRestaurant(restaurantDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantDto> getById(@PathVariable UUID id) {
        return adapter.getRestaurant(id);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAll() {
        return adapter.getAllRestaurants();
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantDto> update(@PathVariable UUID id, @RequestBody RestaurantDto restaurantDto) {
        return adapter.updateRestaurant(id, restaurantDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return adapter.deleteRestaurant(id);
    }
}
