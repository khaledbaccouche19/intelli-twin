package net.guides.springboot2.crud.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HardwareComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String model;
    private String serialNumber;
    private String firmwareVersion;
    private LocalDate installationDate;
    private LocalDate warrantyExpiry;

    @ManyToOne
    @JoinColumn(name = "tower_id")
    private Tower tower;

    public void setId(Long id) {
        this.id = id;
    }
} 