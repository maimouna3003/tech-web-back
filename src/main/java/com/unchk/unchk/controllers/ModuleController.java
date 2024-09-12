package com.unchk.unchk.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.unchk.unchk.models.Module;
import com.unchk.unchk.services.ModuleService;

@RestController
public class ModuleController {

    ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;

    }

    @GetMapping("/modules")
    public Map<String, Object> getAllModule() {
        return moduleService.getAllEntity();
    }

    @GetMapping("/module/{id}")
    public Map<String, Object> getModuleById(@PathVariable String id) {
        return moduleService.getEntityById(id);
    }

    @PostMapping("/module/add")
    public Map<String, Object> addModule(@RequestBody Module module) throws Exception {
        return moduleService.addEntity(module);
    }

    @PutMapping("/module/update")
    public Map<String, Object> updModule(@RequestBody Module module) {
        return moduleService.updEntity(module);
    }

    @DeleteMapping("/module/delete")
    public Map<String, Object> delModule(@RequestBody Module module) {
        return moduleService.delEntity(module);

    }
}
