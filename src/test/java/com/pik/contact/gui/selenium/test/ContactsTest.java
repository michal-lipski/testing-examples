package com.pik.contact.gui.selenium.test;

import com.pik.contact.Application;
import com.pik.contact.gui.selenium.pageobjects.ContactsPage;
import com.pik.contact.gui.selenium.setup.SeleniumDriver;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.pik.contact.gui.selenium.setup.SeleniumDriver.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:8090")
public class ContactsTest {

    @Value("${local.server.port}")
    int port;

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
