package com.unchk.unchk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unchk.unchk.models.Module;

public interface ModuleRepository extends JpaRepository<Module, String> {

}
