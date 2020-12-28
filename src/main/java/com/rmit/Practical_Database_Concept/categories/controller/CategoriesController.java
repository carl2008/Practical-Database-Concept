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

    @Autowired
    private final CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping()
    public List<Categories> list() {
        return categoriesService.listAll();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable int id) {
        return categoriesService.findById(id);
    }

    @PostMapping("/v2")
    public void createNewCategory(@RequestBody Categories categories) {
        categoriesService.save(categories);
    }

    @PutMapping(path = "/v2/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Categories categories, @PathVariable int id) {
        return categoriesService.update(categories, id);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {
        categoriesService.delete(id);
    }
}
