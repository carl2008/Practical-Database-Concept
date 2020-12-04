package com.rmit.Practical_Database_Concept.user.repository;

import com.rmit.Practical_Database_Concept.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findOneById(UUID id);
}
