package org.lab2.lab2springboot.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    CategoryService kategoriService;

    public CategoryController(CategoryService kategoriService) {
        this.kategoriService = kategoriService;
    }


    @GetMapping("/persons")
    public List<Person> getAllPersons() {
       return kategoriService.allCategories();
    }
}
