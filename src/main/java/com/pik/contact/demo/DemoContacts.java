
package com.pik.contact.demo;

import com.pik.contact.domain.Contact;
import com.pik.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
@Profile("demo")
public class DemoContacts {

    private ContactService contactService;

    @Autowired
    public DemoContacts(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostConstruct
    public void createDefaultContacts() {
        contactService.saveContact(new Contact("David", "David Byrne", "Project Manager", "dbyrne@company.com", "123 456 7890", "dbyrne90"));
        contactService.saveContact(new Contact("John", "John Smith", "Business Analyst", "jsmith@company.com", "123 456 7891", "jsmith91"));
        contactService.saveContact(new Contact("Diana", "Diana Lopez", "Software Architect", "dlopez@company.com", "123 456 7892", "dlopez92"));
        contactService.saveContact(new Contact("Sarah", "Sarah Leggett", "Software Engineer", "sleggett@company.com", "123 456 7893", "sleggett93"));
        contactService.saveContact(new Contact("Carol", "Carol Ling", "Senior Software engineer", "cling@company.com", "123 567 8944", "cling94"));
        contactService.saveContact(new Contact("Pete", "Petter Brown", "Quality Analyst", "pbrown@company.com", "123 456 7895", "pbrown95"));
    }
}
