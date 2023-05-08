package com.davcode.minhasfinancas.model.repository;

import com.davcode.minhasfinancas.model.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    UserRepository repository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void shouldVerifyIfEmailAlreadyExists(){
        User user = User.builder().name("User").email("user@email.com").build();
        entityManager.persist(user);

        boolean result = repository.existsByEmail("user@email.com");

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenDontHaveRegisteredUserWithEmail(){
        boolean result = repository.existsByEmail("user@email.com");

        Assertions.assertThat(result).isFalse();
    }
}
