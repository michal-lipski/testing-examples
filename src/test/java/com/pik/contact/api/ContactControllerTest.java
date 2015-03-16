package com.pik.contact.api;

import com.pik.contact.Application;
import com.pik.contact.domain.Contact;
import com.pik.contact.repository.ContactRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ContactControllerTest {

    @Autowired
    ContactRepository repository;

    @Autowired
    ContactController controller;

    @Before
    public void setup() {
        repository.deleteAll();
        mockMvc = buildMockMvc(controller);
    }

    protected MockMvc mockMvc;

    protected MockMvc buildMockMvc(Object... controllers) {
        return MockMvcBuilders
                .standaloneSetup(controllers)
                .build();
    }

    @Test
    public void shouldSaveProduct() throws Exception {
        MvcResult result = mockMvc.perform(post("/rest/contacts").contentType(APPLICATION_JSON)
                .content("{\"name\":\"John\",\"fullName\":\"Doe\"}"))
                .andExpect(status().isCreated())
                .andReturn();

        Contact contact = repository.findOne(result.getResponse().getContentAsString());
        assertThat(contact.getName()).isEqualTo("John");
        assertThat(contact.getFullName()).isEqualTo("Doe");
    }


}
