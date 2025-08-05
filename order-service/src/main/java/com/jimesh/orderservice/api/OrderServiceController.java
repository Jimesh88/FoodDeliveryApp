package com.jimesh.orderservice.api;


import com.jimesh.orderservice.api.adapter.OrderServiceAdapter;
import com.jimesh.orderservice.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderServiceController {

    private final OrderServiceAdapter adapter;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto dto) {
        return adapter.createOrder(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable UUID id) {
        return adapter.getOrder(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable UUID id, @RequestBody OrderDto dto) {
        return adapter.updateOrder(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        return adapter.deleteOrder(id);
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return adapter.getAllOrders();
    }
}
