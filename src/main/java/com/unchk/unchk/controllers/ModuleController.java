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

import com.unchk.unchk.models.Module;
import com.unchk.unchk.services.ModuleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ModuleController {

    private final ModuleService moduleService;

    @GetMapping("/")
    public ResponseEntity<List<Module>> getAllModule() {
        return moduleService.getAllEntity();
    }

    @GetMapping("/module/{id}")
    public ResponseEntity<Optional<Module>> getModuleById(@PathVariable String id) {
        return moduleService.getEntityById(id);
    }

    @PostMapping("/module/add")
    public ResponseEntity<Module> addModule(@RequestBody Module module) throws Exception {
        return moduleService.addEntity(module);
    }

    @PutMapping("/module/update")
    public ResponseEntity<Module> updModule(@RequestBody Module module) {
        return moduleService.updEntity(module);
    }

    @DeleteMapping("/module/delete")
    public ResponseEntity<Module> delModule(@RequestBody Module module) {
        return moduleService.delEntity(module);

    }
}
