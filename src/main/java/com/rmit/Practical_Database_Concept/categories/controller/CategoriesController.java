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
    public ResponseEntity<Categories> getCategoryById(@PathVariable int id) {
        try {
            Categories categories = categoriesService.findById(id);

            return new ResponseEntity<Categories>(categories, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/v1")
    public void save(@RequestBody Categories categories) {
        categoriesService.save(categories);
    }

    @PutMapping(path = "/v1/{id}")
    public ResponseEntity<?> update(@RequestBody Categories categories, @PathVariable int categoryId) {
        return categoriesService.update(categories, categoryId);
    }

    @DeleteMapping(path = "/v1/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return categoriesService.delete(id);
    }
}
