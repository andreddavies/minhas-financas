package com.davcode.minhasfinancas.service;

import com.davcode.minhasfinancas.exception.BusinessRuleException;
import com.davcode.minhasfinancas.model.entity.User;
import com.davcode.minhasfinancas.model.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserServiceTest {
    @Autowired
    UserService service;
    @Autowired
    UserRepository repository;

    @Test
    public void shouldValidateEmail(){
        repository.deleteAll();

        Assertions.assertThrows(NullPointerException.class, () -> service.validateEmail("user@email.com"));
    }

    @Test
    public void shouldThrowErrorWhenValidatingEmailWhenEmailIsAlreadyRegistered(){
        User user = User.builder().name("André").email("andre@email.com").build();
        repository.save(user);

        Assertions.assertThrows(BusinessRuleException.class,() -> service.validateEmail("andre@email.com"));
    }
}
