package com.cydeo.step_definitions;

import com.cydeo.pages.Symund_Logout_Webpage;
import com.cydeo.pages.Symund_WebPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.假如;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class Logout_Step_Definitions extends Symund_WebPage {
Symund_Logout_Webpage webpage = new Symund_Logout_Webpage();


    @Given("user is on the dashboard page")
    public void user_is_on_the_dashboard_page() {

        login("Employee40","Employee123");

    }

    @When("User click log out button")
    public void user_click_log_out_button() throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(webpage.E_Button).clickAndHold();
        Thread.sleep(3000);
        actions.moveToElement(webpage.logOut).click();
    }
    @Then("User ends up in login page")
    public void user_ends_up_in_login_page() {
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        String expected = Driver.getDriver().getTitle();
        String actual = "Dashboard - Symund - QA";
        Assert.assertEquals(expected,actual);
    }


    @When("User click  step back button")
    public void user_click_step_back_button() {
       Driver.getDriver().navigate().back();

    }
    @Then("User can not go to home page")
    public void user_can_not_go_to_home_page() {
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
        String expected = Driver.getDriver().getTitle();
        String actual = "Dashboard - Symund - QA";
        Assert.assertEquals(expected,actual);
    }





}
