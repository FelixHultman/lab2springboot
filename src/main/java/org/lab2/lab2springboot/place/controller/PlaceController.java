package org.lab2.lab2springboot.place.controller;

import org.lab2.lab2springboot.place.dto.CreatePlaceDto;
import org.lab2.lab2springboot.place.dto.PlaceDto;
import org.lab2.lab2springboot.place.entity.Place;
import org.lab2.lab2springboot.place.service.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {


    private final PlaceService placeService;


    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }


    //hämta alla publika platser (anonym användare)
    @GetMapping
    public List<PlaceDto> getAllPlaces() {
        return placeService.getAllPublicPlaces();
    }

    //hämta specifik plats (anonym användare)
    @GetMapping("/{id}")
    public PlaceDto getPlace(@PathVariable int id) {
        return placeService.getPlaceById(id);
    }

    //hämta alla platser inom en kategori
    @GetMapping("/category/{categoryId}")
    public List<PlaceDto> getAllPlacesInCategory(@PathVariable int categoryId) {
        return placeService.getAllPlacesInCategory(categoryId);
    }

    //hämta alla platser som tillhör den inloggade användare (både publika och privata)
    @GetMapping("/my-places")
    public List<PlaceDto> getMyPlaces() {
        return placeService.getMyPlaces();
    }

    //skapa en ny plats
    @PostMapping("/add")
    public ResponseEntity<Void> addPlace(@RequestBody CreatePlaceDto createplaceDto) {
        Place place = placeService.createNewPlace(createplaceDto);
        return ResponseEntity.created(URI.create("/places/" + place.getId())).build();

    }

    //hämta alla platser inom en yta
//    @GetMapping("/close-area")
//    public List<PlaceDto> getCloseArea(@RequestParam float lat, @RequestParam float lon, @RequestParam float radius) {
//        return placeService.getCloseArea(lat, lon, radius);
//    }


}
