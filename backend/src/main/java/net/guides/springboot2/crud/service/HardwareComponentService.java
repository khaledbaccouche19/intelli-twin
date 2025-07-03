package net.guides.springboot2.crud.service;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.HardwareComponent;
import net.guides.springboot2.crud.repository.HardwareComponentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HardwareComponentService {
    private final HardwareComponentRepository hardwareComponentRepository;

    public List<HardwareComponent> findAll() {
        return hardwareComponentRepository.findAll();
    }

    public Optional<HardwareComponent> findById(Long id) {
        return hardwareComponentRepository.findById(id);
    }

    public List<HardwareComponent> findByTowerId(Long towerId) {
        return hardwareComponentRepository.findByTowerId(towerId);
    }

    public HardwareComponent save(HardwareComponent component) {
        return hardwareComponentRepository.save(component);
    }

    public void deleteById(Long id) {
        hardwareComponentRepository.deleteById(id);
    }
} 