package com.jimesh.restaurantservice.domain.service;



import com.jimesh.restaurantservice.domain.model.Restaurant;
import com.jimesh.restaurantservice.infrastructure.RestaurantMapper;
import com.jimesh.restaurantservice.infrastructure.RestaurantRepository;
import com.jimesh.restaurantservice.model.RestaurantEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements IRestaurantService {

    private final RestaurantRepository repository;
    private final RestaurantMapper mapper;

    @Override
    public Restaurant create(Restaurant restaurant) {
        RestaurantEntity entity = mapper.toEntity(restaurant);
        RestaurantEntity saved = repository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Restaurant getById(UUID id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Restaurant update(UUID id, Restaurant restaurant) {
        RestaurantEntity existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found"));
        RestaurantEntity updatedEntity = mapper.toEntity(restaurant);
        updatedEntity.setId(id); // ensure ID is maintained
        return mapper.toDomain(repository.save(updatedEntity));
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
