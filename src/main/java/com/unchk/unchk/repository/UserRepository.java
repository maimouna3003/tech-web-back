package com.unchk.unchk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unchk.unchk.models.User;

public interface UserRepository extends JpaRepository<User, String> {

}
