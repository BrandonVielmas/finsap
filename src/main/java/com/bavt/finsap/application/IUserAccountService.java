package com.bavt.finsap.application;

import com.bavt.finsap.domain.helpers.UserAccountDetailsHelper;
import com.bavt.finsap.dto.UserAccountDetailsDto;

public interface IUserAccountService {

    UserAccountDetailsDto createUserAccount(UserAccountDetailsDto userAccountDetailsDto);
    UserAccountDetailsHelper getUserAccountById(Integer userId);

}
