package com.example.RatingService.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@Getter
@Setter
@AllArgsConstructor
@Table(name="tbl_rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private Long hotelId;

    private Long userId;

    private Integer rating;

    private String feedback;

//    @Transient
//    List<Hotel> hotel= new ArrayList<>();

}
