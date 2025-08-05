package com.jimesh.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class UserDto {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}