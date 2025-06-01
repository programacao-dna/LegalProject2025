package io.americanas.legals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name="name", nullable = false, length = 255)
    private String name;

    @Column(name="username", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name="created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updated_at", updatable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
