package com.davcode.minhasfinancas.model.repository;

import com.davcode.minhasfinancas.model.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserRepositoryTest {
    @Autowired
    UserRepository repository;

    @Test
    public void shouldVerifyIfEmailAlreadyExists(){
        User user = User.builder().name("User").email("user@email.com").build();
        repository.save(user);

        boolean result = repository.existsByEmail("user@email.com");

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenDontHaveRegisteredUserWithEmail(){
        repository.deleteAll();
        boolean result = repository.existsByEmail("user@email.com");

        Assertions.assertThat(result).isFalse();
    }
}
