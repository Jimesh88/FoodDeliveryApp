package com.jimesh.cartservice.domain.service;

import com.jimesh.cartservice.domain.model.Cart;

import java.util.List;
import java.util.UUID;

public interface ICartService {
    Cart create(Cart cart);
    Cart update(UUID id, Cart cart);
    Cart getById(UUID id);
    List<Cart> getAll();
    void delete(UUID id);
}