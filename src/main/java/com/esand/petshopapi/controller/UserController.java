package com.esand.petshopapi.controller;

import com.esand.petshopapi.client.viacep.ViaCepClient;
import com.esand.petshopapi.dto.UserCreateDto;
import com.esand.petshopapi.dto.UserResponseDto;
import com.esand.petshopapi.dto.mapper.UserMapper;
import com.esand.petshopapi.entity.User;
import com.esand.petshopapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;
    private final ViaCepClient viaCepClient;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserCreateDto dto) {
        User user = UserMapper.toUser(dto);
        user.setEndereco(viaCepClient.getEndereco(dto.getCep()));
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        List<UserResponseDto> user = UserMapper.toListDto(userService.getAll());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UserResponseDto> getByCpf(@PathVariable String cpf) {
        UserResponseDto dto = UserMapper.toDto(userService.findByCpf(cpf));
        return ResponseEntity.ok(dto);
    }
}
