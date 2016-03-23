package com.pik.contact.unit;


import com.pik.contact.domain.Contact;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactTest {

    @Test
    public void can_be_updated() {
        Contact contact = aContact("John", "Doe");

        contact.updateWith(aContact("John", "Smith"));

        assertThat(contact.getFullName()).isEqualTo("Sgmith");
    }

    private Contact aContact(String name, String fullName) {
        return new Contact(name, fullName, null, null, null, null);
    }
}
