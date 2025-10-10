package com.example.HotelService.service;


import com.example.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getAllHotels();

    Hotel getHotelById(Long id);




}
