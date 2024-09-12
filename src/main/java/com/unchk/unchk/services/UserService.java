package com.unchk.unchk.services;

import org.springframework.stereotype.Service;

import com.unchk.unchk.models.User;
import com.unchk.unchk.repository.UserRepository;

@Service
public class UserService extends GeneriqueService<UserRepository, User> {
    public UserService(UserRepository repository) {
        super(repository);
    }

}
