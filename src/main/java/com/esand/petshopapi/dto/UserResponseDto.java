package com.esand.petshopapi.dto;

import com.esand.petshopapi.client.viacep.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String name;
    private String cpf;
    private String contact;
    private Endereco endereco;
    private List<PetResponseDto> petList;
}
