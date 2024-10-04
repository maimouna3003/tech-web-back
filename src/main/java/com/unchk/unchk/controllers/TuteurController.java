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

import com.unchk.unchk.models.Tuteur;
import com.unchk.unchk.services.TuteurService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TuteurController {

    private final TuteurService tuteurService;

    @GetMapping("/tuteurs")
    public ResponseEntity<List<Tuteur>> getAllTuteur() {
        return tuteurService.getAllEntity();
    }

    @GetMapping("/tuteur/{id}")
    public ResponseEntity<Optional<Tuteur>> getTuteurById(@PathVariable String id) {
        return tuteurService.getEntityById(id);
    }

    @PostMapping("/tuteur/add")
    public ResponseEntity<Tuteur> addTuteur(@RequestBody Tuteur tuteur) throws Exception {
        return tuteurService.addEntity(tuteur);
    }

    @PutMapping("/tuteur/update")
    public ResponseEntity<Tuteur> updTuteur(@RequestBody Tuteur tuteur) {
        return tuteurService.updEntity(tuteur);
    }

    @DeleteMapping("/tuteur/delete")
    public ResponseEntity<Tuteur> delTuteur(@RequestBody Tuteur tuteur) {
        return tuteurService.delEntity(tuteur);

    }
}
