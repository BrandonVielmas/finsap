package com.bavt.finsap.infrastructure.conf;

import com.bavt.finsap.application.service.DomainUserService;
import com.bavt.finsap.application.service.IUserService;
import com.bavt.finsap.domain.puerto.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanUserConfiguration {

    @Bean
    IUserService userBeanService(final IUserRepository userRepository) {
        return new DomainUserService(userRepository);
    }

}
