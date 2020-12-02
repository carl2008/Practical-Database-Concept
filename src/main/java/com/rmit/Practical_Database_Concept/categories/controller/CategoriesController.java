package com.rmit.Practical_Database_Concept.categories.controller;

import com.rmit.Practical_Database_Concept.categories.dao.CategoriesDao;
import com.rmit.Practical_Database_Concept.categories.model.Categories;
import com.rmit.Practical_Database_Concept.categories.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    @PostMapping()
//    public String createNewCategories(@RequestBody List<Categories> categories) {
//        categoriesDao.save(categories);
//
//        return "New category has been added";
//    }
}
