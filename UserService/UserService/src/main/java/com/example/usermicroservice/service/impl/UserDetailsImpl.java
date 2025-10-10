package com.example.usermicroservice.service.impl;

import com.example.usermicroservice.dto.AddUserDto;
import com.example.usermicroservice.entity.Hotel;
import com.example.usermicroservice.entity.MS_Users;
import com.example.usermicroservice.entity.Rating;
import com.example.usermicroservice.external.service.HotelService;
import com.example.usermicroservice.repository.MS_UsersRepository;
import com.example.usermicroservice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsImpl implements UserService {

    private final MS_UsersRepository msUsersRepository;

    private final RestTemplate restTemplate;

    private final HotelService hotelService;

    @Override
    public List<MS_Users> getAllUsers() {

//        ArrayList<Rating> ratings= restTemplate.getForObject("http://localhost:1802/rating/user/1", ArrayList.class);
//
//        System.out.println(ratings);



        return msUsersRepository.findAll(Sort.by("username"));

    }

    @Override
    @Transactional
    public MS_Users getUserWithId(Long id) {
        MS_Users users= msUsersRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User not found with id" + id)
        );

        Rating[] forObject= restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+id, Rating[].class);

        List<Rating> ratings=Arrays.stream(forObject).toList();

        List<Rating> ratingList= ratings.stream().map(
                rating -> {
//                    ResponseEntity<Hotel> forEntity=restTemplate.getForEntity("http://HOTELSERVICE/hotel/"+rating.getHotelId(), Hotel.class);
                    Hotel hotel=hotelService.getHotel(rating.getHotelId());

                    rating.setHotel(hotel);

                    return rating;
                }
        ).collect(Collectors.toList());

        users.setRatings(ratingList);

//        users.setRatings(ratings);
        return users;
    }

    public String addUser(AddUserDto addUserDto){
        MS_Users user= msUsersRepository.findByUsername(addUserDto.getUsername());

        if(user!=null){
            throw new IllegalArgumentException("User already there...");
        }
        MS_Users msUsers=MS_Users
                .builder()
                .email(addUserDto.getEmail())
                .username(addUserDto.getUsername())
                .password(addUserDto.getPassword())
                .build();
        msUsersRepository.save(msUsers);

        return "Success...";
    }
}
