package org.lab2.lab2springboot.category.repository;

import org.lab2.lab2springboot.category.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<Category, Integer> {
}
