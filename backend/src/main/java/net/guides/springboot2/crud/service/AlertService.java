package net.guides.springboot2.crud.service;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.Alert;
import net.guides.springboot2.crud.repository.AlertRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlertService {
    private final AlertRepository alertRepository;

    public List<Alert> findAll() {
        return alertRepository.findAll();
    }

    public Optional<Alert> findById(Long id) {
        return alertRepository.findById(id);
    }

    public List<Alert> findByTowerId(Long towerId) {
        return alertRepository.findByTowerId(towerId);
    }

    public List<Alert> findBySeverity(String severity) {
        return alertRepository.findBySeverity(severity);
    }

    public List<Alert> findByTimestampBetween(LocalDateTime start, LocalDateTime end) {
        return alertRepository.findByTimestampBetween(start, end);
    }

    public Alert save(Alert alert) {
        return alertRepository.save(alert);
    }

    public void deleteById(Long id) {
        alertRepository.deleteById(id);
    }
} 