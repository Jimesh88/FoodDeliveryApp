package com.jimesh.cartservice.api.adapter;


import com.jimesh.cartservice.dto.CartDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartServiceController {

    private final CartServiceAdapter adapter;

    @PostMapping
    public ResponseEntity<CartDto> create(@RequestBody CartDto dto) {
        return adapter.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartDto> update(@PathVariable UUID id, @RequestBody CartDto dto) {
        return adapter.update(id, dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartDto> getById(@PathVariable UUID id) {
        return adapter.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<CartDto>> getAll() {
        return adapter.getAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        return adapter.delete(id);
    }
}

