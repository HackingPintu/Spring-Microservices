package com.example.usermicroservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    private Long id;
    private Long hotelId;
    private Long userId;
    private Integer rating;
    private String feedback;

    private Hotel hotel;

}
