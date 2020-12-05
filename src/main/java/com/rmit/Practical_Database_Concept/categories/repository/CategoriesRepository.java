package com.rmit.Practical_Database_Concept.categories.repository;

import com.rmit.Practical_Database_Concept.categories.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, UUID> {
    Categories findOneById(UUID id);
}
