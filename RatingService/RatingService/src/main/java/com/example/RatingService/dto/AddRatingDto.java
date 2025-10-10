package com.example.RatingService.dto;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddRatingDto {

    private Integer rating;

    private String feedback;

    private Long hotelId;

    private Long userId;
}
