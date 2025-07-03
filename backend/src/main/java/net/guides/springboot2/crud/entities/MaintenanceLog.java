package net.guides.springboot2.crud.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaintenanceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String performedBy;
    private LocalDate date;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "tower_id")
    private Tower tower;

    public void setId(Long id) {
        this.id = id;
    }
} 