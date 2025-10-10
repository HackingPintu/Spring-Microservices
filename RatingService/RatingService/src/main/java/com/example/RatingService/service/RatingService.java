package com.example.RatingService.service;

import com.example.RatingService.dto.AddRatingDto;
import com.example.RatingService.entity.Hotel;
import com.example.RatingService.entity.Rating;
import com.example.RatingService.entity.Users;

import java.util.List;

public interface RatingService {

    List<Rating> findAll();

    Rating findById(Long id);

    String addRating(AddRatingDto addRatingDto);

    List<Rating>  getHotelByHotelId(Long id);

    List<Rating> getUsersByUserId(Long id);

    String deleteRating(Long id);

}
