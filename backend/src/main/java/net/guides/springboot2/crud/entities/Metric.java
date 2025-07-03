package net.guides.springboot2.crud.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metricType;
    private String value;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "tower_id")
    private Tower tower;

    public void setId(Long id) {
        this.id = id;
    }
} 