package com.esand.petshopapi.dto.mapper;

import com.esand.petshopapi.dto.UserCreateDto;
import com.esand.petshopapi.dto.UserResponseDto;
import com.esand.petshopapi.entity.User;
import org.modelmapper.ModelMapper;

import java.util.List;

public class UserMapper {


    public static UserResponseDto toDto(User user) {
        UserResponseDto dto = new ModelMapper().map(user, UserResponseDto.class);
        return dto;
    }

    public static List<UserResponseDto> toListDto(List<User> users) {
        return users.stream().map(x -> UserMapper.toDto(x)).toList();
    }

    public static User toUser(UserCreateDto dto) {
        return new ModelMapper().map(dto, User.class);
    }
}
