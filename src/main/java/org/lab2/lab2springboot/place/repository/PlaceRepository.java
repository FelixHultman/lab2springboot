package org.lab2.lab2springboot.place.repository;

import org.lab2.lab2springboot.place.entity.Place;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.Arrays;
import java.util.List;

public interface PlaceRepository extends ListCrudRepository<Place, Integer> {


    List<Place> findAllByCategory_IdAndIsPrivateFalse(Integer categoryId);

    List<Place> findAllByUserId(String userId);

    @Query(value = "SELECT * FROM place " +
            "WHERE ST_Distance_Sphere(coordinates, ST_GeomFromText(:point, 4326)) <= :radius",
            nativeQuery = true)
    List<Place> findPlaceWithinRadius(@Param("point") String point, @Param("radius") double radius);

    @Query("SELECT p FROM Place p WHERE p.deleted = false")
    List<Place> findAllNonDeleted();
}
