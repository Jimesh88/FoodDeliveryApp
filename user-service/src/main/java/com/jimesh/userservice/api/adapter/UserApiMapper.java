package com.jimesh.userservice.api.adapter;

import com.jimesh.userservice.domain.model.User;
import com.jimesh.userservice.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserApiMapper {
    UserDto toDto(User user);
    User toDomain(UserDto userDto);
}
