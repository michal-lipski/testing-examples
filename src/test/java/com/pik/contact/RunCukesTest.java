package com.pik.contact;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format   = {"json:target/cucumber.json"},
        glue = {"com/pik/contact","cucumber.runtime.java.spring.hooks"})
public class RunCukesTest {
}
