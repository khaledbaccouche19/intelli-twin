package net.guides.springboot2.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "intelli_towers")
public class IntelliTower {

    private long id;
    private String towerName;
    private String location;
    private String status;
    private Double height;
    private String description;
    
    public IntelliTower() {
        
    }
    
    public IntelliTower(String towerName, String location, String status, Double height, String description) {
        this.towerName = towerName;
        this.location = location;
        this.status = status;
        this.height = height;
        this.description = description;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name = "tower_name", nullable = false)
    @NotBlank(message = "Tower name is required")
    public String getTowerName() {
        return towerName;
    }
    public void setTowerName(String towerName) {
        this.towerName = towerName;
    }
    
    @Column(name = "location", nullable = false)
    @NotBlank(message = "Location is required")
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    
    @Column(name = "status", nullable = false)
    @NotBlank(message = "Status is required")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name = "height")
    @NotNull(message = "Height is required")
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    
    @Column(name = "description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "IntelliTower [id=" + id + ", towerName=" + towerName + ", location=" + location + 
               ", status=" + status + ", height=" + height + ", description=" + description + "]";
    }
} 