package com.cydeo.step_definitions;

import com.cydeo.pages.Symund_Logout_Webpage;
import com.cydeo.pages.Symund_WebPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class Logout_Step_Definitions extends Symund_WebPage {
Symund_Logout_Webpage webpage = new Symund_Logout_Webpage();

    @Given("User is on the Dashboard Page")
    public void user_is_on_the_dashboard_page() {
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
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
    }

}
