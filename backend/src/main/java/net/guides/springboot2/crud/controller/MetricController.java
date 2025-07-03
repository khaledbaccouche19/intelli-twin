package net.guides.springboot2.crud.controller;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.Metric;
import net.guides.springboot2.crud.service.MetricService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/metrics")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class MetricController {
    private final MetricService metricService;

    @GetMapping
    public ResponseEntity<List<Metric>> getAllMetrics() {
        return ResponseEntity.ok(metricService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Metric> getMetricById(@PathVariable Long id) {
        return metricService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tower/{towerId}")
    public ResponseEntity<List<Metric>> getMetricsByTowerId(@PathVariable Long towerId) {
        return ResponseEntity.ok(metricService.findByTowerId(towerId));
    }

    @GetMapping("/range")
    public ResponseEntity<List<Metric>> getMetricsByTimestampRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(metricService.findByTimestampBetween(start, end));
    }

    @PostMapping
    public ResponseEntity<Metric> createMetric(@RequestBody Metric metric) {
        return ResponseEntity.ok(metricService.save(metric));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Metric> updateMetric(@PathVariable Long id, @RequestBody Metric metric) {
        return metricService.findById(id)
                .map(existing -> {
                    metric.setId(id);
                    return ResponseEntity.ok(metricService.save(metric));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetric(@PathVariable Long id) {
        if (metricService.findById(id).isPresent()) {
            metricService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 