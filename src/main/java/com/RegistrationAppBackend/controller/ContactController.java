package com.RegistrationAppBackend.controller;

import com.RegistrationAppBackend.model.Contact;
import com.RegistrationAppBackend.registrationrequest.ContactRegistrationRequest;
import com.RegistrationAppBackend.repository.ContactRepository;
import com.RegistrationAppBackend.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api2")
public class ContactController {
    ContactService contactService;
    ContactRepository contactRepository;

    public ContactController(ContactService contactService, ContactRepository contactRepository) {
        this.contactService = contactService;
        this.contactRepository = contactRepository;
    }
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.SelectAllContacts();
    }
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable int id) {
        return contactService.FindContactById(id);
    }
    @DeleteMapping("/{id}")
    public void DeleteContactById(int id) {
        contactService.DeleteContactById(id);
    }
    @PostMapping
    public void addContact(@RequestBody ContactRegistrationRequest contactRegistrationRequest) {
        contactService.AddContact(contactRegistrationRequest);
    }
}
