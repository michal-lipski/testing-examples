package com.pik.contact.service.integration;

import java.util.List;

import com.pik.contact.service.ContactService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pik.contact.Application;
import com.pik.contact.domain.Contact;

import static org.assertj.core.api.Assertions.assertThat;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ContactServiceTest {
    @Autowired
    private ContactService contactService;

    @After
    public void tearDown() {
        contactService.deleteAllContacts();
    }

    
    @Test
    public void saves_new_contact() {
        Contact contact = contactService.saveContact(new Contact("John", "Doe"));

        Contact found = contactService.getContact(contact.getId());

        assertThat(found).isEqualTo(contact);
    }
    
    @Test
    public void testSearchContact() {
        Contact contact1 = contactService.saveContact(new Contact("John", "Doe"));
        Contact contact2 = contactService.saveContact(new Contact("Johnny", "Smith"));

        List<Contact> contacts = contactService.searchContacts("John");

        assertThat(contacts).containsOnly(contact1,contact2);
    }
}
