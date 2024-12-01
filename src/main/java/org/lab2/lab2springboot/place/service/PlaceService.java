package org.lab2.lab2springboot.place.service;

import jakarta.transaction.Transactional;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.lab2.lab2springboot.category.repository.CategoryRepository;
import org.lab2.lab2springboot.place.dto.CreatePlaceDto;
import org.lab2.lab2springboot.place.dto.PlaceDto;
import org.lab2.lab2springboot.place.dto.UpdatePlaceDto;
import org.lab2.lab2springboot.place.entity.Place;
import org.lab2.lab2springboot.place.repository.PlaceRepository;
import org.springframework.stereotype.Service;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;

    public PlaceService(PlaceRepository placeRepository, CategoryRepository categoryRepository) {
        this.placeRepository = placeRepository;
        this.categoryRepository = categoryRepository;
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
        String userId = "mockUserId"; // Exempelvärde för testning
        return placeRepository.findAllByUserId(userId)
                .stream()
                .map(PlaceDto::fromPlace)
                .toList();
    }

    @Transactional
    public Place createNewPlace(CreatePlaceDto createPlaceDto) {
        if (createPlaceDto.lat() < -90 || createPlaceDto.lat() > 90 || createPlaceDto.lon() < -180 || createPlaceDto.lon() > 180) {
            throw new IllegalArgumentException("Invalid latitude or longitude");
        }
        Place place = new Place();
        place.setName(createPlaceDto.name());
        place.setDescription(createPlaceDto.description());
        place.setIsPrivate(createPlaceDto.is_private());
        place.setCategory(categoryRepository.findById(createPlaceDto.category_id())
                .orElseThrow(() -> new IllegalArgumentException("Category not found")));
        place.setCoordinates(Geometries.mkPoint(new G2D(createPlaceDto.lon(), createPlaceDto.lat()), WGS84));
        place.setUserId("mockUserId");
        place.setCreatedAt(Instant.from(LocalDateTime.now().atZone(ZoneId.systemDefault())));

        return placeRepository.save(place);
    }

    public List<PlaceDto> getCloseArea(float lat, float lon, float radius) {
        String point = String.format("POINT(%f %f)", lon, lat).replace(",", ".");
        return placeRepository.findPlaceWithinRadius(point, (double) radius)
                .stream()
                .map(PlaceDto::fromPlace)
                .toList();
    }

    @Transactional
    public PlaceDto updatePlace(int id, UpdatePlaceDto updatePlaceDto) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Place not found"));

        if (updatePlaceDto.name() != null) {
            place.setName(updatePlaceDto.name());
        }
        if (updatePlaceDto.description() != null) {
            place.setDescription(updatePlaceDto.description());
        }
        if (updatePlaceDto.category_id() != null) {
            place.setCategory(categoryRepository.findById(updatePlaceDto.category_id())
                    .orElseThrow(() -> new IllegalArgumentException("Category not found")));
        }
        if (updatePlaceDto.is_private() != null) {
            place.setIsPrivate(updatePlaceDto.is_private());
        }
        if (updatePlaceDto.lat() != null && updatePlaceDto.lon() != null) {
            validateCoordinates(updatePlaceDto.lat(), updatePlaceDto.lon());
            place.setCoordinates(Geometries.mkPoint(new G2D(updatePlaceDto.lon(), updatePlaceDto.lat()), WGS84));
        }
        placeRepository.save(place);
        return PlaceDto.fromPlace(place);
    }

    @Transactional
    public void deletePlace(int id) {
        Place place = placeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Place not found"));
        place.setDeleted(true);
        placeRepository.save(place);
    }

    private void validateCoordinates(float lat, float lon) {
        if (lat < -90 || lat > 90 || lon < -180 || lon > 180) {
            throw new IllegalArgumentException("Invalid latitude or longitude");
        }
    }
}

