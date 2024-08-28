package com.RegistrationAppBackend.service;

import com.RegistrationAppBackend.Exception.DuplicateResourceException;
import com.RegistrationAppBackend.Exception.ResourceNotFound;
import com.RegistrationAppBackend.dao.ContactDao;
import com.RegistrationAppBackend.model.Contact;
import com.RegistrationAppBackend.registrationrequest.ContactRegistrationRequest;
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

    public void AddContact(ContactRegistrationRequest request){
        String email=request.email();
        if (contactDao.ExistContactByEmail(email)){
            throw new DuplicateResourceException("this email is already taken");
        }
        Contact contact = new Contact(request.name(), request.email(), request.message());
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
