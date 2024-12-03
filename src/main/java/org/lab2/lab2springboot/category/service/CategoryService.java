package org.lab2.lab2springboot.category.service;


import org.lab2.lab2springboot.category.dto.CategoryDto;
import org.lab2.lab2springboot.category.repository.CategoryRepository;
import org.lab2.lab2springboot.category.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> allCategories() {
        return (List<CategoryDto>) categoryRepository.findAll().stream()
                .map(CategoryDto::fromCategory)
                .toList();

    }

    public int addCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.name());
        category.setSymbol(categoryDto.symbol());
        category.setDescription(categoryDto.description());
        category = categoryRepository.save(category);
        return category.getId();
    }

    public CategoryDto getCategoryById(int id) {
        return categoryRepository.findById(id)
                .map(CategoryDto::fromCategory)
                .orElseThrow();
    }
}
