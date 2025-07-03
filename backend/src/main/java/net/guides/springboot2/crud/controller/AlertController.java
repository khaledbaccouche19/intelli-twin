package net.guides.springboot2.crud.controller;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.Alert;
import net.guides.springboot2.crud.service.AlertService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AlertController {
    private final AlertService alertService;

    @GetMapping
    public ResponseEntity<List<Alert>> getAllAlerts() {
        return ResponseEntity.ok(alertService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alert> getAlertById(@PathVariable Long id) {
        return alertService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tower/{towerId}")
    public ResponseEntity<List<Alert>> getAlertsByTowerId(@PathVariable Long towerId) {
        return ResponseEntity.ok(alertService.findByTowerId(towerId));
    }

    @GetMapping("/severity/{severity}")
    public ResponseEntity<List<Alert>> getAlertsBySeverity(@PathVariable String severity) {
        return ResponseEntity.ok(alertService.findBySeverity(severity));
    }

    @GetMapping("/range")
    public ResponseEntity<List<Alert>> getAlertsByTimestampRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(alertService.findByTimestampBetween(start, end));
    }

    @PostMapping
    public ResponseEntity<Alert> createAlert(@RequestBody Alert alert) {
        return ResponseEntity.ok(alertService.save(alert));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alert> updateAlert(@PathVariable Long id, @RequestBody Alert alert) {
        return alertService.findById(id)
                .map(existing -> {
                    alert.setId(id);
                    return ResponseEntity.ok(alertService.save(alert));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        if (alertService.findById(id).isPresent()) {
            alertService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 