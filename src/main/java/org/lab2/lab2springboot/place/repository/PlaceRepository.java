package org.lab2.lab2springboot.place.repository;

import org.lab2.lab2springboot.place.entity.Place;
import org.springframework.data.repository.ListCrudRepository;

public interface PlaceRepository extends ListCrudRepository<Place, Integer> {
}
