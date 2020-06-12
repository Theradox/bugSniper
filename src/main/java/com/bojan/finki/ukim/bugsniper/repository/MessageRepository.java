package com.bojan.finki.ukim.bugsniper.repository;

import com.bojan.finki.ukim.bugsniper.model.Category;
import com.bojan.finki.ukim.bugsniper.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findAllByCategory_Id(Long id);
    // ili long Id
}
