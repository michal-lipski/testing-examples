springboot-angularjs-demo
=========================

# BUILD

mvn clean package

# RUN

You can launch the Java server within your IDE, by running the Application class at the root of your application's Java package.

As it is a simple "Main" class, it is the easiest and quickest way to run and debug the application.

If you prefer to use Maven, you can also run your application by typing:

mvn spring-boot:run

The application will be available on http://localhost:8080


# TESTS

* Unit


# WEB

$ npm install
$ npm install -g karma-cli
$ karma start config/karma.conf.js

https://karma-runner.github.io/latest/intro/installation.html
https://karma-runner.github.io/latest/intro/configuration.html
