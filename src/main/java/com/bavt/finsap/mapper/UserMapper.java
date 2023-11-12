package com.bavt.finsap.mapper;

import com.bavt.finsap.domain.entity.UserEntity;
import com.bavt.finsap.dto.UserDto;

public class UserMapper {
    public static UserDto toDto(UserEntity userEntity) {
        return new UserDto(userEntity.getId(), userEntity.getName(), userEntity.getLastName(), userEntity.getEmail(), userEntity.getPassword());
    }

    public static UserEntity toEntity(UserDto userDto) {
        return new UserEntity(userDto.getId(), userDto.getName(), userDto.getLastName(), userDto.getEmail(), userDto.getPassword());
    }

}
