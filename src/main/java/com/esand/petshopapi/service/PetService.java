package com.esand.petshopapi.service;

import com.esand.petshopapi.entity.Pet;
import com.esand.petshopapi.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PetService {
    private final PetRepository petRepository;

    @Transactional
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @Transactional(readOnly = true)
    public List<Pet> getAll() {
        return petRepository.findAll();
    }
}
