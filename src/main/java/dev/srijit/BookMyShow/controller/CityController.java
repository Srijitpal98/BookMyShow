package dev.srijit.BookMyShow.controller;

import dev.srijit.BookMyShow.dto.CityRequestDTO;
import dev.srijit.BookMyShow.model.City;
import dev.srijit.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName) {
        City savedCity = cityService.getCityByName(cityName);
        return ResponseEntity.ok(savedCity);
    }

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO) {
        try {
            String cityName = cityRequestDTO.getName();
            if(cityName == null || cityName.isBlank()) {
                throw new Exception("City Name is Invalid");
            }
            City savedCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(savedCity);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int cityId) {
        boolean isDeleted = cityService.deleteCity(cityId);
        return ResponseEntity.ok(isDeleted);
    }
}

/*
    Blank -> "   "
    Empty -> ""
 */
