package com.example.usermicroservice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="tbl_ms_users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MS_Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String email;
    @Column(unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Transient
    private List<Rating> ratings= new ArrayList<Rating>();

}
