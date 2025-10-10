package com.example.HotelService.service;

import com.example.HotelService.dto.AddHotel;
import com.example.HotelService.entity.Hotel;
import com.example.HotelService.repository.HotelRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl  implements HotelService{

    private final HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll(Sort.by("hotelName"));
    }

    @Override
    public Hotel getHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("No hotel found with id "+id)
        );
    }


    public String addHotel(AddHotel addHotel){
        hotelRepository.save(
                Hotel
                        .builder()
                        .hotelName(addHotel.getHotelName())
                        .about(addHotel.getAbout())
                        .location(addHotel.getLocation())
                        .build()
        );

        return "Success...";
    }
}
