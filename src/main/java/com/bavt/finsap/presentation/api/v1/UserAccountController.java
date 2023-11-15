package com.bavt.finsap.presentation.api.v1;

import com.bavt.finsap.application.IUserAccountService;
import com.bavt.finsap.domain.helpers.UserAccountDetailsHelper;
import com.bavt.finsap.dto.UserAccountDetailsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/user-account")
public class UserAccountController {

    private final IUserAccountService _userAccountService;

    public UserAccountController(IUserAccountService userAccountService) {
        _userAccountService = userAccountService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserAccountDetailsHelper> getUserAccount(@PathVariable Integer userId) {
        return new ResponseEntity<>(_userAccountService.getUserAccountById(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserAccountDetailsDto> insertUserAccount(@RequestBody UserAccountDetailsDto userAccountDetailsDto) {
        return new ResponseEntity<>(_userAccountService.createUserAccount(userAccountDetailsDto), HttpStatus.CREATED);
    }

}
