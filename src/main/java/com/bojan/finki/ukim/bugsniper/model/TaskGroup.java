package com.bojan.finki.ukim.bugsniper.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "task_groups")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
