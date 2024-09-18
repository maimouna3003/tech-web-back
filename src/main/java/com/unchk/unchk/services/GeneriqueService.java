package com.unchk.unchk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import com.unchk.unchk.env.CustomeHelper;
import com.unchk.unchk.models.GlobalModel;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GeneriqueService<T extends JpaRepository<IEntity, String>, IEntity extends GlobalModel> {
    T repository;

    // TODO: Liste des modules
    public ResponseEntity<List<IEntity>> getAllEntity() {
        try {
            List<IEntity> responseData = repository.findAll();
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, CustomeHelper.msgErrorServer500);
        }

    }

    // TODO:Chercher Entity par Id
    public ResponseEntity<Optional<IEntity>> getEntityById(String id) {
        // Rechercher si l'enregistrement exist
        Optional<IEntity> dataSearch = repository.findById(id);
        if (dataSearch.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, CustomeHelper.msgErrorNotFound404);
        // Response
        return new ResponseEntity<>(dataSearch, HttpStatus.OK);

    }

    // TODO: Ajouter une Entity
    public ResponseEntity<IEntity> addEntity(IEntity entity) throws Exception {
        try {
            IEntity recordSave = repository.save(entity);
            return new ResponseEntity<>(recordSave, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, CustomeHelper.msgErrorServer500);
        }
    }

    // TODO: Modifier une Entity
    public ResponseEntity<IEntity> updEntity(IEntity entity) {
        // Rechercher si l'enregistrement exist
        getEntityById(entity.getId());
        try {
            IEntity recordSave = repository.save(entity);
            return new ResponseEntity<>(recordSave, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, CustomeHelper.msgErrorServer500);
        }
    }

    // TODO: Supprimer une Entity
    public ResponseEntity<IEntity> delEntity(IEntity entity) {
        // Rechercher si l'enregistrement exist
        getEntityById(entity.getId());

        try {
            repository.delete(entity);
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, CustomeHelper.msgErrorServer500);
        }

    }

}
