package com.ayoub.service;

import com.ayoub.Exception.DuplicateResourceException;
import com.ayoub.Exception.ResourceNotFound;
import com.ayoub.dao.ContactDao;
import com.ayoub.model.Contact;
import com.ayoub.registrationrequest.ContactRegistrationRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContactService{
    ContactDao contactDao;

    public ContactService(@Qualifier("jpa2") ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    public List<Contact> SelectAllContacts(){
        return contactDao.SelectAllContacts();
    }

    public void AddContact(ContactRegistrationRequest contactRegistrationRequest){
        String email=contactRegistrationRequest.email();
        if (contactDao.ExistContactByEmail(email)){
            throw new DuplicateResourceException("this email is already taken");
        }
        Contact contact = new Contact(contactRegistrationRequest.name(), contactRegistrationRequest.email(), contactRegistrationRequest.message());
        contactDao.InsertContact(contact);
    }

    public Contact FindContactById(Integer id){
        return contactDao.getContactById(id).orElseThrow(() -> new ResourceNotFound(
                "Member with id [%s] not found".formatted(id)));
    }

    public void DeleteContactById(Integer id){
        Contact contact = contactDao.getContactById(id).orElseThrow(() -> new ResourceNotFound("Member with id [%s] not found".formatted(id)));
        contactDao.DeleteContactById(contact.getId());
    }
}
