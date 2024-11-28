package org.lab2.lab2springboot.place.repository;

import org.lab2.lab2springboot.place.entity.Place;
import org.springframework.data.repository.ListCrudRepository;


import java.util.List;

public interface PlaceRepository extends ListCrudRepository<Place, Integer> {


    List<Place> findAllByCategory_IdAndIsPrivateFalse(Integer categoryId);

}
