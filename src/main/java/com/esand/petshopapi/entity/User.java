package com.esand.petshopapi.entity;

import com.esand.petshopapi.client.viacep.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "contact", nullable = false, length = 11)
    private String contact;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "user")
    private List<Pet> petList;

    public void addPet(Pet pet) {
        petList.add(pet);
    }
}
