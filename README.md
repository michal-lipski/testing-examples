Java application testing examples
=========================

### BUILD

mvn clean package

### RUN

You can launch the Java server within your IDE, by running the Application class at the root of your application's Java package.
As it is a simple "Main" class, it is the easiest and quickest way to run and debug the application.
If you prefer to use Maven, you can also run your application by typing:

`mvn spring-boot:run`

The application will be available on `http://localhost:8080`


### TESTS examples

Application is tested using different kids of test:

* Unit

[src/test/java/com/pik/contact/unit/ContactTest.java](src/test/java/com/pik/contact/unit/ContactTest.java)

* Unit with mocks

[src/test/java/com/pik/contact/service/unit/ContactServiceTest.java]()

* Integration test

[src/test/java/com/pik/contact/service/integration/ContactServiceTest.java

* Spring mvc test for REST endpoint

[src/test/java/com/pik/contact/api/ContactControllerTest.java

* Cucumber acceptance test

[src/test/java/com/pik/contact/cucumber/RunCukesTest.java
[src/test/resources/com/pik/contact/cucumber/contacts.feature

* GUI test with Selenium (with Page Object pattern)

[src/test/java/com/pik/contact/gui/selenium/test/ContactsTest.java

alternative is to use Geb testing framework (https://github.com/geb/geb)

* PIT mutation tests (http://pitest.org/)

PIT is configured in maven [src/pom/xml](src/pom/xml)and can be run with: `mvn pitest:mutationCoverage`



