package com.unchk.unchk.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unchk.unchk.env.CustomeHelper;
import com.unchk.unchk.models.Effectuer;
import com.unchk.unchk.models.Groupe;
import com.unchk.unchk.repository.EffectuerRepository;

@Service
public class EffectuerService extends GeneriqueService<EffectuerRepository, Effectuer> {
    public EffectuerService(EffectuerRepository repository) {
        super(repository);
    }

    // TODO: Liste des effectuer par groupe
    public ResponseEntity<List<Effectuer>> getEffectuesByGroupe(Groupe groupe) {
        try {
            List<Effectuer> responseData = repository.findByGroupe(groupe);
            if (responseData.isEmpty())
                return new ResponseEntity<>(responseData, HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, CustomeHelper.msgErrorServer500);
        }

    }
}
