package com.bojan.finki.ukim.bugsniper.repository;

import com.bojan.finki.ukim.bugsniper.model.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskGroupRepository extends JpaRepository<TaskGroup, Long> {
}
