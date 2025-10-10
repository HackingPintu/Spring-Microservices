package com.example.HotelService.controller;

import com.example.HotelService.dto.AddHotel;
import com.example.HotelService.service.HotelServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelServiceImpl hotelService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getHotelById(@PathVariable("id") Long id){
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addHotel(@RequestBody AddHotel addHotel){
        return ResponseEntity.ok(hotelService.addHotel(addHotel));
    }


}
