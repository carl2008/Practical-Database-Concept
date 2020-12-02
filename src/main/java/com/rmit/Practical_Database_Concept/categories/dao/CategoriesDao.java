package com.rmit.Practical_Database_Concept.categories.dao;

import com.rmit.Practical_Database_Concept.categories.model.Categories;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CategoriesDao extends CrudRepository<Categories, UUID> {
}
