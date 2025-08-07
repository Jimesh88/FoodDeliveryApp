package com.jimesh.userservice.domain.service;

import com.jimesh.userservice.domain.model.User;
import com.jimesh.userservice.infrastructure.UserMapper;
import com.jimesh.userservice.infrastructure.UserRepository;
import lombok.RequiredArgsConstructor;
import com.jimesh.userservice.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public User createUser(User user) {
        return mapper.toDomain(repository.save(mapper.toEntity(user)));
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(Integer id, User user) {
        UserEntity entity = mapper.toEntity(user);
        entity.setId(id);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public void deleteUser(Integer id) {
        repository.deleteById(id);
    }
}
