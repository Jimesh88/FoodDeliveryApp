package com.jimesh.userservice.infrastructure;


import com.jimesh.userservice.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}