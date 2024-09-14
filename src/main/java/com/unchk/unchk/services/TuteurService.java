package com.unchk.unchk.services;

import org.springframework.stereotype.Service;

import com.unchk.unchk.models.Tuteur;
import com.unchk.unchk.repository.TuteurRepository;

@Service
public class TuteurService extends GeneriqueService<TuteurRepository, Tuteur> {
    public TuteurService(TuteurRepository repository) {
        super(repository);
    }

}
