package com.rmit.Practical_Database_Concept.categories.service;

import com.rmit.Practical_Database_Concept.categories.repository.CategoriesRepository;
import com.rmit.Practical_Database_Concept.categories.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@Transactional
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public List<Categories> listAll() {
        return categoriesRepository.findAll();
    }

    public ResponseEntity<Categories> findById(int id) {
        try {
            Categories categories = categoriesRepository.findById(id);

            return new ResponseEntity<Categories>(categories, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }
    }

    public void save(Categories categories) {
        categoriesRepository.save(categories);
    }

    public ResponseEntity<?> update(Categories categories, int id) {
        try {
            Categories existCategory = categoriesRepository.findById(id);

            categories.setId(id);

            categoriesRepository.save(categories);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void delete(int id) {
        categoriesRepository.deleteById(id);
    }
}
