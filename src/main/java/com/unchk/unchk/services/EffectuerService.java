package com.unchk.unchk.services;

import org.springframework.stereotype.Service;

import com.unchk.unchk.models.Effectuer;
import com.unchk.unchk.repository.EffectuerRepository;

@Service
public class EffectuerService extends GeneriqueService<EffectuerRepository, Effectuer> {
    public EffectuerService(EffectuerRepository repository) {
        super(repository);
    }

}
