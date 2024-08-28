package com.ayoub.repository;

import com.ayoub.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    public boolean existsByEmail(String email);
}
