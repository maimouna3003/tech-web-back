package com.unchk.unchk.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.User;
import com.unchk.unchk.services.UserService;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users")
    public Map<String, Object> getAllGroupe() {
        return userService.getAllEntity();
    }

    @GetMapping("/user/{id}")
    public Map<String, Object> getGroupeById(@PathVariable String id) {
        return userService.getEntityById(id);
    }

    @PostMapping("/user/add")
    public Map<String, Object> addGroupe(@RequestBody User user) throws Exception {
        return userService.addEntity(user);
    }

    @PutMapping("/user/update")
    public Map<String, Object> updGroupe(@RequestBody User user) {
        return userService.updEntity(user);
    }

    @DeleteMapping("/user/delete")
    public Map<String, Object> delGroupe(@RequestBody User user) {
        return userService.delEntity(user);

    }
}
