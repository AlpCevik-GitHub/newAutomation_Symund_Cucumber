package com.cydeo.step_definitions;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {


    /*@Before
    public void logInMethod() {

        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));

    }*/



    @BeforeStep
    public void beforeStep() {
        System.out.println("this is before step!!!");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("this is after step!!!");
    }


    @After
    public void tearDownScenario(Scenario scenario) {


        if (scenario.isFailed()) {


            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();

    }


}
