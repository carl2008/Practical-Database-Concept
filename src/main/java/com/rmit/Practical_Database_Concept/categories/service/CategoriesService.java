package com.rmit.Practical_Database_Concept.categories.service;

import com.rmit.Practical_Database_Concept.categories.repository.CategoriesRepository;
import com.rmit.Practical_Database_Concept.categories.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> listAll() {
        return categoriesRepository.findAll();
    }

    public void save(Categories categories) {
        categoriesRepository.save(categories);
    }

    public Categories findByUuid(UUID id) {
        return categoriesRepository.findOneById(id);
    }

    public void delete(UUID id) {
        categoriesRepository.deleteById(id);
    }
}
