package com.davcode.minhasfinancas.service;

import com.davcode.minhasfinancas.model.entity.User;

public interface IUserService {
    User authenticate(String email, String password);
    User save(User user);
    void validateEmail(String email);
}
