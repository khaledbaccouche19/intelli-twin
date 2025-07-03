package net.guides.springboot2.crud.service;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.MaintenanceLog;
import net.guides.springboot2.crud.repository.MaintenanceLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaintenanceLogService {
    private final MaintenanceLogRepository maintenanceLogRepository;

    public List<MaintenanceLog> findAll() {
        return maintenanceLogRepository.findAll();
    }

    public Optional<MaintenanceLog> findById(Long id) {
        return maintenanceLogRepository.findById(id);
    }

    public List<MaintenanceLog> findByTowerId(Long towerId) {
        return maintenanceLogRepository.findByTowerId(towerId);
    }

    public List<MaintenanceLog> findByDate(LocalDate date) {
        return maintenanceLogRepository.findByDate(date);
    }

    public MaintenanceLog save(MaintenanceLog log) {
        return maintenanceLogRepository.save(log);
    }

    public void deleteById(Long id) {
        maintenanceLogRepository.deleteById(id);
    }
} 