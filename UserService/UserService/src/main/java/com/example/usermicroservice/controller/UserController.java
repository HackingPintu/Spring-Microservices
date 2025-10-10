package com.example.usermicroservice.controller;

import com.example.usermicroservice.dto.AddUserDto;
import com.example.usermicroservice.entity.MS_Users;
import com.example.usermicroservice.service.impl.UserDetailsImpl;
import com.github.javafaker.Faker;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserDetailsImpl userDetails;

    private final Faker faker;

    private Logger logger= LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userDetails.getAllUsers());
    }

    int retryCount=0;

    @GetMapping("/{id}")
//    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "RatingHotelFallback")
//    @Retry(name = "ratingHotelBreaker", fallbackMethod = "RatingHotelFallback")
    @RateLimiter(name="userRateLimiter", fallbackMethod = "RatingHotelFallback")
    public ResponseEntity<?> getUserWithId(@PathVariable("id") Long id){
        logger.info("Retry count : {} ",retryCount);
        retryCount++;
        return ResponseEntity.ok(userDetails.getUserWithId(id));
    }

    public ResponseEntity<?> RatingHotelFallback(Long id, Exception exception){
        logger.info("This service is down due to : {} ",exception.getMessage());
        MS_Users user= MS_Users
                .builder()
                .email(faker.internet().emailAddress())
                .username(faker.name().username())
                .password(faker.internet().password())
                .id(id)
                .build();
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody AddUserDto addUserDto){
        return ResponseEntity.ok(userDetails.addUser(addUserDto));
    }
}
