package com.bavt.finsap.presentation.api.v1;

import com.bavt.finsap.application.IUserService;
import com.bavt.finsap.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private final IUserService _userService;

    public UserController(IUserService userService) {
        _userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(_userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDto> insertUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(_userService.createUser(userDto), HttpStatus.CREATED);
    }

}
