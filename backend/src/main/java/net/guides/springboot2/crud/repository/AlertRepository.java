package net.guides.springboot2.crud.repository;

import net.guides.springboot2.crud.entities.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByTowerId(Long towerId);
    List<Alert> findBySeverity(String severity);
    List<Alert> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
} 