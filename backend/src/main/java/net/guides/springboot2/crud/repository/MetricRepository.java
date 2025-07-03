package net.guides.springboot2.crud.repository;

import net.guides.springboot2.crud.entities.Metric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MetricRepository extends JpaRepository<Metric, Long> {
    List<Metric> findByTowerId(Long towerId);
    List<Metric> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
} 