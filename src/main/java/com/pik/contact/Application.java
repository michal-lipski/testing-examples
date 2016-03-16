
package com.pik.contact;

import java.io.IOException;

import com.pik.contact.config.Config;
import com.pik.contact.demo.DemoContacts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pik.contact.service.ContactService;


@ComponentScan
@EnableAutoConfiguration
@ContextConfiguration(classes = Config.class)
@EnableTransactionManagement
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
    
    public static void main(String... args) throws IOException {
        ApplicationContext appContext = SpringApplication.run(Application.class, args);

//        DemoContacts demoContacts = appContext.getBean(DemoContacts.class);
//        demoContacts.createDefaultContacts();
    }
}