package com.example.usermicroservice.external.service;


import com.example.usermicroservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService {

    @GetMapping("/hotel/{id}")
    Hotel getHotel(@PathVariable Long id);


}
