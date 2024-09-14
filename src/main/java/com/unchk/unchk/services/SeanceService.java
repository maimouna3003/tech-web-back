package com.unchk.unchk.services;

import org.springframework.stereotype.Service;

import com.unchk.unchk.models.Seance;
import com.unchk.unchk.repository.SeanceRepository;

@Service
public class SeanceService extends GeneriqueService<SeanceRepository, Seance> {
    public SeanceService(SeanceRepository repository) {
        super(repository);
    }

}
