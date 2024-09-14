package com.unchk.unchk.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.Seance;
import com.unchk.unchk.services.SeanceService;

@RestController
public class SeanceController {

    SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;

    }

    @GetMapping("/seances")
    public Map<String, Object> getAllGroupe() {
        return seanceService.getAllEntity();
    }

    @GetMapping("/seance/{id}")
    public Map<String, Object> getGroupeById(@PathVariable String id) {
        return seanceService.getEntityById(id);
    }

    @PostMapping("/seance/add")
    public Map<String, Object> addGroupe(@RequestBody Seance seance) throws Exception {
        return seanceService.addEntity(seance);
    }

    @PutMapping("/seance/update")
    public Map<String, Object> updGroupe(@RequestBody Seance seance) {
        return seanceService.updEntity(seance);
    }

    @DeleteMapping("/seance/delete")
    public Map<String, Object> delGroupe(@RequestBody Seance seance) {
        return seanceService.delEntity(seance);

    }
}
