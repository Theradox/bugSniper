package com.bojan.finki.ukim.bugsniper.repository;

import com.bojan.finki.ukim.bugsniper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
