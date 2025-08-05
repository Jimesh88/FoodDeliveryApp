package com.jimesh.userservice.api.adapter;

import com.jimesh.userservice.domain.service.IUserService;
import com.jimesh.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserServiceAdapter {

    private final IUserService service;
    private final UserApiMapper mapper;

    public UserDto createUser(UserDto userDto) {
        return mapper.toDto(service.createUser(mapper.toDomain(userDto)));
    }

    public UserDto getUser(UUID id) {
        return mapper.toDto(service.getUserById(id));
    }

    public UserDto updateUser(UUID id, UserDto userDto) {
        return mapper.toDto(service.updateUser(id, mapper.toDomain(userDto)));
    }

    public void deleteUser(UUID id) {
        service.deleteUser(id);
    }
}