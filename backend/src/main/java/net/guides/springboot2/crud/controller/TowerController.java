package net.guides.springboot2.crud.controller;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.Tower;
import net.guides.springboot2.crud.service.TowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/towers")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class TowerController {
    private final TowerService towerService;

    @GetMapping
    public ResponseEntity<List<Tower>> getAllTowers() {
        return ResponseEntity.ok(towerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tower> getTowerById(@PathVariable Long id) {
        return towerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tower> createTower(@RequestBody Tower tower) {
        return ResponseEntity.ok(towerService.save(tower));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tower> updateTower(@PathVariable Long id, @RequestBody Tower tower) {
        return towerService.findById(id)
                .map(existing -> {
                    tower.setId(id);
                    return ResponseEntity.ok(towerService.save(tower));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTower(@PathVariable Long id) {
        if (towerService.findById(id).isPresent()) {
            towerService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 