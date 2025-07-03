package net.guides.springboot2.crud.service;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.Metric;
import net.guides.springboot2.crud.repository.MetricRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MetricService {
    private final MetricRepository metricRepository;

    public List<Metric> findAll() {
        return metricRepository.findAll();
    }

    public Optional<Metric> findById(Long id) {
        return metricRepository.findById(id);
    }

    public List<Metric> findByTowerId(Long towerId) {
        return metricRepository.findByTowerId(towerId);
    }

    public List<Metric> findByTimestampBetween(LocalDateTime start, LocalDateTime end) {
        return metricRepository.findByTimestampBetween(start, end);
    }

    public Metric save(Metric metric) {
        return metricRepository.save(metric);
    }

    public void deleteById(Long id) {
        metricRepository.deleteById(id);
    }
} 