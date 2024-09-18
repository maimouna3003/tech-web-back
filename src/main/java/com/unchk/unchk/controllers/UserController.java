package com.unchk.unchk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.UserApp;
import com.unchk.unchk.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserApp>> getAllUser() {
        return userService.getAllEntity();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<UserApp>> getUserById(@PathVariable String id) {
        return userService.getEntityById(id);
    }

    @PostMapping("/user/add")
    public ResponseEntity<UserApp> addUser(@RequestBody UserApp user) throws Exception {
        return userService.addEntity(user);
    }

    @PutMapping("/user/update")
    public ResponseEntity<UserApp> updUser(@RequestBody UserApp user) {
        return userService.updEntity(user);
    }

    @DeleteMapping("/user/delete")
    public ResponseEntity<UserApp> delUser(@RequestBody UserApp user) {
        return userService.delEntity(user);

    }
}
