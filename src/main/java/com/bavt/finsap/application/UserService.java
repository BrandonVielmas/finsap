package com.bavt.finsap.application;

import com.bavt.finsap.dto.UserDto;
import com.bavt.finsap.infrastructure.IUserRepository;
import com.bavt.finsap.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    private final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        var res = _userRepository.getAllUsers();
        List<UserDto> usersDto = new ArrayList<>();
        res.forEach(userEntity -> {
            usersDto.add(UserMapper.toDto(userEntity));
        });
        return usersDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public UserDto createUser(UserDto userDTO) {
        return UserMapper.toDto(_userRepository.createUser(UserMapper.toEntity(userDTO)));
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
