package com.esand.petshopapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor()
@NoArgsConstructor
@Setter
@Getter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PetResponseDto {
    private String name;
    private String breed;
    private String ownerCpf;
}
