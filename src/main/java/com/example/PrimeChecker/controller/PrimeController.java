package com.example.PrimeChecker.controller;
import com.example.PrimeChecker.service.PrimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PrimeController {
    @Autowired
    private PrimeService service;
    
    @GetMapping("/isprime")
    public ResponseEntity<?> isPrime(@RequestParam(value = "number") String number){
        try{
            int num = Integer.parseInt(number);
            if(num < 0){
                return ResponseEntity.badRequest().body("Please enter a non negative integer.");
            }
            boolean result= service.isPrime(num);
            return ResponseEntity.ok().body(num + " is " + (result ? "a prime number": "not a prime number"));
        }catch(NumberFormatException e){
            return ResponseEntity.badRequest().body("Invalid input integer. please enter a valid integer.");
        }
    }
}
