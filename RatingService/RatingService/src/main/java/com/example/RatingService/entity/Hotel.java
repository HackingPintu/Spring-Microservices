package com.example.RatingService.entity;

import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private Long id;

    private String hotelName;

    private String about;

    private String location;

}
