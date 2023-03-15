package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                //"pretty",
                "json:target/cucumber-report.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",},
        features = "src/test/resources/features",
        glue = "com/cydeo/step_definitions",
        tags = "@second",
        dryRun = true,
        publish = true


)

public class CukesRunner {
}
