package com.jimesh.cartservice.domain.service;


import com.jimesh.cartservice.domain.model.Cart;
import com.jimesh.cartservice.infrastructure.CartMapper;
import com.jimesh.cartservice.infrastructure.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {

    private final CartRepository repository;
    private final CartMapper mapper;

    @Override
    public Cart create(Cart cart) {
        return mapper.toDomain(repository.save(mapper.toEntity(cart)));
    }

    @Override
    public Cart update(UUID id, Cart cart) {
        cart.setId(id);
        return mapper.toDomain(repository.save(mapper.toEntity(cart)));
    }

    @Override
    public Cart getById(UUID id) {
        return mapper.toDomain(repository.findById(id).orElseThrow());
    }

    @Override
    public List<Cart> getAll() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
