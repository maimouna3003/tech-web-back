package com.unchk.unchk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unchk.unchk.models.UserApp;
import com.unchk.unchk.repository.UserRepository;

@Service
public class UserService extends GeneriqueService<UserRepository, UserApp> {
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository repository) {
        super(repository);
    }

    // TODO: Ajouter un User
    @Override
    public ResponseEntity<UserApp> addEntity(UserApp userApp) throws Exception {
        try {

            userApp.setPassword(passwordEncoder.encode((userApp.getPassword())));
            UserApp recordSave = repository.save(userApp);
            return new ResponseEntity<>(recordSave, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Une erreur c'est produite !");
        }
    }

    // Methode for auth
    public UserApp loadUserByUsername(String email) {
        return repository.findByEmail(email);
    }

}
