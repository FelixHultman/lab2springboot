package org.lab2.lab2springboot.category;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryService categoryService;
    CategoryService CategoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/categories")
    public List<CategoryDto> getAllCategories() {
       return categoryService.allCategories();
    }

    @PostMapping("/categories")
    public ResponseEntity<String> addCategory(@Valid @RequestBody CategoryDto categoryDto) {
        categoryService.addCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category added successfully!");
    }
}
