package com.rmit.Practical_Database_Concept.categories.repository;

import com.rmit.Practical_Database_Concept.categories.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriesRepository extends JpaRepository<Categories, UUID> {}
