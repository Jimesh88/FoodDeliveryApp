package com.jimesh.userservice.domain.service;

import com.jimesh.userservice.domain.model.User;

import java.util.UUID;

public interface IUserService {
    User createUser(User user);
    User getUserById(UUID id);
    User updateUser(UUID id, User user);
    void deleteUser(UUID id);
}