package com.bavt.finsap.infrastructure.helpers;

import com.bavt.finsap.domain.helpers.UserAccountDetailsHelper;

public interface IUserAccountRepository {

    public UserAccountDetailsHelper getUserAccountById(Integer userId);

}
