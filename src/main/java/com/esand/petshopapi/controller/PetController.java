package com.esand.petshopapi.controller;

import com.esand.petshopapi.dto.PetCreateDto;
import com.esand.petshopapi.dto.PetResponseDto;
import com.esand.petshopapi.dto.mapper.PetMapper;
import com.esand.petshopapi.entity.Pet;
import com.esand.petshopapi.service.PetService;
import com.esand.petshopapi.service.UserService;
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
    private final UserService userService;

    @PostMapping
    public ResponseEntity<PetResponseDto> create(@RequestBody PetCreateDto dto) {
        Pet pet = PetMapper.toPet(dto);
        pet.setUser(userService.findByCpf(dto.getOwnerCpf()));
        petService.save(pet);

        userService.findByCpf(dto.getOwnerCpf()).addPet(pet);

        return ResponseEntity.status(HttpStatus.CREATED).body(PetMapper.toDto(pet));
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPet() {
        List<Pet> pet = petService.getAll();
        return ResponseEntity.ok(pet);
    }
}
