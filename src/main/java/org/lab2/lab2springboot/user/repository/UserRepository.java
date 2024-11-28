package org.lab2.lab2springboot.user.repository;

import org.lab2.lab2springboot.user.entity.User;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository  extends ListCrudRepository<User, Integer> {

    User findByUsername(String username);
}
