package com.example.HotelService.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddHotel {

    private String hotelName;
    private String location;
    private String about;

}
