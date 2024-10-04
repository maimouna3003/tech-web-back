package com.unchk.unchk.services;

import org.springframework.stereotype.Service;

import com.unchk.unchk.models.Groupe;
import com.unchk.unchk.repository.GroupeRepository;

@Service
public class GroupeService extends GeneriqueService<GroupeRepository, Groupe> {
    public GroupeService(GroupeRepository repository) {
        super(repository);
    }

}