package com.esand.petshopapi.service;

import com.esand.petshopapi.entity.User;
import com.esand.petshopapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByCpf(String cpf) {
        return userRepository.findByCpf(cpf).orElseThrow(() -> new RuntimeException("Cpf não encontrado"));
    }
}
