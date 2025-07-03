package net.guides.springboot2.crud.service;

import lombok.RequiredArgsConstructor;
import net.guides.springboot2.crud.entities.Tower;
import net.guides.springboot2.crud.repository.TowerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TowerService {
    private final TowerRepository towerRepository;

    public List<Tower> findAll() {
        return towerRepository.findAll();
    }

    public Optional<Tower> findById(Long id) {
        return towerRepository.findById(id);
    }

    public Tower save(Tower tower) {
        return towerRepository.save(tower);
    }

    public void deleteById(Long id) {
        towerRepository.deleteById(id);
    }
} 