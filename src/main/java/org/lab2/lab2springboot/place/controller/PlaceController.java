package org.lab2.lab2springboot.place.controller;

import org.lab2.lab2springboot.place.dto.PlaceDto;
import org.lab2.lab2springboot.place.entity.Place;
import org.lab2.lab2springboot.place.service.PlaceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {


    private final PlaceService placeService;
    PlaceService PlaceService;

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

//    // Hämta alla platser (publika och privata) som tillhör den inloggade användaren
//    @GetMapping("/user")
//    public List<Place> getUserPlaces() {
//        return placeService.getAllPlacesForLoggedInUser();
//    }
//    //hämta alla platser inom en viss yta
//    @GetMapping("/within-radius")
//    public List<Place> getAllPlacesWithinRadius(@RequestParam float lat,
//                                                @RequestParam float lon,
//                                                @RequestParam float radius) {
//        return placeService.getAllPlacesWithinRadius(lat, lon, radius);
//    }
//
//    // skapa en plats (kräver inloggning)
//    @PostMapping()
//    public ResponseEntity<Void> addPlace(@RequestBody PlaceDto placeDto) {
//        Place p = placeService.createNewPlace(placeDto);
//        return ResponseEntity.created(URI.create("/places/" + p.getId())).build();
//    }
//
//    // uppdatera en befintlig plats(kräver inloggning) vilka fält ska uppdateras?
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> updatePlace(@PathVariable int id, @RequestBody PlaceDto placeDto) {
//        placeService.updatePlace(id, placeDto);
//        return ResponseEntity.ok().build();
//    }
//
//    // ta bort befintlig plats (kräver inloggning) soft delete?
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePlace(@PathVariable int id) {
//        placeService.deletePlace(id); // Soft delete, markera platsen som borttagen
//        return ResponseEntity.ok().build();
//    }

}
