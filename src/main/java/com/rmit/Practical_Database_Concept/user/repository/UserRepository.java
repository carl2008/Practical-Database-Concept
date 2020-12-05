package com.rmit.Practical_Database_Concept.user.repository;

import com.rmit.Practical_Database_Concept.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findOneById(UUID id);

    Optional<User> findByUsername(String username);
}
