package com.example.usermicroservice.repository;

import com.example.usermicroservice.entity.MS_Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MS_UsersRepository extends JpaRepository<MS_Users, Long> {
    MS_Users findByUsername(String username);
}