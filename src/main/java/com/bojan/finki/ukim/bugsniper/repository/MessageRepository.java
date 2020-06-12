package com.bojan.finki.ukim.bugsniper.repository;

import com.bojan.finki.ukim.bugsniper.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
