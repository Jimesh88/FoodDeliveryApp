package com.jimesh.userservice.infrastructure;

import com.jimesh.userservice.domain.model.User;
import com.jimesh.userservice.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserEntity toEntity(User user);
    User toDomain(UserEntity entity);
}