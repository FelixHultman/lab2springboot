package org.lab2.lab2springboot.place.dto;

import org.lab2.lab2springboot.place.entity.Place;

public record PlaceDto(String name, String description, Integer category_id, Boolean is_private) {

    public static PlaceDto fromPlace(Place place) {
        return new PlaceDto(place.getName(),
                place.getDescription(),
                place.getCategory().getId(),
                place.getIsPrivate());
    }
}
