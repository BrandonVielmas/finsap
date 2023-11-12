package com.bavt.finsap.application;

import com.bavt.finsap.dto.UserDto;

import java.util.List;

public interface IUserService {

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDTO);
    UserDto updateUser(Long id, UserDto userDTO);
    void deleteUser(Long id);

}
