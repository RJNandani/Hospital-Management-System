package com.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        System.out.println("Starting Hospital Management System Backend...");
        SpringApplication.run(HospitalApplication.class, args);
        System.out.println("Backend is running! Ready to receive requests.");
    }

}
