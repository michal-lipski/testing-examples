
package com.pik.contact.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pik.contact.domain.Contact;
import com.pik.contact.repository.ContactRepository;


@Service
@Transactional(readOnly = true)
public class ContactService {
    private final AtomicInteger idGeneration = new AtomicInteger(1000);
    
    @Autowired
    private ContactRepository contactRepo;


    public List<Contact> searchContacts(String keyword) {
        keyword = (keyword == null) ? "" : keyword.toLowerCase();

        return contactRepo.searchContacts(keyword);
    }

    public Contact load(String id) {
        return contactRepo.findOne(id);
    }

    @Transactional
    public Contact saveContact(@Valid Contact contact) {
        if (contact.getId() == null) {
            contact.setId(String.valueOf(idGeneration.incrementAndGet()));
        }

        return contactRepo.save(contact);
    }

    @Transactional
    public void deleteContacts(String id) {
        contactRepo.deleteContact(id);
    }
    
    @Transactional
    public void deleteAllContacts() {
        contactRepo.deleteAllInBatch();
    }

}
