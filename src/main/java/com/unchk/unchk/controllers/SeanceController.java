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

import com.unchk.unchk.models.Seance;
import com.unchk.unchk.services.SeanceService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class SeanceController {

    private final SeanceService seanceService;

    @GetMapping("/seances")
    public ResponseEntity<List<Seance>> getAllSeance() {
        return seanceService.getAllEntity();
    }

    @GetMapping("/seance/{id}")
    public ResponseEntity<Optional<Seance>> getSeanceById(@PathVariable String id) {
        return seanceService.getEntityById(id);
    }

    @PostMapping("/seance/add")
    public ResponseEntity<Seance> addSeance(@RequestBody Seance seance) throws Exception {
        return seanceService.addEntity(seance);
    }

    @PostMapping("/seances/add")
    public ResponseEntity<List<Seance>> addSeances(@RequestBody List<Seance> seances) throws Exception {
        return seanceService.addEntities(seances);
    }

    @PutMapping("/seance/update")
    public ResponseEntity<Seance> updSeance(@RequestBody Seance seance) {
        return seanceService.updEntity(seance);
    }

    @DeleteMapping("/seance/delete")
    public ResponseEntity<Seance> delSeance(@RequestBody Seance seance) {
        return seanceService.delEntity(seance);

    }

    @DeleteMapping("/seance/delete/all")
    public ResponseEntity<Seance> delAllSeances(@RequestBody List<Seance> seances) {
        return seanceService.delAllEntity(seances);

    }
}
