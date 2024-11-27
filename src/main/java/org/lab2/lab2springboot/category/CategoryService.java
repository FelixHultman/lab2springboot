package org.lab2.lab2springboot.category;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {


    public List<Person> allCategories() {
        return List.of(
                new Person("Kalle", true),
                new Person("Adolf", false)
        );
    }
}
