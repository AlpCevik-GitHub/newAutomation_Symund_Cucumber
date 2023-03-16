package com.cydeo.step_definitions;

import com.cydeo.pages.Symund_WebPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.List;
import java.util.Map;

public class Login_Step_Definitions {
    Symund_WebPage webPage = new Symund_WebPage();

    /* @Given("user is on the Symund login page")
     public void user_is_on_the_symund_login_page() {

         Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
     }*/
    @Given("user is on the Symund login page")
    public void user_is_on_the_symund_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("environment"));
    }

    @When("user enters employee username in username field")
    public void user_enters_employee_in_username_field(Map<String, String> string) {
        webPage.inputUsername.sendKeys(string.get("username"));
    }

    @When("user enters employee password in  password field")
    public void user_enters_employee_in_password_field(Map<String, String> string) {
        webPage.inputPassword.sendKeys(string.get("password"));
    }

    @When("user hit the enter or click  login button")
    public void user_hit_the_login_button() {
        webPage.logInButton.click();
    }

    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {

        String expected = "Set status";
        String actual = webPage.setStatus.getText().trim();
        Assert.assertEquals(expected, actual);

    }

    @When("user enters employee {string} and {string}")
    public void user_enters_employee_and(String string, String string2) {

        webPage.inputUsername.sendKeys(string);
        webPage.inputPassword.sendKeys(string2);
    }


    @Then("user should see wrong message")
    public void user_should_see_wrong_message() {
        String expected = "Wrong username or password.";
        String actual = webPage.wrongMessage.getText();
        Assert.assertEquals(expected, actual);

    }

    @Then("user should see Please fill out this field message")
    public void user_should_see_please_fill_out_this_field_message() {

    }

    @When("user can see Forgot password? link")
    public void user_can_see_forgot_password_link() {
        Assert.assertTrue(webPage.forgotPasswordLink.isDisplayed());
        System.out.println("webPage.forgotPasswordLink.isDisplayed() = " + webPage.forgotPasswordLink.isDisplayed());
    }

    @When("user click on forget password link")
    public void user_click_on_forget_password_link() {
        webPage.forgotPasswordLink.click();
    }

    @Then("user can see the Reset Password button on the next page")
    public void user_can_see_the_reset_password_button_on_the_next_page() {
        Assert.assertTrue(webPage.resetButton.isDisplayed());
        System.out.println("webPage.resetButton.isDisplayed() = " + webPage.resetButton.isDisplayed());

    }

    @When("User can see the password in a form of dots by default")
    public void user_can_see_the_password_in_a_form_of_dots_by_default() {
        String expected = "Password";
        String actual = webPage.placeHolderPassword.getAttribute("placeholder");
        Assert.assertEquals(expected, actual);
        System.out.println(actual);
    }

}
