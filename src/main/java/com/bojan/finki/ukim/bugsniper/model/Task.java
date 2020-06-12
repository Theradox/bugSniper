package com.bojan.finki.ukim.bugsniper.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "The message must not be empty!")
    String message;

    //Category category;
    @NotNull
    @ManyToOne
    private Category category;

    public Task(String message, Category category) {
        this.message = message;
        this.category = category;
    }
//    public
}
