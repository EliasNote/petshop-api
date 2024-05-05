package com.esand.petshopapi.dto.mapper;

import com.esand.petshopapi.dto.UserResponseDto;
import com.esand.petshopapi.entity.User;
import org.modelmapper.ModelMapper;

public class UserMapper {
    public static UserResponseDto toDto(User user) {
        UserResponseDto dto = new ModelMapper().map(user, UserResponseDto.class);
        return dto;
    }

}
