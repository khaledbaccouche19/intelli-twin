package net.guides.springboot2.crud.repository;

import net.guides.springboot2.crud.entities.Tower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TowerRepository extends JpaRepository<Tower, Long> {
} 