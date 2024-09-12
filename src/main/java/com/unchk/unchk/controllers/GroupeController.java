package com.unchk.unchk.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.Groupe;
import com.unchk.unchk.services.GroupeService;

@RestController
public class GroupeController {

    GroupeService groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;

    }

    @GetMapping("/groupes")
    public Map<String, Object> getAllGroupe() {
        return groupeService.getAllEntity();
    }

    @GetMapping("/groupe/{id}")
    public Map<String, Object> getGroupeById(@PathVariable String id) {
        return groupeService.getEntityById(id);
    }

    @PostMapping("/groupe/add")
    public Map<String, Object> addGroupe(@RequestBody Groupe groupe) throws Exception {
        return groupeService.addEntity(groupe);
    }

    @PutMapping("/groupe/update")
    public Map<String, Object> updGroupe(@RequestBody Groupe groupe) {
        return groupeService.updEntity(groupe);
    }

    @DeleteMapping("/groupe/delete")
    public Map<String, Object> delGroupe(@RequestBody Groupe groupe) {
        return groupeService.delEntity(groupe);

    }
}
