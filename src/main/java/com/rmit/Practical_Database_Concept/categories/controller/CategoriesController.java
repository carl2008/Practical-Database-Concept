package com.rmit.Practical_Database_Concept.categories.controller;

import com.rmit.Practical_Database_Concept.categories.dao.CategoriesDao;
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
@RequestMapping("api/v1/categories")
public class CategoriesController {

    private CategoriesService categoriesService;

    private final CategoriesDao categoriesDao;

    @Autowired
    public CategoriesController(CategoriesService categoriesService, CategoriesDao categoriesDao) {
        this.categoriesService = categoriesService;
        this.categoriesDao = categoriesDao;
    }

    @GetMapping()
    public List<Categories> list() {
        return categoriesService.listAll();
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Categories> getCategoryById(@PathVariable UUID id) {
        try {
            Categories categories = categoriesService.get(id);
            return new ResponseEntity<Categories>(categories, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Categories>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public void createNewCategory(@RequestBody Categories categories) {
        categoriesService.save(categories);
    }
}
