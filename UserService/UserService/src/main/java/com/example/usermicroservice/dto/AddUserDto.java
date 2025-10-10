package com.example.usermicroservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddUserDto {

    private String username;
    private String password;
    private String email;
}
