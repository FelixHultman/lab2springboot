package org.lab2.lab2springboot.category;

import org.lab2.lab2springboot.category.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<Category, Integer> {
}
