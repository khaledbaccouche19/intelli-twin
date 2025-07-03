package net.guides.springboot2.crud.repository;

import net.guides.springboot2.crud.entities.MaintenanceLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MaintenanceLogRepository extends JpaRepository<MaintenanceLog, Long> {
    List<MaintenanceLog> findByTowerId(Long towerId);
    List<MaintenanceLog> findByDate(LocalDate date);
} 