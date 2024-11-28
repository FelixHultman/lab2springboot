package org.lab2.lab2springboot.category.dto;

import org.lab2.lab2springboot.category.entity.Category;

public record CategoryDto(String name, String symbol, String description) {

    public static CategoryDto fromCategory(Category category) {
        return new CategoryDto(category.getName(), category.getSymbol(), category.getDescription());
    }
}