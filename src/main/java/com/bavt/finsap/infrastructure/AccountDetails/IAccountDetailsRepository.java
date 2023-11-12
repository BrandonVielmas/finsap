package com.bavt.finsap.infrastructure.AccountDetails;

import com.bavt.finsap.domain.entity.AccountDetailsEntity;

public interface IAccountDetailsRepository {

    AccountDetailsEntity createAccountDetails(AccountDetailsEntity accountDetailsEntity);
    AccountDetailsEntity getAccountDetailsById(Integer id);

    AccountDetailsEntity createAccountDetails(Integer id, String userName);
}
