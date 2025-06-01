package io.americanas.legals.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_eventos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="event_id")
    private int enventId;

    @Column(name="title", nullable = false, length = 255)
    private String title;

    @Column(name="pretty_name", nullable = false, length = 50)
    private String prettyName;

    @Column(name="location", nullable = false, length = 255)
    private String location;

    @Column(name="price", nullable = true)
    private double price;

    @Column(name="start_date", nullable = false)
    private LocalDate startDate;

    @Column(name="end_date", nullable = false)
    private LocalDate endDate;

    @Column(name="created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name="updated_at", updatable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
