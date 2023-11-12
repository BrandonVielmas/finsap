package com.bavt.finsap.presentation.api.v1;

import com.bavt.finsap.application.IUserAccountService;
import com.bavt.finsap.dto.UserAccountDetailsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user-account")
public class UserAccount {

    private final IUserAccountService _userAccountService;

    public UserAccount(IUserAccountService userAccountService) {
        _userAccountService = userAccountService;
    }

    @PostMapping
    public ResponseEntity<UserAccountDetailsDto> insertUserAccount(@RequestBody UserAccountDetailsDto userAccountDetailsDto) {
        return new ResponseEntity<>(_userAccountService.createUserAccount(userAccountDetailsDto), HttpStatus.CREATED);
    }

}
