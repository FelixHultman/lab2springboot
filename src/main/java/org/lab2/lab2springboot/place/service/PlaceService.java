package org.lab2.lab2springboot.place.service;

import org.lab2.lab2springboot.place.dto.PlaceDto;
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
        return placeRepository.findAll().stream()
                .filter(place -> !place.getIsPrivate())
                .map(PlaceDto::fromPlace)
                .toList();
    }


    public PlaceDto getPlaceById(int id) {
        return PlaceDto.fromPlace(placeRepository.findById(id)
                .filter(place -> !place.getIsPrivate())
                .orElseThrow());
    }


    public List<PlaceDto> getAllPlacesInCategory(int categoryId) {
        return placeRepository.findAllByCategory_IdAndIsPrivateFalse(categoryId)
                .stream()
                .map(PlaceDto::fromPlace)
                .toList();
    }

    public List<PlaceDto> getMyPlaces() {
        return placeRepository.findAllByUser_Id(107)
                .stream()
                .map(PlaceDto::fromPlace)
                .toList();
    }
}
