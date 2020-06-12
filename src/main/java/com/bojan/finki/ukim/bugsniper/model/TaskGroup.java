package com.bojan.finki.ukim.bugsniper.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@Table(name = "task_groups")
public class TaskGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Description must not be empty")
    private String description;

    @OneToMany(mappedBy = "group")
    private List<User> userList;

}
