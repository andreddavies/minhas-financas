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

import java.util.Optional;

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
        User user = createUser();
        entityManager.persist(user);

        boolean result = repository.existsByEmail("andre@email.com");

        Assertions.assertThat(result).isTrue();
    }

    @Test
    public void shouldReturnFalseWhenDontHaveRegisteredUserWithEmail(){
        boolean result = repository.existsByEmail("andre@email.com");

        Assertions.assertThat(result).isFalse();
    }

    @Test
    public void shouldPersistUserInDatabase(){
        User user = createUser();

        User savedUser = repository.save(user);

        Assertions.assertThat(savedUser.getId()).isNotNull();
    }

    @Test
    public void shouldFindUserByEmail(){
        User user = createUser();
        entityManager.persist(user);

        Optional<User> result = repository.findByEmail("andre@email.com");
        Assertions.assertThat(result.isPresent()).isTrue();
    }

    @Test
    public void shouldReturnEmptyIfEmailDoesntExitsInDatabase(){
        Optional<User> result = repository.findByEmail("andre@email.com");
        Assertions.assertThat(result.isPresent()).isFalse();
    }

    public static User createUser(){
        return User
                .builder()
                .name("André")
                .email("andre@email.com")
                .password("password")
                .build();
    }

}
