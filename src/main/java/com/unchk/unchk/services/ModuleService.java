package com.unchk.unchk.services;

import org.springframework.stereotype.Service;

import com.unchk.unchk.models.Module;
import com.unchk.unchk.repository.ModuleRepository;

@Service
public class ModuleService extends GeneriqueService<ModuleRepository, Module> {

    public ModuleService(ModuleRepository repository) {
        super(repository);
    }

}
