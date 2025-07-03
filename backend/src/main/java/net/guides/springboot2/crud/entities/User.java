package net.guides.springboot2.crud.entities;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;
    private LocalDateTime createdAt;

    public enum Role {
        ADMIN, OPERATOR, VIEWER
    }

    public void setId(Long id) {
        this.id = id;
    }
} 