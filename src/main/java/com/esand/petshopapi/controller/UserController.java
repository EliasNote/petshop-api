package com.esand.petshopapi.controller;

import com.esand.petshopapi.dto.UserResponseDto;
import com.esand.petshopapi.dto.mapper.UserMapper;
import com.esand.petshopapi.entity.User;
import com.esand.petshopapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User User) {
        userService.save(User);
        return ResponseEntity.status(HttpStatus.CREATED).body(User);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> user = userService.getAll();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UserResponseDto> getByCpf(@PathVariable String cpf) {
        UserResponseDto dto = UserMapper.toDto(userService.findByCpf(cpf));
        return ResponseEntity.ok(dto);
    }
}
