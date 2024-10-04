package com.unchk.unchk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unchk.unchk.models.UserApp;

public interface UserRepository extends JpaRepository<UserApp, String> {

    UserApp findByEmail(String email);

}
