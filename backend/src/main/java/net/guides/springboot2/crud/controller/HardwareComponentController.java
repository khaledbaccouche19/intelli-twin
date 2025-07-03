package net.guides.springboot2.crud.controller;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.HardwareComponent;
import net.guides.springboot2.crud.service.HardwareComponentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hardware-components")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class HardwareComponentController {
    private final HardwareComponentService hardwareComponentService;

    @GetMapping
    public ResponseEntity<List<HardwareComponent>> getAllComponents() {
        return ResponseEntity.ok(hardwareComponentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardwareComponent> getComponentById(@PathVariable Long id) {
        return hardwareComponentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tower/{towerId}")
    public ResponseEntity<List<HardwareComponent>> getComponentsByTowerId(@PathVariable Long towerId) {
        return ResponseEntity.ok(hardwareComponentService.findByTowerId(towerId));
    }

    @PostMapping
    public ResponseEntity<HardwareComponent> createComponent(@RequestBody HardwareComponent component) {
        return ResponseEntity.ok(hardwareComponentService.save(component));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardwareComponent> updateComponent(@PathVariable Long id, @RequestBody HardwareComponent component) {
        return hardwareComponentService.findById(id)
                .map(existing -> {
                    component.setId(id);
                    return ResponseEntity.ok(hardwareComponentService.save(component));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComponent(@PathVariable Long id) {
        if (hardwareComponentService.findById(id).isPresent()) {
            hardwareComponentService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 