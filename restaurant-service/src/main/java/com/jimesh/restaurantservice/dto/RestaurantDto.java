package com.jimesh.restaurantservice.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {
    private UUID id;
    private String name;
    private String address;
    private String contactNumber;
    private String cuisineType;
}