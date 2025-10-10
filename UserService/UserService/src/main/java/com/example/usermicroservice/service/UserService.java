package com.example.usermicroservice.service;

import com.example.usermicroservice.entity.MS_Users;

import java.util.List;
import java.util.Optional;

public interface UserService {

     List<MS_Users> getAllUsers();

     MS_Users getUserWithId(Long id);





}
