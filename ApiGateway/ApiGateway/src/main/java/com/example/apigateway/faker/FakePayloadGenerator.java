package com.example.apigateway.faker;

import com.github.javafaker.Faker;

public class FakePayloadGenerator {

    public static void main(String[] args) {

        Faker faker= new Faker();

        String name= faker.name().fullName();
        String email= faker.internet().emailAddress();

        System.out.println("Name : "+name);
        System.out.println("Email : "+email);


    }
}
