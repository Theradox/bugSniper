package com.bojan.finki.ukim.bugsniper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    List<Task> taskList;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    List<Message> messages;

}
