package com.example.RatingService.controller;

import com.example.RatingService.dto.AddRatingDto;
import com.example.RatingService.service.RatingServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {

    private final RatingServiceImpl ratingService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(ratingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRatingById(@PathVariable("id") Long id){
        return ResponseEntity.ok(ratingService.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRating(@RequestBody AddRatingDto addRatingDto){
        return ResponseEntity.ok(ratingService.addRating(addRatingDto));
    }

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<?> deleteRating(@PathVariable("id") Long id){
        return ResponseEntity.ok(ratingService.deleteRating(id));
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<?> getHotelWithId(@PathVariable("id") Long id){
        return ResponseEntity.ok(ratingService.getHotelByHotelId(id));
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserWithId(@PathVariable("id") Long id){
        return ResponseEntity.ok(ratingService.getUsersByUserId(id));
    }
}
