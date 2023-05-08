package com.davcode.minhasfinancas.service;

import com.davcode.minhasfinancas.exception.AuthenticationError;
import com.davcode.minhasfinancas.exception.BusinessRuleException;
import com.davcode.minhasfinancas.model.entity.User;
import com.davcode.minhasfinancas.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements IUserService
{
    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository){
        super();
        this.repository = repository;
    }

    @Override
    public User authenticate(String email, String password){
        Optional<User> user = repository.findByEmail(email);

        if(user.isEmpty()){
            throw new AuthenticationError("Usuário não encontrado.");
        }

        if(!user.get().getPassword().equals(password)){
            throw new AuthenticationError("Senha inválida.");
        }

        return user.get();
    }

    @Override
    @Transactional
    public User save(User user){
        validateEmail(user.getEmail());

        return repository.save(user);
    }

    @Override
    public void validateEmail(String email) {
        boolean exists = repository.existsByEmail(email);
        if(exists){
            throw new BusinessRuleException("Já existe um usuário cadastrado com este e-mail.");
        }
    }
}
