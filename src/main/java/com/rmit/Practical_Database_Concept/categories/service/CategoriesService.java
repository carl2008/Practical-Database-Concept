package com.rmit.Practical_Database_Concept.categories.service;

import com.rmit.Practical_Database_Concept.categories.repository.CategoriesRepository;
import com.rmit.Practical_Database_Concept.categories.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CategoriesService {
    private static final String REQUEST_USERNAME = "request_username";

    private ServletRequest servletRequest;

    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository, ServletRequest servletRequest) {
        this.categoriesRepository = categoriesRepository;
        this.servletRequest = servletRequest;
    }

    public List<Categories> listAll() {
        return categoriesRepository.findAll();
    }

    public Categories findById(int id) {
        return categoriesRepository.findOneById(id);
    }

    public void save(Categories categories) {
        categoriesRepository.save(categories);
    }

    public ResponseEntity<?> update(Categories categories, int categoryId) {
        try {
            Categories existCategory = categoriesRepository.findOneById(categoryId);

            categories.setId(categoryId);

            categoriesRepository.save(categories);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> delete(int categoryId) {
        try {
            Categories existCategory = categoriesRepository.findOneById(categoryId);

            categoriesRepository.deleteById(categoryId);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
