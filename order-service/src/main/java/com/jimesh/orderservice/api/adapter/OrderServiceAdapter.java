package com.jimesh.orderservice.api.adapter;

import com.jimesh.orderservice.domain.model.Order;
import com.jimesh.orderservice.domain.service.IOrderService;
import com.jimesh.orderservice.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.openapitools.client.api.DefaultApi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderServiceAdapter  {

    private final IOrderService orderService;
    private final OrderApiMapper orderApiMapper;


    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        Order domainOrder = orderApiMapper.toDomain(orderDto);
        Order savedOrder = orderService.createOrder(domainOrder);
        return ResponseEntity.ok(orderApiMapper.toDto(savedOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable UUID id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(orderApiMapper.toDto(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable UUID id, @RequestBody OrderDto orderDto) {
        Order orderToUpdate = orderApiMapper.toDomain(orderDto);
        orderToUpdate.setId(id);
        Order updatedOrder = orderService.updateOrder(id,orderToUpdate);
        return ResponseEntity.ok(orderApiMapper.toDto(updatedOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable UUID id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        List<OrderDto> dtoList = orders.stream()
                .map(orderApiMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }
}
