package com.bavt.finsap.application;

import com.bavt.finsap.domain.entity.AccountDetailsEntity;
import com.bavt.finsap.domain.entity.UserEntity;
import com.bavt.finsap.domain.helpers.UserAccountDetailsHelper;
import com.bavt.finsap.dto.UserAccountDetailsDto;
import com.bavt.finsap.dto.UserDto;
import com.bavt.finsap.infrastructure.AccountDetails.IAccountDetailsRepository;
import com.bavt.finsap.infrastructure.User.IUserRepository;
import com.bavt.finsap.infrastructure.helpers.IUserAccountRepository;
import com.bavt.finsap.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService implements IUserAccountService {

    private final IUserRepository _userRepository;
    private final IAccountDetailsRepository _accountDetailsRepository;
    private final IUserAccountRepository _userAccountRepository;

    public UserAccountService(IUserRepository userRepository, IAccountDetailsRepository accountDetailsRepository, IUserAccountRepository userAccountRepository) {
        _userRepository = userRepository;
        _accountDetailsRepository = accountDetailsRepository;
        _userAccountRepository = userAccountRepository;
    }

    @Override
    public UserAccountDetailsDto createUserAccount(UserAccountDetailsDto userAccountDetailsDto) {

        UserAccountDetailsDto newUserAccountDetailsDto = new UserAccountDetailsDto();
        //tenemos que crear un usuario y una account details

        //name, lastName, email, password (lo que pide el repository de user)
        UserEntity newUserEntity = new UserEntity();
        newUserEntity.setName(userAccountDetailsDto.getName());
        newUserEntity.setLastName(userAccountDetailsDto.getLastName());
        newUserEntity.setEmail(userAccountDetailsDto.getEmail());
        newUserEntity.setPassword(userAccountDetailsDto.getPassword());

        UserDto newUserDto = new UserDto();
        newUserDto = UserMapper.toDto(_userRepository.createUser(newUserEntity)); //se crea user

        AccountDetailsEntity newAccountDetailsEntity = new AccountDetailsEntity();
        //pide userId y userName
        //Creamos accountdetails
        newAccountDetailsEntity = _accountDetailsRepository.createAccountDetails(newUserDto.getId(), userAccountDetailsDto.getUserName());

        //estos dos train lo nuevo
        //newUserDto
        //newAccountDetailsEntity
        newUserAccountDetailsDto.setUserId(newUserDto.getId());
        newUserAccountDetailsDto.setName(newUserDto.getName());
        newUserAccountDetailsDto.setLastName(newUserDto.getLastName());
        newUserAccountDetailsDto.setUserName(newAccountDetailsEntity.getUserName());
        newUserAccountDetailsDto.setEmail(newUserDto.getEmail());
        newUserAccountDetailsDto.setPassword("");
        newUserAccountDetailsDto.setAccountBalance(newAccountDetailsEntity.getAccountBalance());
        newUserAccountDetailsDto.setCreateDate(newAccountDetailsEntity.getCreateDate());
        newUserAccountDetailsDto.setUpdateDate(newAccountDetailsEntity.getUpdateDate());

        return newUserAccountDetailsDto;
    }

    @Override
    public UserAccountDetailsHelper getUserAccountById(Integer userId) {
        return _userAccountRepository.getUserAccountById(userId);
    }
}














