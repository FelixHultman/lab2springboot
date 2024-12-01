package org.lab2.lab2springboot.place.dto;

public record UpdatePlaceDto(String name, String description, Integer category_id, Boolean is_private, Float lat,
                             Float lon) {
}
