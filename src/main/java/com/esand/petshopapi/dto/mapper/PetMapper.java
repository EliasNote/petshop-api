package com.esand.petshopapi.dto.mapper;

import com.esand.petshopapi.dto.PetCreateDto;
import com.esand.petshopapi.dto.PetResponseDto;
import com.esand.petshopapi.entity.Pet;
import org.modelmapper.ModelMapper;

public class PetMapper {
    public static Pet toPet(PetCreateDto dto) {
        return new ModelMapper().map(dto, Pet.class);
    }

    public static PetResponseDto toDto(Pet pet) {
        PetResponseDto dto = new ModelMapper().map(pet, PetResponseDto.class);
        dto.setOwnerCpf(pet.getUser().getCpf());
        return dto;
    }

}
