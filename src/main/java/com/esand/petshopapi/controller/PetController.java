package com.esand.petshopapi.controller;

import com.esand.petshopapi.entity.Pet;
import com.esand.petshopapi.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/pets")
public class PetController {
    private final PetService petService;

    @PostMapping
    public ResponseEntity<Pet> create(@RequestBody Pet pet) {
        petService.save(pet);
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPet() {
        List<Pet> pet = petService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }
}
