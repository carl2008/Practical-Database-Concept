package com.rmit.Practical_Database_Concept.categories.controller;

import com.rmit.Practical_Database_Concept.categories.model.Categories;
import com.rmit.Practical_Database_Concept.categories.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("api/categories")
public class CategoriesController {

    private final CategoriesService categoriesService;

    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping()
    public List<Categories> list() {
        return categoriesService.listAll();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable UUID id) {
        try {
            Categories categories = categoriesService.findByUuid(id);
            return new ResponseEntity<Categories>(categories, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public void createNewCategory(@RequestBody Categories categories) {
//        categoriesService.save(categories);
    }

    @PutMapping(path = "/v1/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Categories categories, @PathVariable UUID id) {
        try {
            Categories existCategory = categoriesService.findByUuid(id);

            categories.setId(id);

            categoriesService.save(categories);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/v1/{id}")
    public void delete(@PathVariable UUID id) {
        categoriesService.delete(id);
    }
}
