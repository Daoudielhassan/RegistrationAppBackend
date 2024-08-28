package com.ayoub.dao;

import com.ayoub.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactDao {
    Optional<Contact> getContactById(int id);
    List<Contact> SelectAllContacts();
    void InsertContact(Contact contact);
    void DeleteContactById(int id);
    boolean ExistContactByEmail(String email);

}
