package com.ethnocopia;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class Main {
    public static  void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }








}
