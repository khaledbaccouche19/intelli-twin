package net.guides.springboot2.crud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.crud.exception.ResourceNotFoundException;
import net.guides.springboot2.crud.model.IntelliTower;
import net.guides.springboot2.crud.repository.IntelliTowerRepository;

@RestController
@RequestMapping("/api/v1")
public class IntelliTowerController {
	@Autowired
	private IntelliTowerRepository intelliTowerRepository;

	@GetMapping("/towers")
	public List<IntelliTower> getAllTowers() {
		return intelliTowerRepository.findAll();
	}

	@GetMapping("/towers/{id}")
	public ResponseEntity<IntelliTower> getTowerById(@PathVariable(value = "id") Long towerId)
			throws ResourceNotFoundException {
		IntelliTower tower = intelliTowerRepository.findById(towerId)
				.orElseThrow(() -> new ResourceNotFoundException("Tower not found for this id :: " + towerId));
		return ResponseEntity.ok().body(tower);
	}

	@PostMapping("/towers")
	public IntelliTower createTower(@Valid @RequestBody IntelliTower tower) {
		return intelliTowerRepository.save(tower);
	}

	@PutMapping("/towers/{id}")
	public ResponseEntity<IntelliTower> updateTower(@PathVariable(value = "id") Long towerId,
			@Valid @RequestBody IntelliTower towerDetails) throws ResourceNotFoundException {
		IntelliTower tower = intelliTowerRepository.findById(towerId)
				.orElseThrow(() -> new ResourceNotFoundException("Tower not found for this id :: " + towerId));

		tower.setTowerName(towerDetails.getTowerName());
		tower.setLocation(towerDetails.getLocation());
		tower.setStatus(towerDetails.getStatus());
		tower.setHeight(towerDetails.getHeight());
		tower.setDescription(towerDetails.getDescription());
		
		final IntelliTower updatedTower = intelliTowerRepository.save(tower);
		return ResponseEntity.ok(updatedTower);
	}

	@DeleteMapping("/towers/{id}")
	public Map<String, Boolean> deleteTower(@PathVariable(value = "id") Long towerId)
			throws ResourceNotFoundException {
		IntelliTower tower = intelliTowerRepository.findById(towerId)
				.orElseThrow(() -> new ResourceNotFoundException("Tower not found for this id :: " + towerId));

		intelliTowerRepository.delete(tower);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
} 