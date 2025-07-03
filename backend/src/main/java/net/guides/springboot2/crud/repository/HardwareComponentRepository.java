package net.guides.springboot2.crud.repository;

import net.guides.springboot2.crud.entities.HardwareComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface HardwareComponentRepository extends JpaRepository<HardwareComponent, Long> {
    List<HardwareComponent> findByTowerId(Long towerId);
} 