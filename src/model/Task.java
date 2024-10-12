package com.todonow.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private boolean completed;

    // Constructors, getters, and setters
}
