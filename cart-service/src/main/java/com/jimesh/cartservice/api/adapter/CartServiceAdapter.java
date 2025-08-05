package com.jimesh.cartservice.api.adapter;


import com.jimesh.cartservice.domain.model.Cart;
import com.jimesh.cartservice.domain.service.ICartService;
import com.jimesh.cartservice.dto.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartServiceAdapter {

    private final ICartService cartService;
    private final CartApiMapper cartApiMapper;

    public ResponseEntity<CartDto> create(CartDto dto) {
        Cart cart = cartApiMapper.toDomain(dto);
        Cart savedCart = cartService.create(cart);
        return ResponseEntity.ok(cartApiMapper.toDto(savedCart));
    }

    public ResponseEntity<CartDto> update(UUID id, CartDto dto) {
        Cart cart = cartApiMapper.toDomain(dto);
        Cart updatedCart = cartService.update(id, cart);
        return ResponseEntity.ok(cartApiMapper.toDto(updatedCart));
    }

    public ResponseEntity<CartDto> getById(UUID id) {
        Cart cart = cartService.getById(id);
        return ResponseEntity.ok(cartApiMapper.toDto(cart));
    }

    public ResponseEntity<List<CartDto>> getAll() {
        List<Cart> carts = cartService.getAll();
        List<CartDto> dtos = carts.stream()
                .map(cartApiMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    public ResponseEntity<Void> delete(UUID id) {
        cartService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
