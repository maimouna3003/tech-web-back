package com.unchk.unchk.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.Effectuer;
import com.unchk.unchk.services.EffectuerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class EffectuerController {

    private final EffectuerService effectuerService;

    @GetMapping("/effectues")
    public ResponseEntity<List<Effectuer>> getAllEffectuer() {
        return effectuerService.getAllEntity();
    }

    @GetMapping("/effectuer/{id}")
    public ResponseEntity<Optional<Effectuer>> getEffectuerById(@PathVariable String id) {
        return effectuerService.getEntityById(id);
    }

    @PostMapping("/effectuer/add")
    public ResponseEntity<Effectuer> addEffectuer(@RequestBody Effectuer effectuer) throws Exception {
        return effectuerService.addEntity(effectuer);
    }

    @PutMapping("/effectuer/update")
    public ResponseEntity<Effectuer> updEffectuer(@RequestBody Effectuer effectuer) {
        return effectuerService.updEntity(effectuer);
    }

    @DeleteMapping("/effectuer/delete")
    public ResponseEntity<Effectuer> delEffectuer(@RequestBody Effectuer effectuer) {
        return effectuerService.delEntity(effectuer);

    }
}
