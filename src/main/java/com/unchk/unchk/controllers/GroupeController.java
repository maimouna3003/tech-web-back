package com.unchk.unchk.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.Groupe;
import com.unchk.unchk.services.GroupeService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class GroupeController {

    private final GroupeService groupeService;

    @GetMapping("/groupes")
    public ResponseEntity<List<Groupe>> getAllGroupe() {
        return groupeService.getAllEntity();
    }

    @GetMapping("/groupe/{id}")
    public ResponseEntity<Optional<Groupe>> getGroupeById(@PathVariable String id) {
        return groupeService.getEntityById(id);
    }

    @PostMapping("/groupe/add")
    public ResponseEntity<Groupe> addGroupe(@RequestBody Groupe groupe) throws Exception {
        return groupeService.addEntity(groupe);
    }

    @PostMapping("/groupes/add")
    public ResponseEntity<List<Groupe>> addGroupes(@RequestBody List<Groupe> groupes) throws Exception {
        return groupeService.addEntities(groupes);
    }

    @PutMapping("/groupe/update")
    public ResponseEntity<Groupe> updGroupe(@RequestBody Groupe groupe) {
        return groupeService.updEntity(groupe);
    }

    @DeleteMapping("/groupe/delete")
    public ResponseEntity<Groupe> delGroupe(@RequestBody Groupe groupe) {
        return groupeService.delEntity(groupe);

    }

    @DeleteMapping("/groupe/delete/all")
    public ResponseEntity<Groupe> delGroupes(@RequestBody List<Groupe> groupes) {
        return groupeService.delAllEntity(groupes);

    }
}
