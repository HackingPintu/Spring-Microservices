package com.example.RatingService.service;

import com.example.RatingService.dto.AddRatingDto;
import com.example.RatingService.entity.Hotel;
import com.example.RatingService.entity.Rating;
import com.example.RatingService.entity.Users;
import com.example.RatingService.repository.RatingRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl  implements  RatingService{

    private final RatingRepository ratingRepository;

    private final RestTemplate restTemplate;

    @Override
    public List<Rating> findAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating findById(Long id) {
        return ratingRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("No rating with id"+id)
        );
    }

    @Override
    public String addRating(AddRatingDto addRatingDto) {

        ratingRepository.save(
                Rating
                        .builder()
                        .rating(addRatingDto.getRating())
                        .feedback(addRatingDto.getFeedback())
                        .hotelId(addRatingDto.getHotelId())
                        .userId(addRatingDto.getUserId())
                        .build()
        );

        return "Success...";
    }

    @Override
    public List<Rating> getHotelByHotelId(Long id) {
        return ratingRepository.findByHotelId(id);

    }

    @Override
    public List<Rating> getUsersByUserId(Long id) {

        System.out.println("CALL>>>");

        return ratingRepository.findByUserId(id);
    }

    @Override
    public String deleteRating(Long id) {

        Rating rating=ratingRepository.findById(id).orElseThrow(null);

        ratingRepository.delete(rating);

        return "Deleted rating with "+id ;
    }


}
