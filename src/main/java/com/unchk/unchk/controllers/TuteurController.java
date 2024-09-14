package com.unchk.unchk.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.Tuteur;
import com.unchk.unchk.services.TuteurService;

@RestController
public class TuteurController {

    TuteurService tuteurService;

    public TuteurController(TuteurService tuteurService) {
        this.tuteurService = tuteurService;
    }

    @GetMapping("/tuteurs")
    public Map<String, Object> getAllGroupe() {
        return tuteurService.getAllEntity();
    }

    @GetMapping("/tuteur/{id}")
    public Map<String, Object> getGroupeById(@PathVariable String id) {
        return tuteurService.getEntityById(id);
    }

    @PostMapping("/tuteur/add")
    public Map<String, Object> addGroupe(@RequestBody Tuteur tuteur) throws Exception {
        return tuteurService.addEntity(tuteur);
    }

    @PutMapping("/tuteur/update")
    public Map<String, Object> updGroupe(@RequestBody Tuteur tuteur) {
        return tuteurService.updEntity(tuteur);
    }

    @DeleteMapping("/tuteur/delete")
    public Map<String, Object> delGroupe(@RequestBody Tuteur tuteur) {
        return tuteurService.delEntity(tuteur);

    }
}
