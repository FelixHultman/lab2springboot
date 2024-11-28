package org.lab2.lab2springboot.place.service;

import org.lab2.lab2springboot.category.dto.CategoryDto;
import org.lab2.lab2springboot.place.dto.PlaceDto;
import org.lab2.lab2springboot.place.entity.Place;
import org.lab2.lab2springboot.place.repository.PlaceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<PlaceDto> getAllPublicPlaces() {
        return (List<PlaceDto>) placeRepository.findAll().stream()
                .map(PlaceDto::fromPlace)
                .toList();
    }


}
