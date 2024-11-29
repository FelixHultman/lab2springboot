package org.lab2.lab2springboot.place.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
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

        String userId = "mockUserId"; // Exempelvärde för utveckling och testning
        return placeRepository.findAllByUserId(userId)
                .stream()
                .map(PlaceDto::fromPlace)
                .toList();
    }
}

//    public List<PlaceDto> getCloseArea(float lat, float lon, float radius) {
//        return placeRepository.findAll().stream()
//                .filter(place -> !place.getIsPrivate())
//                .filter(place -> Math.sqrt(Math.pow(place.getLat() - lat, 2) + Math.pow(place.getLon() - lon, 2)) <= radius)
//                .map(PlaceDto::fromPlace)
//                .toList();
//    }

