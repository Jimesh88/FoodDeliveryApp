package com.jimesh.deliveryservice.api;


import com.jimesh.deliveryservice.api.adapter.DeliveryServiceAdapter;
import com.jimesh.deliveryservice.dto.DeliveryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryServiceController {

    private final DeliveryServiceAdapter adapter;

    @PostMapping
    public ResponseEntity<DeliveryDto> create(@RequestBody DeliveryDto dto) {
        return ResponseEntity.ok(adapter.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDto> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(adapter.getById(id));
    }
}
