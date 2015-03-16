package com.pik.contact.api;

import com.pik.contact.domain.Contact;
import com.pik.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;


@RestController
@RequestMapping(value = "/rest/contacts")
public class ContactController extends BaseController {
    @Autowired
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    public ContactController() {
    }

    @RequestMapping(method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Contact> searchContacts(@RequestParam(defaultValue = "") String keyword) {
        return contactService.searchContacts(keyword);
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public String createContact(@RequestBody @Valid Contact contact) {
        Contact saveContact = contactService.saveContact(contact);
        return saveContact.getId();
    }

    @RequestMapping(value = "/{id}", method = PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Contact updateContact(@PathVariable String id, @RequestBody @Valid Contact contact) {
        return contactService.saveContact(contact);
    }

    @RequestMapping(method = DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteContacts(@RequestParam String[] ids) {
        contactService.deleteContacts(ids);
    }
}
