package com.bojan.finki.ukim.bugsniper.repository;

import com.bojan.finki.ukim.bugsniper.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
