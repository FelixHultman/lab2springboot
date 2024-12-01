package org.lab2.lab2springboot.category.controller;

import jakarta.validation.Valid;
import org.lab2.lab2springboot.category.dto.CategoryDto;
import org.lab2.lab2springboot.category.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }


    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories() {
        return categoryService.allCategories();
    }

    @PostMapping("/categories")
    public ResponseEntity<String> addCategory(@Valid @RequestBody CategoryDto categoryDto) {
        int id = categoryService.addCategory(categoryDto);
        return ResponseEntity.created(URI.create(("/categories/" + id))).build();
    }
}
