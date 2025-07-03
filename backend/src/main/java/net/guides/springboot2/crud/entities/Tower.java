package net.guides.springboot2.crud.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double latitude;
    private Double longitude;
    private LocalDate installationDate;
    private String status;
    private String region;
    private String vendor;
    private String serialNumber;

    @OneToMany(mappedBy = "tower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HardwareComponent> hardwareComponents;

    @OneToMany(mappedBy = "tower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Metric> metrics;

    @OneToMany(mappedBy = "tower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alert> alerts;

    @OneToMany(mappedBy = "tower", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MaintenanceLog> maintenanceLogs;

    public void setId(Long id) {
        this.id = id;
    }
} 