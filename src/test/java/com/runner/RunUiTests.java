package com.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report"},
        glue = "com.steps",
        features = "src/test/resources/ui/",
        tags = "@smoke"
)
public class RunUiTests {

}
