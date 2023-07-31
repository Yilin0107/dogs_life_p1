package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {


    private final DogService dogService;

    @Autowired
    public DogController(final DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/getAllDogs")
    public List<Dog> getAllHeroes() {
        return dogService.getAllDogs();
    }

    @GetMapping("/getNoOfDogs")
    public long getNoOfDogs() {
        return dogService.getNoOfDogs();
    }

    @GetMapping("/getDogByName/{dogsName}")
    public ResponseEntity<Dog> getDogByName(@PathVariable String dogsName) {
        Optional<Dog> res = Optional.of((dogService.getDogByName(dogsName)));
        return res.map(dog -> new ResponseEntity<>(dog, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>((Dog) null, HttpStatus.NOT_FOUND));
    }

    @PostMapping("/getDogById")
    public ResponseEntity<Dog> getDogById(@RequestBody long uniqueId) {
        Optional<Dog> res = Optional.of((dogService.getDogById(uniqueId)));
        return res.map(dog -> new ResponseEntity<>(dog, HttpStatus.FOUND)).orElseGet(() -> new ResponseEntity<>((Dog) null, HttpStatus.NOT_FOUND));

    }
}
