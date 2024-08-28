package com.RegistrationAppBackend.repository;

import com.RegistrationAppBackend.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    public boolean existsByEmail(String email);
}
