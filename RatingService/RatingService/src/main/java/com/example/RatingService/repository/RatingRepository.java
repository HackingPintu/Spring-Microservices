package com.example.RatingService.repository;


import com.example.RatingService.entity.Hotel;
import com.example.RatingService.entity.Rating;
import com.example.RatingService.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository< Rating, Long> {

    List<Rating> findByHotelId(Long id);

    List<Rating> findByUserId(Long id);
}
