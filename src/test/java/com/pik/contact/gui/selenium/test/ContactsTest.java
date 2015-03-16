package com.pik.contact.gui.selenium.test;

import com.pik.contact.gui.selenium.pageobjects.ContactsPage;
import org.junit.AfterClass;
import org.junit.Test;

import static com.pik.contact.gui.selenium.setup.SeleniumDriver.getDriver;
import static org.assertj.core.api.Assertions.assertThat;


public class ContactsTest {

    @AfterClass
    public static void tearDown() {
        getDriver().close();
    }

    @Test
    public void should_display_contact() throws Exception {
        //given
        ContactsPage contactsPage = new ContactsPage().open();
        //when
        contactsPage.find("John");
        //then
        assertThat(contactsPage.firstContactTitle()).isEqualTo("John");
    }
}
