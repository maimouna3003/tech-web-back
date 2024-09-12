package com.unchk.unchk.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unchk.unchk.models.GlobalModel;

public class GeneriqueService<T extends JpaRepository<IEntity, String>, IEntity extends GlobalModel> {
    T repository;

    public GeneriqueService(T repository) {
        this.repository = repository;
    }

    // TODO: Liste des modules
    public Map<String, Object> getAllEntity() {
        Map<String, Object> responseData = new HashMap<>();

        responseData.put("message", "Liste enregistrements");
        responseData.put("data", repository.findAll());
        return responseData;

    }

    // TODO:Chercher Entity par Id
    public Map<String, Object> getEntityById(String id) {
        Map<String, Object> responseData = new HashMap<>();

        // Rechercher si l'enregistrement exist
        Optional<IEntity> dataSearch = repository.findById(id);
        if (dataSearch.isEmpty()) {
            responseData.put("message", "Ce enregistrement n'existe pas");
            responseData.put("data", null);
            return responseData;
        }

        // Modification de l'enregistrement
        responseData.put("message", "Enregistrement retrouvé");
        responseData.put("data", dataSearch);

        // Response
        return responseData;

    }

    // TODO: Ajouter une Entity
    public Map<String, Object> addEntity(IEntity entity) throws Exception {
        Map<String, Object> responseData = new HashMap<>();

        try {
            // Enregistrement de l'enregistrement
            IEntity recordSave = repository.save(entity);
            responseData.put("message", "Enregistrement enregistré");
            responseData.put("data", recordSave);
        } catch (Exception e) {
            responseData.put("error", e.getMessage());
            responseData.put("data", null);
        }
        return responseData;
    }

    // TODO: Modifier une Entity
    public Map<String, Object> updEntity(IEntity entity) {
        Map<String, Object> responseData = new HashMap<>();

        // Rechercher si l'enregistrement exist
        Map<String, Object> dataResponseSearch = getEntityById(entity.getId());
        if (dataResponseSearch.get("data") == null)
            return dataResponseSearch;

        // Modification de l'enregistrement
        IEntity recordSave = repository.save(entity);
        responseData.put("message", "Enregistrement modifié");
        responseData.put("data", recordSave);

        // Response
        return responseData;

    }

    // TODO: Supprimer une Entity
    public Map<String, Object> delEntity(IEntity entity) {
        Map<String, Object> responseData = new HashMap<>();

        // Rechercher si l'enregistrement exist
        Map<String, Object> dataResponseSearch = getEntityById(entity.getId());
        if (dataResponseSearch.get("data") == null)
            return dataResponseSearch;

        // Suppresssion de l'enregistrement
        repository.delete(entity);
        responseData.put("message", "Enregistrement supprimé");
        responseData.put("data", entity);

        // Response
        return responseData;
    }

}
