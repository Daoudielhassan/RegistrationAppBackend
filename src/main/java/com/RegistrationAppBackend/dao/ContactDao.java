package com.RegistrationAppBackend.dao;

import com.RegistrationAppBackend.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {
    Optional<Contact> getContactById(int id);
    List<Contact> SelectAllContacts();
    void InsertContact(Contact contact);
    void DeleteContactById(int id);
    boolean ExistContactByEmail(String email);

}
