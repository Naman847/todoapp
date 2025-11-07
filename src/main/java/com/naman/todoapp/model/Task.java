package com.naman.todoapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="task_tbl")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private boolean completed;
}
