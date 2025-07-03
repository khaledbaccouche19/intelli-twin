package net.guides.springboot2.crud.controller;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.MaintenanceLog;
import net.guides.springboot2.crud.service.MaintenanceLogService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/maintenance-logs")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MaintenanceLogController {
    private final MaintenanceLogService maintenanceLogService;

    @GetMapping
    public ResponseEntity<List<MaintenanceLog>> getAllLogs() {
        return ResponseEntity.ok(maintenanceLogService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceLog> getLogById(@PathVariable Long id) {
        return maintenanceLogService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tower/{towerId}")
    public ResponseEntity<List<MaintenanceLog>> getLogsByTowerId(@PathVariable Long towerId) {
        return ResponseEntity.ok(maintenanceLogService.findByTowerId(towerId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<MaintenanceLog>> getLogsByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(maintenanceLogService.findByDate(date));
    }

    @PostMapping
    public ResponseEntity<MaintenanceLog> createLog(@RequestBody MaintenanceLog log) {
        return ResponseEntity.ok(maintenanceLogService.save(log));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceLog> updateLog(@PathVariable Long id, @RequestBody MaintenanceLog log) {
        return maintenanceLogService.findById(id)
                .map(existing -> {
                    log.setId(id);
                    return ResponseEntity.ok(maintenanceLogService.save(log));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        if (maintenanceLogService.findById(id).isPresent()) {
            maintenanceLogService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 