package com.unchk.unchk.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.Effectuer;
import com.unchk.unchk.services.EffectuerService;

@RestController
public class EffectuerController {

    EffectuerService effectuerService;

    public EffectuerController(EffectuerService effectuerService) {
        this.effectuerService = effectuerService;

    }

    @GetMapping("/effectues")
    public Map<String, Object> getAllGroupe() {
        return effectuerService.getAllEntity();
    }

    @GetMapping("/effectuer/{id}")
    public Map<String, Object> getGroupeById(@PathVariable String id) {
        return effectuerService.getEntityById(id);
    }

    @PostMapping("/effectuer/add")
    public Map<String, Object> addGroupe(@RequestBody Effectuer effectuer) throws Exception {
        return effectuerService.addEntity(effectuer);
    }

    @PutMapping("/effectuer/update")
    public Map<String, Object> updGroupe(@RequestBody Effectuer effectuer) {
        return effectuerService.updEntity(effectuer);
    }

    @DeleteMapping("/effectuer/delete")
    public Map<String, Object> delGroupe(@RequestBody Effectuer effectuer) {
        return effectuerService.delEntity(effectuer);

    }
}
