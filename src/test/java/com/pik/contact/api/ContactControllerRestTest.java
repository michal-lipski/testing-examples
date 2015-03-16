package com.pik.contact.api;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.pik.contact.Application;
import com.pik.contact.domain.Contact;
import com.pik.contact.service.ContactService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ContactControllerRestTest {


    private ContactService contactService = mock(ContactService.class);

    @Before
    public void setUp() throws Exception {
        RestAssuredMockMvc.standaloneSetup(new ContactController(contactService));
    }

    @Test
    public void handles_request_to_export_product() throws Exception {
        given().
                contentType("application/json").
                request().body("{\"name\":\"John\",\"fullName\":\"Doe\"}").
        when().
                post("rest/contacts").
        then().
                statusCode(HttpStatus.CREATED.value());

        verify(contactService).saveContact(new Contact("John", "Doe"));
    }


}
