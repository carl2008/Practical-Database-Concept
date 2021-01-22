package com.rmit.Practical_Database_Concept.user.repository;

import com.rmit.Practical_Database_Concept.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findOneById(int id);

    User findUserByUsername(String username);

    Optional<User> findByUsername(String username);
    User deleteById (int id);
}
